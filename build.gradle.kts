val kotlinVersion: String by System.getProperties()

val kotlinReactVersion = "17.0.2-pre.293-kotlin-1.6.10"
val kotlinStyledVersion = "5.3.3-pre.293-kotlin-1.6.10"
val kotlinReactRouterVersion = "6.2.1-pre.293-kotlin-1.6.10"

plugins {
    val kotlinVersion: String by System.getProperties()
    kotlin("js") version kotlinVersion
}

group = "altline"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$kotlinReactVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$kotlinReactVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:$kotlinStyledVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:$kotlinReactRouterVersion")
}

kotlin {
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}