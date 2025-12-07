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

// CLI 工具构建配置
tasks.register<Jar>("cliJar") {
    archiveClassifier.set("cli")
    manifest {
        attributes("Main-Class" to "com.kotlinlearning.CliMainKt")
    }
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
