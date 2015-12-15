# Base this image on rpi-hwup-image
inherit core-image

include recipes-core/images/rpi-hwup-image.bb

SPLASH = "psplash-raspberrypi"

IMAGE_FEATURES += " \
    ssh-server-openssh \ 
    splash \
"

IMAGE_INSTALL_append = "\
   packagegroup-ml-middleware \
   packagegroup-ml-wpe \
"
