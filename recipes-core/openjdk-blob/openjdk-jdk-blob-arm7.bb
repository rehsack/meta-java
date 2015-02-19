PV = "1.8.0"
PR = "r0"
PV_UPDATE = "25"

LIC_FILES_CHKSUM = "\
	file://${WORKDIR}/openjdk-${PV}_${PV_UPDATE}/doc/java-${PV}-openjdk-devel/LICENSE;md5=7b4baeedfe2d40cb03536573bc2c89b1 \
"

require openjdk-jdk.inc

SRC_URI = "http://internal.rdm.local/blobs/openjdk-1.8.0_25.tgz"

SRC_URI[md5sum] = "d09f42dfb18b79f4e4ef4345895df68f"
SRC_URI[sha256sum] = "840f5f274bb7b164fe096ca1b1a1edda2dce71888e0d42908dae722f70243ae2"
