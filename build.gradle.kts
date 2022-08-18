import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version Versions.spring_boot
    id("io.spring.dependency-management") version Versions.dependency_management
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.spring") version Versions.kotlin apply false
    kotlin("plugin.jpa") version Versions.kotlin apply false
    kotlin("kapt") version Versions.kotlin
}

java.sourceCompatibility = JavaVersion.VERSION_11

allprojects {
    group = "com.fnb.review"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
        google()
    }
}

subprojects {

    apply(plugin = "java")

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")
    apply(plugin = "kotlin-kapt")

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        developmentOnly("org.springframework.boot:spring-boot-devtools")

        implementation("com.querydsl:querydsl-jpa:${Versions.querydsl_version}")
        kapt("com.querydsl:querydsl-apt:${Versions.querydsl_version}:jpa")
        kapt("org.springframework.boot:spring-boot-configuration-processor")
        kapt("jakarta.persistence:jakarta.persistence-api")
        kapt("jakarta.annotation:jakarta.annotation-api")

        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("io.github.microutils:kotlin-logging:${Versions.kotlin_logging}")

        runtimeOnly("com.h2database:h2")
        runtimeOnly("mysql:mysql-connector-java")

        testImplementation("org.junit.jupiter:junit-jupiter:${Versions.junit_jupiter}")
        testImplementation("org.testcontainers:testcontainers:${Versions.testcontainers}")
        testImplementation("org.testcontainers:junit-jupiter:${Versions.testcontainers_junit_jupiter}")

        testImplementation(platform("io.kotest:kotest-bom:${Versions.kotest_bom}"))
        testImplementation("io.kotest:kotest-runner-junit5")

        testImplementation("io.kotest.extensions:kotest-extensions-spring:${Versions.kotest_extensions_spring}")

        testImplementation("io.mockk:mockk:${Versions.mock}")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
//        testImplementation("org.springframework.security:spring-security-test")
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }

        dependencies {
            dependency("net.logstash.logback:logstash-logback-encoder:${Versions.logstash_logback_encoder}")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

    tasks.withType<Test> {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
        useJUnitPlatform()
        testLogging {
//            events = setOf(FAILED, PASSED, SKIPPED)
        }
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }
}

project(":fnb-review-domain-core") {
    val jar: Jar by tasks
    val bootJar: BootJar by tasks
    bootJar.enabled = false
    jar.enabled = true
}

project(":fnb-review-app-api") {
    dependencies {
        implementation(project(":fnb-review-domain-core"))
    }
}

