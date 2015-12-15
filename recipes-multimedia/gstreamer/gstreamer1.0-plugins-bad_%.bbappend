
# WPE depends on an MP3 decoder to support "audio beeps" as focus switches
# between elements in a browser based UI. Note that the mpg123 plug-in is not
# enabled by default as the mpg123 recipe is not in oe-core (as of jethro it's
# in meta-oe) and requires whitelisting as it sets the commercial license flag.
# Enabling mpg123 here is therefore an experimental change, to be reviewed...


PACKAGECONFIG[gles2]           = "--enable-gles2,--disable-gles2,virtual/libgles2"
PACKAGECONFIG[egl]             = "--enable-egl,--disable-egl,virtual/egl"
PACKAGECONFIG[gl]              = "--enable-gl,--disable-gl"
PACKAGECONFIG[dispmanx]        = "--enable-dispmanx,--disable-dispmanx"

PACKAGECONFIG_append = " mpg123 gles2 egl gl dispmanx"
