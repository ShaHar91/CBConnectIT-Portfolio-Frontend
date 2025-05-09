pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
        mavenCentral()
        maven("https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "C.B._Connect_I.T._Portfolio_FrontEnd"

include(":core")
include(":data")
include(":backoffice")
include(":landing")
include(":site")
