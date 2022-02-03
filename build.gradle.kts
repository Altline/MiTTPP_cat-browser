val kotlinVersion: String by System.getProperties()

val kotlinReactVersion = "17.0.2-pre.293-kotlin-1.6.10"
val kotlinStyledVersion = "5.3.3-pre.293-kotlin-1.6.10"
val kotlinReactRouterVersion = "6.2.1-pre.293-kotlin-1.6.10"

val kotlinCoroutinesVersion = "1.6.0"
val kotlinSerializationVersion = "1.3.2"

plugins {
    val kotlinVersion: String by System.getProperties()
    kotlin("js") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
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
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:$kotlinReactRouterVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:$kotlinStyledVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerializationVersion")
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