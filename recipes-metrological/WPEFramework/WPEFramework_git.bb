SUMMARY = "Metrological's WPEFramework"
HOMEPAGE = "http://www.metrological.com/"
SECTION = "metrological"
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "zlib userland"
DEPENDS_append_libc-musl = " libexecinfo"

PV = "1.0+gitr${SRCPV}"

SRC_URI = "git://git@github.com/Metrological/cppsdk.git;protocol=ssh;branch=WPEFramework"
SRCREV = "b325aa163dfe86c02a75deb86d4f30875db44d7a"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

WPEFRAMEWORK_PLATFORM ?= "platform-pc"
WPEFRAMEWORK_PLATFORM_mipsel = "platform-dawn"
WPEFRAMEWORK_PLATFORM_dawn = "platform-dawn"
WPEFRAMEWORK_PLATFORM_arm = "platform-eos"
WPEFRAMEWORK_PLATFORM_eos = "platform-eos"
WPEFRAMEWORK_PLATFORM_rpi = "platform-rpi"

#PACKAGECONFIG ?= "${WPEFRAMEWORK_PLATFORM} cryptalgo generics process tracing websocket rpc"

PACKAGECONFIG[platform-dawn] += "-DWPEFRAMEWORK_PLATFORM=DAWN,,broadcom-refsw"
PACKAGECONFIG[platform-eos] += "-DWPEFRAMEWORK_PLATFORM=EOS,,broadcom-refsw"
PACKAGECONFIG[platform-intelce] += "-DWPEFRAMEWORK_PLATFORM=INTELCE,,intelce-osal intelce-cosai"
PACKAGECONFIG[platform-pc] += "-DWPEFRAMEWORK_PLATFORM=PC_UNIX,,"
PACKAGECONFIG[platform-rpi] += "-DWPEFRAMEWORK_PLATFORM=RPI,,virtual/egl"
PACKAGECONFIG[platform-xi5] += "-DWPEFRAMEWORK_PLATFORM=XI5,,broadcom-refsw"

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
    -DWPEFRAMEWORK_TEST_APPS=ON -DWPEFRAMEWORK_TEST_LOADER=ON \
    -DINSTALL_HEADERS_TO_TARGET=ON \
    -DCMAKE_BUILD_TYPE=Debug \
    -DWPEFRAMEWORK_VIRTUALINPUT=ON \
"

#CXXFLAGS_append_rpi = " -I${STAGING_INCDIR}/interface/vmcs_host/linux"

TOOLCHAIN = "gcc"

FILES_${PN} += "/usr/lib/wpeframework/proxystubs/libWPEFrameworkInterfaces.so \
                /usr/lib/wpeframework/proxystubs/libWPEFrameworkProxyStubs.so \
"

