LICENSE = "GPL-2.0-with-classpath-exception"
LIC_FILES_CHKSUM ?= "\
	file://${WORKDIR}/openjdk-${PV}_${PV_UPDATE}/doc/java-${PV}-openjdk-devel/LICENSE;md5=7b4baeedfe2d40cb03536573bc2c89b1 \
"

# get the java update version in the resulting package
PR =. "u${PV_UPDATE}"
S = "${WORKDIR}"

do_install () {
	install -d -m 0755			${D}/usr/${JDK_JRE}${PV}_${PV_UPDATE}
	cp -a ${S}/openjdk-${PV}_${PV_UPDATE}	${D}/usr/
	ln -sf openjdk-${PV}_${PV_UPDATE}	${D}/usr/java
}

# All the files are provided in a binaray package, and keeping all the
# files in a single package causes packaging QA errors and warnings.
# Avoid these packaging failure by skiping all the QA checks
INSANE_SKIP_${PN} = "${ERROR_QA} ${WARN_QA}"

# Inhibit warnings about files being stripped, we can't do anything about it.
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

FILES_${PN} = "/usr/"

RPROVIDES_${PN} += "java2-runtime"
