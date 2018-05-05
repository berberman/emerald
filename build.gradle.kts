import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	var kotlinVersion: String by extra

	var minecraftVersion: String by extra

	minecraftVersion = "1.12.2-R0.1-SNAPSHOT"

	kotlinVersion = "1.2.41"

	repositories {
		mavenCentral()
	}
	dependencies {
		classpath(kotlin("gradle-plugin", kotlinVersion))
	}
}

plugins {
	java
}

group = "cn.berberman"
version = "1.0-SNAPSHOT"

allprojects {
	apply {
		plugin("kotlin")
		plugin("java")
	}
	repositories {
		mavenCentral()
		maven("https://hub.spigotmc.org/nexus/content/groups/public/")
	}

}


configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}