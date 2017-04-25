SUMMARY = "Open plugins for Metrological's WPEFramework"
HOMEPAGE = "http://www.metrological.com/"
SECTION = "metrological"
#TODO: License
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "WPEFramework libpng wpewebkit"
#DEPENDS_append_libc-musl = " libexecinfo"

PV = "1.0+gitr${SRCPV}"

SRC_URI = "git://git@github.com/Metrological/webbridge.git;protocol=ssh;branch=WPEFramework-Open-Plugins-Yocto"

SRCREV = "2777c0ed3ce18ae245bcf797cda8dfde2bb3fdbb"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

#CXXFLAGS += "-D_GLIBCXX_USE_CXX11_ABI=0"

#WPEFRAMEWORK_PLATFORM ?= "platform-pc"
#WPEFRAMEWORK_PLATFORM_mipsel = "platform-dawn"
#WPEFRAMEWORK_PLATFORM_dawn = "platform-dawn"
#WPEFRAMEWORK_PLATFORM_arm = "platform-eos"
#WPEFRAMEWORK_PLATFORM_eos = "platform-eos"
#WPEFRAMEWORK_PLATFORM_rpi = "platform-rpi"

#PACKAGECONFIG ?= "${WPEFRAMEWORK_PLATFORM} cryptalgo generics process tracing websocket rpc"

#PACKAGECONFIG[platform-dawn] += "-DWPEFRAMEWORK_PLATFORM=DAWN,,broadcom-refsw"
#PACKAGECONFIG[platform-eos] += "-DWPEFRAMEWORK_PLATFORM=EOS,,broadcom-refsw"
#PACKAGECONFIG[platform-intelce] += "-DWPEFRAMEWORK_PLATFORM=INTELCE,,intelce-osal intelce-cosai"
#PACKAGECONFIG[platform-pc] += "-DWPEFRAMEWORK_PLATFORM=PC_UNIX,,"
#PACKAGECONFIG[platform-rpi] += "-DWPEFRAMEWORK_PLATFORM=RPI,,virtual/egl"
#PACKAGECONFIG[platform-xi5] += "-DWPEFRAMEWORK_PLATFORM=XI5,,broadcom-refsw"

#PACKAGECONFIG[cryptalgo] = "-DCPPSDK_CRYPTALGO=ON,-DCPPSDK_CRYPTALGO=OFF,"
#PACKAGECONFIG[debug] = "-DCPPSDK_DEBUG=ON,-DCPPSDK_DEBUG=OFF,"
#PACKAGECONFIG[devices] = "-DCPPSDK_DEVICES=ON,-DCPPSDK_DEVICES=OFF,"
#PACKAGECONFIG[generics] = "-DCPPSDK_GENERICS=ON,-DCPPSDK_GENERICS=OFF,"
#PACKAGECONFIG[tracing] = "-DCPPSDK_TRACING=ON,-DCPPSDK_TRACING=OFF,"
#PACKAGECONFIG[unittests] = "-DCPPSDK_UNIT_TESTS=ON,-DCPPSDK_UNIT_TESTS=OFF,"
#PACKAGECONFIG[websocket] = "-DCPPSDK_WEBSOCKET=ON,-DCPPSDK_WEBSOCKET=OFF,"
#PACKAGECONFIG[rpc] = "-DCPPSDK_RPC=ON,-DCPPSDK_RPC=OFF,"
#PACKAGECONFIG[process] = "-DCPPSDK_PROCESS=ON,-DCPPSDK_PROCESS=OFF,"

EXTRA_OECMAKE += " \
    -DCMAKE_BUILD_TYPE=Debug \
    -DWPEFRAMEWORK_PLUGIN_COMMANDER=ON \
    -DWPEFRAMEWORK_PLUGIN_DEVICEINFO=ON \
    -DWPEFRAMEWORK_PLUGIN_LOCATIONSYNC=ON \
    -DWPEFRAMEWORK_PLUGIN_MONITOR=ON \
    -DWPEFRAMEWORK_PLUGIN_REMOTECONTROL=ON \
    -DWPEFRAMEWORK_PLUGIN_SNAPSHOT=ON \
    -DWPEFRAMEWORK_PLUGIN_TIMESYNC=ON \
    -DWPEFRAMEWORK_PLUGIN_TRACECONTROL=ON \
    -DWPEFRAMEWORK_PLUGIN_WEBKITBROWSER=ON \
    -DWPEFRAMEWORK_PLUGIN_WEBPROXY=ON \
    -DWPEFRAMEWORK_PLUGIN_WEBSERVER=ON \
    -DWPEFRAMEWORK_PLUGIN_WEBSHELL=ON \
"

#CXXFLAGS_append_rpi = " -I${STAGING_INCDIR}/interface/vmcs_host/linux"

TOOLCHAIN = "gcc"

FILES_${PN} += "/usr/lib/wpeframework/plugins/libWPEFrameworkCommander.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkDeviceInfo.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkLocationSync.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkMonitor.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkRemoteControl.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkSnapshot.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkTimeSync.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkTraceControl.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkWebKitBrowser.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkWebProxy.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkWebServer.so \
                /usr/lib/wpeframework/plugins/libWPEFrameworkWebShell.so \
                /usr/share/WPEFramework/WebKitBrowser/libWPEInjectedBundle.so \
                /usr/share/WPEFramework/RemoteControl/keymap.json \
"


