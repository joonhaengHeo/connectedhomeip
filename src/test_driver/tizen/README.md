# CHIP Tests on QEMU

Tizen runs mostly on ARM architecture. In order to run tests on Tizen, we need
to use QEMU. This document describes how to build and run CHIP tests on QEMU.

## Obtaining Tizen QEMU Docker Image

All tools and dependencies required to build and run tests on Tizen on QEMU are
included in the `chip-build-tizen-qemu` docker image. One can pull the docker
image from hub.docker.com or build it locally using the provided Dockerfile in
`integrations/docker/images/chip-build-tizen-qemu` directory.

```sh
# Pull the image from hub.docker.com
docker pull ghcr.io/project-chip/chip-build-tizen-qemu:153
```

## Building and Running Tests on QEMU

All steps described below should be done inside the docker container.

```sh
docker run -it --rm --name chip-tizen-qemu \
    ghcr.io/project-chip/chip-build-tizen-qemu:153 /bin/bash
```

### Clone the connectedhomeip repository

```sh
git clone https://github.com/project-chip/connectedhomeip.git
```

### Activate the environment

```sh
cd connectedhomeip
source scripts/activate.sh
```

### Generate and run test target

As for now, Tizen QEMU-based test driver does not support BLE. In order to
disable BLE, one needs to pass `chip_config_network_layer_ble=false` to the args
argument of the `gn gen` command.

```sh
# Generate test target
gn gen --check --fail-on-unused-args \
    --root="$PWD/src/test_driver/tizen" \
    --args="target_os=\"tizen\" target_cpu=\"arm\" \
        tizen_sdk_root=\"$TIZEN_SDK_ROOT\" \
        tizen_sdk_sysroot=\"$TIZEN_SDK_SYSROOT\"
        chip_config_network_layer_ble=false" \
    out/tizen-check
# Run Tizen QEMU-based tests
ninja -C out/tizen-check check
```

## Debugging Tests on QEMU

When running tests with `ninja -C out/tizen-check check`, the test driver prints
the command to run the test on QEMU. Please search for the following line in the
output of the `ninja` command: `INFO:root:run: qemu-system-arm`. Make sure that
your terminal does not limit the number of lines printed, or simply redirect the
output to a file as follows:

```sh
ninja -C out/tizen-check check > ninja-tizen-check.log 2>&1
```

Then, use the run command and add the `rootshell` keyword to kernel arguments
passed to QEMU (the string after the `-append` option). This will run QEMU, but
instead of running the test, it will drop you to the shell. From there, you can
run the test manually by typing `/mnt/chip/runner.sh`.

## Analyzing core dumps

In order for GDB to work correctly, same sysroot as is present on QEMU must be
provided.

-   Create sysroot directory
-   Mount `/opt/tizen-sdk/iot-rootfs.img`
-   Copy `/usr` from the mounted image to your sysroot directory
-   Fix potentially broken symlinks in the libraries as needed

Core dumps are generated in the `dump` directory as a zip archive file. After
extracting it the core dump should be extracted from tar archive file.

Set GDB config

```
set auto-load safe-path /
set sysroot /path/to/sysroot/
```

And then run `gdb-multiarch` specifying `.coredump` file extracted before, your
GDB config file if present and lastly the executable.
