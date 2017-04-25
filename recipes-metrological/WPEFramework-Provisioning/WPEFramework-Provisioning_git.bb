SUMMARY = "Provisioning plugin for Metrological's WPEFramework"
HOMEPAGE = "http://www.metrological.com/"
SECTION = "metrological"
#TODO: License
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "WPEFramework libprovision"

PV = "1.0+gitr${SRCPV}"

SRC_URI = "git://git@github.com/Metrological/webbridge.git;protocol=ssh;branch=WPEFramework-Provisioning-Yocto"
SRCREV = "5c319ea71e323d6aad54bc029aafeee56da2cf7f"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE += " \
    -DCMAKE_BUILD_TYPE=Debug \
"

TOOLCHAIN = "gcc"

FILES_${PN} += "/usr/lib/wpeframework/plugins/libWPEFrameworkProvisioning.so \
"


