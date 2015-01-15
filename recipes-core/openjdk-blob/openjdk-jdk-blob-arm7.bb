PV = "1.8.0"
PR = "r0"
PV_UPDATE = "25"

LIC_FILES_CHKSUM = "\
	file://${WORKDIR}/openjdk-${PV}_${PV_UPDATE}/doc/java-${PV}-openjdk-devel/LICENSE;md5=7b4baeedfe2d40cb03536573bc2c89b1 \
"

require openjdk-jdk.inc

SRC_URI = "http://internal.rdm.local/blobs/openjdk-1.8.0_25.tgz"
