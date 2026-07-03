import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import chip.devicecontroller.ChipClusters
import chip.devicecontroller.ChipDeviceController
import chip.devicecontroller.ChipStructs
import com.google.chip.chiptool.ChipClient
import com.google.chip.chiptool.R
import com.google.chip.chiptool.clusterclient.AddressUpdateFragment
import com.google.chip.chiptool.databinding.CameraFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.webrtc.DataChannel
import org.webrtc.DefaultVideoDecoderFactory
import org.webrtc.DefaultVideoEncoderFactory
import org.webrtc.EglBase
import org.webrtc.IceCandidate
import org.webrtc.MediaConstraints
import org.webrtc.MediaStream
import org.webrtc.MediaStreamTrack
import org.webrtc.PeerConnection
import org.webrtc.PeerConnectionFactory
import org.webrtc.RtpReceiver
import org.webrtc.RtpTransceiver
import org.webrtc.SdpObserver
import org.webrtc.SessionDescription
import org.webrtc.VideoTrack
import java.util.Optional

class CameraFragment : Fragment() {
    private val deviceController: ChipDeviceController
        get() = ChipClient.getDeviceController(requireContext())

    private lateinit var scope: CoroutineScope
    private lateinit var addressUpdateFragment: AddressUpdateFragment

    private var _binding: CameraFragmentBinding? = null
    private val binding
        get() = _binding!!

    private var eglBase: EglBase? = null
    private var peerConnectionFactory: PeerConnectionFactory? = null
    private var peerConnection: PeerConnection? = null
    private var remoteVideoTrack: VideoTrack? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CameraFragmentBinding.inflate(inflater, container, false)
        scope = viewLifecycleOwner.lifecycleScope

        addressUpdateFragment =
            childFragmentManager.findFragmentById(R.id.addressUpdateFragment) as AddressUpdateFragment

        initWebRTC()
        createPeerConnection()

        setupLocalLiveViewListeners()
        setupRemoteLiveViewListeners()

        setupRadioGroupListener()

        return binding.root
    }

    private fun setupLocalLiveViewListeners() {
        binding.liveviewLocalAllocateVideoStreamBtn.setOnClickListener {
            val width = binding.liveviewLocalWidthEditText.text.toString().toUIntOrNull() ?: 0U
            val height = binding.liveviewLocalHeightSEditText.text.toString().toUIntOrNull() ?: 0U

            scope.launch { sendAllocateVideoStream(width, height) }
        }

        binding.startLiveviewBtn.setOnClickListener {
            val width = binding.liveviewLocalWidthEditText.text.toString().toUIntOrNull() ?: 0U
            val height = binding.liveviewLocalHeightSEditText.text.toString().toUIntOrNull() ?: 0U

            startLiveView(width, height)
        }

        binding.stopLiveviewBtn.setOnClickListener {
            val streamID = binding.liveviewLocalWebRTCSessionIdTextView.text.toString().toUIntOrNull() ?: 0U
            scope.launch { stopLiveView(streamID) }
        }

        binding.liveviewLocalDeallocateVideoStreamBtn.setOnClickListener {
            val streamID = binding.liveviewLocalVideoStreamIdTextView.text.toString().toUIntOrNull() ?: 0U
            scope.launch { sendDeallocateVideoStream(streamID) }
        }
    }

    private suspend fun sendAllocateVideoStream(width: UInt, height: UInt) {
        val devicePtr =
            try {
                ChipClient.getConnectedDevicePointer(requireContext(), addressUpdateFragment.deviceId)
            } catch (e: IllegalStateException) {
                Log.d(TAG, "getConnectedDevicePointer exception", e)
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Get DevicePointer fail! : $e", Toast.LENGTH_LONG).show()
                }
                return
            }

        val cluster = ChipClusters.CameraAvStreamManagementCluster(devicePtr, addressUpdateFragment.endpointId)

        // https://github.com/CHIP-Specifications/connectedhomeip-spec/blob/9c894019866348d324bf07a8664f56603e4b8537/src/app_clusters/cameras.adoc?plain=1#L139
        val streamUsage = 3U // LiveView

        // https://github.com/CHIP-Specifications/connectedhomeip-spec/blob/9c894019866348d324bf07a8664f56603e4b8537/src/app_clusters/CameraAVStreamManagement.adoc?plain=1#L229
        val videoCodec = 0U // H264

        val minFrameRateWidth = 30
        val maxFrameRateWidth = 120

        val minResolution = ChipStructs.CameraAvStreamManagementClusterVideoResolutionStruct(640, 480)
        val maxResolution = ChipStructs.CameraAvStreamManagementClusterVideoResolutionStruct(1920, 1080)

        val minBitRate = 30L
        val maxBitRate = 120L
        val keyFrameInterval = 4000
        val watermarkEnabled = Optional.of<Boolean>(false)
        val osdEnabled = Optional.of<Boolean>(false)

        cluster.videoStreamAllocate(object:ChipClusters.CameraAvStreamManagementCluster.VideoStreamAllocateResponseCallback {
            override fun onSuccess(videoStreamID: Int?) {
                Log.d(TAG, "onSuccess VideoStreamID : $videoStreamID")
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "videoStreamAllocate Success : $videoStreamID", Toast.LENGTH_LONG).show()
                    binding.liveviewLocalVideoStreamIdTextView.text = videoStreamID?.toString() ?: "0"
                }
            }

            override fun onError(error: java.lang.Exception?) {
                Log.d(TAG, "onError exception", error)
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "videoStreamAllocate Error : $error", Toast.LENGTH_LONG).show()
                }
            }

        }, streamUsage.toInt(), videoCodec.toInt(), minFrameRateWidth, maxFrameRateWidth, minResolution, maxResolution, minBitRate, maxBitRate, keyFrameInterval, watermarkEnabled, osdEnabled)
    }

    private fun startLiveView(width: UInt, height: UInt) {

    }

    private suspend fun stopLiveView(sessionID: UInt) {
        val devicePtr =
            try {
                ChipClient.getConnectedDevicePointer(requireContext(), addressUpdateFragment.deviceId)
            } catch (e: IllegalStateException) {
                Log.d(TAG, "getConnectedDevicePointer exception", e)
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Get DevicePointer fail! : $e", Toast.LENGTH_LONG).show()
                }
                return
            }

        val cluster = ChipClusters.WebRTCTransportProviderCluster(devicePtr, addressUpdateFragment.endpointId)

        // https://github.com/CHIP-Specifications/connectedhomeip-spec/blob/9c894019866348d324bf07a8664f56603e4b8537/src/app_clusters/webrtc.adoc?plain=1#L385
        val reason = 2 // UserHangup

        cluster.endSession(object: ChipClusters.DefaultClusterCallback {
            override fun onSuccess() {
                Log.d(TAG, "onSuccess")
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "endSession Success", Toast.LENGTH_LONG).show()
                }
            }

            override fun onError(error: java.lang.Exception?) {
                Log.d(TAG, "onError exception", error)
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "endSession Error : $error", Toast.LENGTH_LONG).show()
                }
            }

        }, sessionID.toInt(), reason)
    }

    private suspend fun sendDeallocateVideoStream(streamID : UInt) {
        val devicePtr =
            try {
                ChipClient.getConnectedDevicePointer(requireContext(), addressUpdateFragment.deviceId)
            } catch (e: IllegalStateException) {
                Log.d(TAG, "getConnectedDevicePointer exception", e)
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Get DevicePointer fail! : $e", Toast.LENGTH_LONG).show()
                }
                return
            }

        val cluster = ChipClusters.CameraAvStreamManagementCluster(devicePtr, addressUpdateFragment.endpointId)

        cluster.videoStreamDeallocate(object: ChipClusters.DefaultClusterCallback {
            override fun onSuccess() {
                Log.d(TAG, "onSuccess")
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "videoStreamDeallocate Success", Toast.LENGTH_LONG).show()
                }
            }

            override fun onError(error: java.lang.Exception?) {
                Log.d(TAG, "onError exception", error)
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "videoStreamDeallocate Error : $error", Toast.LENGTH_LONG).show()
                }
            }

        }, streamID.toInt())
    }

    private fun setupRemoteLiveViewListeners() {
        binding.createOfferBtn.setOnClickListener {
            createOffer()
        }

        binding.setAnswerBtn.setOnClickListener {
            val base64AnswerSdp = binding.answerSdpEditText.text.toString()
            if (base64AnswerSdp.isNotBlank()) {
                try {
                    val decodedBytes = Base64.decode(base64AnswerSdp, Base64.DEFAULT)
                    val decodedSdpStr = String(decodedBytes, Charsets.UTF_8)

                    Log.d(TAG, "Decoded Answer SDP:\n$decodedSdpStr")

                    setRemoteDescription(decodedSdpStr)
                } catch (e: IllegalArgumentException) {
                    Log.e(TAG, "Failed to decode Base64 SDP", e)
                    Toast.makeText(requireContext(), "Invalid Base64 format.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please enter Answer SDP.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupRadioGroupListener() {
        binding.radioGroupMode.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.LiveViewLocalRadioButton -> {
                    binding.liveViewLocalScrollView.visibility = View.VISIBLE
                    binding.liveViewRemoteScrollView.visibility = View.GONE
                }
                R.id.LiveViewRemoteRadioButton -> {
                    binding.liveViewLocalScrollView.visibility = View.GONE
                    binding.liveViewRemoteScrollView.visibility = View.VISIBLE
                }
                R.id.SnapshotRadioButton -> {
                    binding.liveViewLocalScrollView.visibility = View.GONE
                    binding.liveViewRemoteScrollView.visibility = View.GONE
                }
            }
        }
    }

    private fun initWebRTC() {
        eglBase = EglBase.create()

        binding.videoView.init(eglBase?.eglBaseContext, null)
        binding.videoView.setEnableHardwareScaler(true)
        binding.videoView.setMirror(false)

        PeerConnectionFactory.initialize(
            PeerConnectionFactory.InitializationOptions.builder(requireContext())
                .setEnableInternalTracer(true)
                .createInitializationOptions()
        )

        val options = PeerConnectionFactory.Options()
        val defaultVideoEncoderFactory = DefaultVideoEncoderFactory(eglBase?.eglBaseContext, true, true)
        val defaultVideoDecoderFactory = DefaultVideoDecoderFactory(eglBase?.eglBaseContext)

        peerConnectionFactory = PeerConnectionFactory.builder()
            .setOptions(options)
            .setVideoEncoderFactory(defaultVideoEncoderFactory)
            .setVideoDecoderFactory(defaultVideoDecoderFactory)
            .createPeerConnectionFactory()
    }

    private fun createPeerConnection() {
        val iceServers = listOf(
            PeerConnection.IceServer.builder("stun:stun.l.google.com:19302").createIceServer()
        )
        val rtcConfig = PeerConnection.RTCConfiguration(iceServers)

        peerConnection = peerConnectionFactory?.createPeerConnection(rtcConfig, peerConnectionObserver)

        peerConnection?.addTransceiver(
            MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO,
            RtpTransceiver.RtpTransceiverInit(RtpTransceiver.RtpTransceiverDirection.RECV_ONLY)
        )

        peerConnection?.addTransceiver(
            MediaStreamTrack.MediaType.MEDIA_TYPE_AUDIO,
            RtpTransceiver.RtpTransceiverInit(RtpTransceiver.RtpTransceiverDirection.RECV_ONLY)
        )
    }

    private val peerConnectionObserver = object : PeerConnection.Observer {
        override fun onSignalingChange(newState: PeerConnection.SignalingState?) {
            Log.d(TAG, "SignalingState: $newState")
            scope.launch(Dispatchers.Main) {
                binding.sessionStateTextView.text = "Signaling State: $newState"
            }
        }

        override fun onIceConnectionChange(newState: PeerConnection.IceConnectionState?) {
            Log.d(TAG, "IceConnectionState: $newState")
            scope.launch(Dispatchers.Main) {
                binding.sessionStateTextView.text = "ICE Connection: $newState"
            }
        }

        override fun onIceConnectionReceivingChange(receiving: Boolean) {}

        override fun onIceGatheringChange(newState: PeerConnection.IceGatheringState?) {
            scope.launch(Dispatchers.Main) {
                binding.iceInfoTextView.text = "ICE Gathering: $newState"

                if (newState == PeerConnection.IceGatheringState.COMPLETE) {
                    Toast.makeText(requireContext(), "ICE Gathering Complete.", Toast.LENGTH_SHORT).show()

                    val completeSdp = peerConnection?.localDescription?.description
                    if (completeSdp != null) {
                        Log.d(TAG, "Complete Offer SDP with ICE Candidates:\n$completeSdp")

                        val base64Sdp = Base64.encodeToString(
                            completeSdp.toByteArray(Charsets.UTF_8),
                            Base64.NO_WRAP
                        )
                        binding.sdpInfoTextView.text = base64Sdp
                    }
                }
            }
        }

        override fun onIceCandidate(candidate: IceCandidate?) {
            if (candidate != null) {
                Log.d(TAG, "New ICE Candidate generated: ${candidate.sdp}")
            }
        }

        override fun onIceCandidatesRemoved(candidates: Array<out IceCandidate>?) {}

        override fun onAddStream(stream: MediaStream?) {}

        override fun onRemoveStream(stream: MediaStream?) {}

        override fun onDataChannel(channel: DataChannel?) {}

        override fun onRenegotiationNeeded() {}

        override fun onAddTrack(receiver: RtpReceiver?, mediaStreams: Array<out MediaStream>?) {
            super.onAddTrack(receiver, mediaStreams)
            val track = receiver?.track()

            if (track is VideoTrack) {
                Log.d(TAG, "Remote Video Track received")
                remoteVideoTrack = track

                scope.launch(Dispatchers.Main) {
                    remoteVideoTrack?.addSink(binding.videoView)
                }
            }
        }
    }

    private fun createOffer() {
        val constraints = MediaConstraints()
        peerConnection?.createOffer(object : SdpObserver {
            override fun onCreateSuccess(sessionDescription: SessionDescription) {
                Log.d(TAG, "Initial Offer SDP created (without ICE candidates yet)")
                peerConnection?.setLocalDescription(this, sessionDescription)
            }

            override fun onSetSuccess() {}

            override fun onCreateFailure(error: String?) {
                scope.launch(Dispatchers.Main) {
                    binding.sdpInfoTextView.text = "Failed to create Offer: $error"
                }
            }

            override fun onSetFailure(error: String?) {}
        }, constraints)
    }

    private fun setRemoteDescription(answerSdp: String) {
        val sessionDescription = SessionDescription(SessionDescription.Type.ANSWER, answerSdp)
        peerConnection?.setRemoteDescription(object : SdpObserver {
            override fun onCreateSuccess(sdp: SessionDescription?) {}

            override fun onSetSuccess() {
                Log.e(TAG, "Answer SDP applied successfully!")
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Answer SDP applied successfully!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCreateFailure(error: String?) {}

            override fun onSetFailure(error: String?) {
                Log.e(TAG, "Failed to apply Answer: $error")
                scope.launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Failed to apply Answer: $error", Toast.LENGTH_LONG).show()
                }
            }
        }, sessionDescription)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        try {
            remoteVideoTrack?.removeSink(binding.videoView)
            peerConnection?.close()
            peerConnection?.dispose()
            peerConnectionFactory?.dispose()
            binding.videoView.release()
            eglBase?.release()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        _binding = null
    }

    companion object {
        private const val TAG = "CameraFragment"
        fun newInstance(): CameraFragment = CameraFragment()
    }
}