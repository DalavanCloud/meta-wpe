SUMMARY = "WPE Framework Netflix plugin"
HOMEPAGE = "https://github.com/WebPlatformForEmbedded"
SECTION = "wpe"
LICENSE = "CLOSED"

DEPENDS = "wpeframework netflix libprovision"

PV = "3.0+gitr${SRCPV}"

SRC_URI = "git://git@github.com/WebPlatformForEmbedded/WPEPluginNetflix.git;protocol=ssh;branch=master \
		   file://0001-cmake-Remove-redundant-include.patch"
SRCREV = "c94552bad6e793fdfcb157abd3d86e1015d46ed0"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

PACKAGECONFIG ?= ""
PACKAGECONFIG[debug]            = "-DCMAKE_BUILD_TYPE=Debug,-DCMAKE_BUILD_TYPE=Release,"
PACKAGECONFIG[hd]               = "-DWPEFRAMEWORK_PLUGIN_NETFLIX_FULLHD=true,-DWPEFRAMEWORK_PLUGIN_NETFLIX_FULLHD=false,"


# ----------------------------------------------------------------------------

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/wpeframework/plugins/*.so"

# ----------------------------------------------------------------------------

RDEPENDS_${PN} = "wpeframework-dialserver wpeframework-provisioning"

TOOLCHAIN = "gcc"
