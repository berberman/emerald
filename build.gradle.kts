import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    var kotlinVersion: String by extra

    extra["minecraftVersion"] = "1.12.2-R0.1-SNAPSHOT"

    kotlinVersion = "1.3.11"

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
        classpath("com.novoda:bintray-release:+")
    }
}

plugins {
    java
}

group = "cn.berberman"
version = "v1.1"

allprojects {
    apply {
        plugin("kotlin")
        plugin("java")
    }
    repositories {
        mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    }


    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
        options.apply {
            compilerArgs.add("-Xlint:unchecked")
            compilerArgs.add("-Xlint:deprecation")
        }
    }
}
