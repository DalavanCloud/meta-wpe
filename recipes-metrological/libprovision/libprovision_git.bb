# Copyright (C) 2016 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Provisioning support library"
HOMEPAGE = "https://github.com/Metrological/libprovision"
SECTION = "libs"
LICENSE = "CLOSED"

DEPENDS = "WPEFramework openssl"

PV = "1.0.gitr${SRCPV}"

#SRCREV = "cfa6e55f82205952660c3bbc0b0139bf3dda102a"
#SRC_URI = "git://git@github.com/Metrological/libprovision.git;protocol=ssh;branch=master"
SRCREV = "9ebb6f854a603625b25535383cff9928f42edbc1"
SRC_URI = "git://git@github.com/Metrological/libprovision.git;protocol=ssh;branch=WPEFramework"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

#COMPATIBLE_HOST = '(i.86|arm|mipsel).*-linux'

#PROV_ARCH ?= ""
#PROV_ARCH_arm = "arm"
#PROV_ARCH_x86 = "i686"
#PROV_ARCH_mipsel = "mipsel"

#do_configure[noexec] = "1"
#do_compile[noexec] = "1"

#do_install() {
#    install -Dm 755 ${S}/${PROV_ARCH}/libprovision.so ${D}${libdir}/libprovision.a
#    install -Dm 755 ${S}/${PROV_ARCH}/libprovisionproxy.so ${D}${libdir}/libprovisionproxy.so
#    install -Dm 644 ${S}/provision.pc ${D}${libdir}/pkgconfig/provision.pc
#
#    install -d  ${D}${includedir}/provision
#    install -m 644 ${S}/include/provision/*.h ${D}${includedir}/provision
#}

# Add the libraries to the correct package
#FILES_SOLIBSDEV = ""
#FILES_${PN} += "${libdir}/lib*.so"
#INSANE_SKIP_${PN} += "already-stripped"
# Some Damage control:
# ldflags is added due to the .so being not compiled with gnu_hash style on ARM
# whoever provides these precompiled objects should note to add
# "-Wl,--hash-style=gnu" to LDFLAGS when generating these objects
#INSANE_SKIP_${PN}_append_arm = " ldflags"
