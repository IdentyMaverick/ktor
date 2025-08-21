val ktor_version = "2.3.12"
val kotlin_version = "1.9.23"
val jwtVersion = "4.4.0"
val exposedVersion = "0.56.0"
val postgresVersion = "42.7.3"
val coroutinesVersion = "1.8.1"

plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.23"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        // Ktor
        implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
        implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
        implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
        implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
        implementation("io.ktor:ktor-server-cors:$ktor_version")
        implementation("io.ktor:ktor-server-auth:$ktor_version")
        implementation("io.ktor:ktor-server-auth-jwt:$ktor_version")
        implementation("io.ktor:ktor-server-call-logging:$ktor_version")

        // Log
        implementation("ch.qos.logback:logback-classic:1.4.11")

        // Serialization
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

        // JWT
        implementation("com.auth0:java-jwt:$jwtVersion")

        // Database - Exposed + PostgreSQL
        implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
        implementation("org.postgresql:postgresql:$postgresVersion")

        // BCrypt (sadece birini kullan)
        implementation("at.favre.lib:bcrypt:0.9.0")

        // Coroutines (strictly versiyon sabitle)
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core") {
            version {
                strictly(coroutinesVersion)
            }
        }

    }
}

application {
    mainClass.set("ApplicationKt")
}
