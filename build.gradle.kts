plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "com.kotlinlearning"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("com.kotlinlearning.MainKt")
}
