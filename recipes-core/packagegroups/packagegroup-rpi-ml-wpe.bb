DESCRIPTION = "Metrological WPE Packagegroup"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-ml-wpe \
"

RDEPENDS_packagegroup-ml-wpe = "\
    wpewebkit \
    wpebackend \
    wpebackend-rdk \
    wpewebkit-web-inspector-plugin \
    wpelauncher \
    WPEFramework \
    WPEFramework-Open \
    WPEFramework-Provisioning \
"

# Additional OSS packages etc, which are only needed for WPE based images.
RDEPENDS_packagegroup-ml-wpe += "\
    fontconfig \
    fontconfig-utils \
    ttf-bitstream-vera \
"
