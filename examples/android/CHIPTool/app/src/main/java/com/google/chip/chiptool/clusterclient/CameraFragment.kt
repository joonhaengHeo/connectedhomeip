import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import chip.devicecontroller.ChipDeviceController
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
        setupListeners()

        return binding.root
    }

    private fun setupListeners() {
        binding.btnCreateOffer.setOnClickListener {
            createOffer()
        }

        binding.btnSetAnswer.setOnClickListener {
            val base64AnswerSdp = binding.etAnswerSdp.text.toString()
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

    private fun initWebRTC() {
        eglBase = EglBase.create()

        binding.remoteVideoView.init(eglBase?.eglBaseContext, null)
        binding.remoteVideoView.setEnableHardwareScaler(true)
        binding.remoteVideoView.setMirror(false)

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
                binding.tvSessionState.text = "Signaling State: $newState"
            }
        }

        override fun onIceConnectionChange(newState: PeerConnection.IceConnectionState?) {
            Log.d(TAG, "IceConnectionState: $newState")
            scope.launch(Dispatchers.Main) {
                binding.tvSessionState.text = "ICE Connection: $newState"
            }
        }

        override fun onIceConnectionReceivingChange(receiving: Boolean) {}

        override fun onIceGatheringChange(newState: PeerConnection.IceGatheringState?) {
            scope.launch(Dispatchers.Main) {
                binding.tvIceInfo.text = "ICE Gathering: $newState"

                if (newState == PeerConnection.IceGatheringState.COMPLETE) {
                    Toast.makeText(requireContext(), "ICE Gathering Complete.", Toast.LENGTH_SHORT).show()

                    val completeSdp = peerConnection?.localDescription?.description
                    if (completeSdp != null) {
                        Log.d(TAG, "Complete Offer SDP with ICE Candidates:\n$completeSdp")

                        val base64Sdp = Base64.encodeToString(
                            completeSdp.toByteArray(Charsets.UTF_8),
                            Base64.NO_WRAP
                        )
                        binding.tvSdpInfo.text = base64Sdp
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
                    remoteVideoTrack?.addSink(binding.remoteVideoView)
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
                    binding.tvSdpInfo.text = "Failed to create Offer: $error"
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
            remoteVideoTrack?.removeSink(binding.remoteVideoView)
            peerConnection?.close()
            peerConnection?.dispose()
            peerConnectionFactory?.dispose()
            binding.remoteVideoView.release()
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