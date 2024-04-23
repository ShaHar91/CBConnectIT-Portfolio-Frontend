import com.varabyte.kobweb.gradle.library.util.configAsKobwebLibrary

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.library)
    alias(libs.plugins.kobwebx.markdown)
    alias(libs.plugins.kotlin.serialization)
}

group = "cbconnectit.portfolio.web"
version = "1.0-SNAPSHOT"

kotlin {
    // Even though this module doesn't actually define any server routes itself, 'includeServer = true' allows us to
    // depened on ":core" as a commonMain dependency from other modules, instead of a JS-only dependency.
    configAsKobwebLibrary(includeServer = false)

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
            implementation(compose.runtime)
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
        }
        jsMain.dependencies {
            implementation(compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.kobweb.silk.icons.fa)
        }
    }
}