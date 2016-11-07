SUMMARY = "Broadcom Reference Software"
DESCRIPTION = "Broadcom Reference Software. Drivers and libaries for Broadcom SoC."
SECTION = "drivers"
LICENSE = "CLOSED"

inherit core-image distro_features_check

CORE_IMAGE_BASE_INSTALL += " \
	weston \
	"

CORE_IMAGE_BASE_INSTALL += " \
	packagegroup-rdk-broadcom-wpe \
	packagegroup-ml-middleware \
	packagegroup-ml-wpe \
	packagegroup-core-nfs-client \
	"

CORE_IMAGE_BASE_INSTALL += " \
	network-hotplug \
	dropbear \
	"
# for timezones
IMAGE_INSTALL += "tzdata"
# for IR
IMAGE_INSTALL += "iarmmgrs"
# for storagemanager (MMC/HDD)
IMAGE_INSTALL += "e2fsprogs"
IMAGE_INSTALL += "storagemanager"
IMAGE_INSTALL += "flashmounts"
IMAGE-INSTALL += "libxkbcommon"


WPE_BACKEND = "nexus"

