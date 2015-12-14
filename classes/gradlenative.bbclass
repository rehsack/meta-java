DEPENDS_append = " gradle-native"

#export GRADLE_HOME = "${STAGING_DATADIR_NATIVE}/${BPN}-${PV}"
export GRADLE_USER_HOME = "${WORKDIR}/gradle"

GRADLE_S = "${S}"
GRADLE_COMPILE_TARGET ?= "compile"
GRADLE_INSTALL_TARGET ?= "install"

# GRADLE_OPTS: -P org.gradle.parallel=1 -P org.gradle.workers.max=${PARALLEL_JOBS}
# GRADLE_PROJECT = ...

do_compile () {
    mkdir -p ${GRADLE_USER_HOME}
    cd ${GRADLE_S}
    gradle ${EXTRA_GRADLE_OPTS} ${GRADLE_COMPILE_TARGET}
}

do_install () {
    cd ${GRADLE_S}
    gradle ${EXTRA_GRADLE_OPTS} ${GRADLE_INSTALL_TARGET}
}
