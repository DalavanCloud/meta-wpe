
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += " \
    file://0001-mssdemux-improved-live-playback-support.patch \
    file://0002-adaptivedemux-minimal-HTTP-context-support.patch \
    file://0003-gl-dispmanx-Implements-set_render_rectangle-to-adjus.patch \
    file://0005-mpdparser-MS-PlayReady-ContentProtection-parsing.patch \
"

