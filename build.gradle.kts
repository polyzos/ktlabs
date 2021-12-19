plugins {
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.serialization") version "1.6.0"
}

group = "io.ipolyzos"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.0")

    implementation("io.arrow-kt:arrow-core:1.0.1")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.0.1")

    implementation("org.rocksdb:rocksdbjni:6.26.1")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
}