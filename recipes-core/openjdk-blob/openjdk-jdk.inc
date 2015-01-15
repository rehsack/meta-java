DESCRIPTION = "OpenJDK Java SE Development Kit binaries"

JDK_JRE = "jdk"
require openjdk.inc

do_install_class-native() {
    install -d -m 0755                      ${D}${bindir}/${JDK_JRE}${PV}_${PV_UPDATE}
    cp -a ${S}/${JDK_JRE}${PV}_${PV_UPDATE} ${D}${bindir}/
    ln -sf ${JDK_JRE}${PV}_${PV_UPDATE}     ${D}${bindir}/java
}

BBCLASSEXTEND = "native"
