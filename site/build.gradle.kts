import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script

plugins {
    alias(libs.plugins.kotlin.multiplatform)
//    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
//    alias(libs.plugins.kobweb.application)
    id(libs.plugins.kobweb.application.get().pluginId)
    alias(libs.plugins.kobwebx.markdown)
    alias(libs.plugins.detekt)
}

group = "cbconnectit.portfolio.web"
version = "0.1.0-SNAPSHOT"

kobweb {
    app {
        globals.put("BASE_URL", System.getenv("BASE_URL") ?: "")

        index {
            description.set("Powered by Kobweb")

            head.add {
                script {
                    src = "https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                }

                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
                }
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("bolla", false)

    @Suppress("UNUSED_VARIABLE") // Suppress spurious warnings about sourceset variables not being used
    sourceSets {
        commonMain.dependencies {
            dependencies {
                implementation(libs.compose.runtime)
//                implementation(libs.kotlinx.serialization.json)
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
                api(project(":core"))
                api(project(":landing"))
                api(project(":backoffice"))
            }
        }

        jsMain.dependencies {
            dependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk)
                implementation(libs.kobweb.silk.icons.fa)
                implementation(libs.kobwebx.markdown)

                implementation(npm("marked", "4.3.0"))
            }
        }
    }
}
