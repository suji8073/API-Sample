import com.linecorp.support.project.multi.recipe.configureByLabels

plugins {
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    id("org.springframework.boot") version "2.7.3" apply false
    id("io.freefair.lombok") version "6.4.1" apply false
    id("com.linecorp.build-recipe-plugin") version "1.1.1"

    kotlin("jvm") version "1.6.21" apply false
    kotlin("kapt") version "1.6.21" apply false
    kotlin("plugin.spring") version "1.6.21" apply false
}

allprojects {
    group = "sample.project.kdohyeon"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        maven {
            url = uri("https://maven.restlet.com")
        }
        maven {
            url = uri("https://jitpack.io")
        }
    }
}

subprojects {
    apply(plugin = "idea")
}

configureByLabels("java") {
    apply(plugin = "org.gradle.java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "io.freefair.lombok")

    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.7.3")
            mavenBom("org.jetbrains.kotlin:kotlin-bom:1.6.21")
            mavenBom("org.jetbrains.kotlinx:kotlinx-serialization-bom:1.4.1")
            mavenBom("com.google.guava:guava-bom:31.1-jre")
        }

        dependencies {
            dependency("org.apache.commons:commons-lang3:3.12.0")
            dependency("org.apache.commons:commons-collections4:4.4")
            dependency("commons-io:commons-io:2.11.0")
        }
    }

    repositories {
        mavenCentral()
        maven {
            url = uri("https://maven.restlet.com")
        }
        maven {
            url = uri("https://jitpack.io")
        }
    }

    dependencies {
        val implementation by configurations

        implementation("org.apache.commons:commons-lang3")
        implementation("org.apache.commons:commons-collections4")
        implementation("commons-io:commons-io")
        implementation("com.google.guava:guava")
    }
}

configureByLabels("boot") {
    apply(plugin = "org.springframework.boot")

    tasks.getByName<Jar>("jar") {
        enabled = false
    }

    tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
        enabled = true
    }
}