
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# https://github.com/Metrological/buildroot/blob/master/package/cairo/0006-add-egl-device-create.patch
SRC_URI += "file://0006-add-egl-device-create.patch"

# https://github.com/Metrological/buildroot/blob/master/package/cairo/0008-add-noaa-compositor.patch
SRC_URI += "file://0008-add-noaa-compositor.patch"

# By default Cairo enables DirectFB support based on DISTRO_FEATURES.
# However, Cairo DirectFB support seems to be an experimental and not
# always applicable, so over-ride DISTRO_FEATURES and keep it disabled.
PACKAGECONFIG_remove = "directfb"

# Enable support for egl + opengles2
PACKAGECONFIG_append_class-target = " ${@base_contains('DISTRO_FEATURES', 'opengl', 'egl glesv2', '', d)}"
