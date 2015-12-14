# Copyright (C) 2015 Jens Rehsack <sno@netbsd.org>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Gradle makes the impossible possible, the possible easy and the easy elegant."
HOMEPAGE = "http://gradle.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
SECTION = "devel"
PR = "r0"

SRC_URI = "\
    https://services.gradle.org/distributions/gradle-2.9-bin.zip \
"
SRC_URI[md5sum] = "1325767f5a52ccfb483d114da9709cc6"
SRC_URI[sha256sum] = "c9159ec4362284c0a38d73237e224deae6139cbde0db4f0f44e1c7691dd3de2f"

DEPENDS = "virtual/java-native virtual/javac-native"
RDEPENDS_${PN} = "java2-runtime"

BBCLASSEXTEND = "native"

do_install() {
    install -d ${STAGING_DATADIR}/${BPN}-${PV}
    install -d ${STAGING_DATADIR}/${BPN}-${PV}/bin
    install -d ${STAGING_DATADIR}/${BPN}-${PV}/lib/plugins
    install -d ${STAGING_DATADIR}/${BPN}-${PV}/lib/plugins/sonar

    install -m 755 bin/gradle ${STAGING_DATADIR}/${BPN}-${PV}/bin
    install -m 644 lib/*.jar ${STAGING_DATADIR}/${BPN}-${PV}/lib
    install -m 644 lib/plugins/*.jar ${STAGING_DATADIR}/${BPN}-${PV}/lib/plugins
    install -m 644 lib/plugins/sonar/*.jar ${STAGING_DATADIR}/${BPN}-${PV}/lib/plugins/sonar

    cat <<END > ${STAGING_BINDIR}/gradle
#!/bin/sh
exec ${STAGING_DATADIR}/${BPN}-${PV}/bin/gradle "\$@"
END
    chmod +x ${STAGING_BINDIR}/gradle
}
