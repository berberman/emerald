import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import java.util.concurrent.Callable

java.sourceSets {
	"main"{
		java.setSrcDirs(listOf("src"))
		withConvention(KotlinSourceSet::class) {
			kotlin.setSrcDirs(listOf("src"))
		}
	}
}

plugins {
	java
}

apply {
	plugin("kotlin")
}

val kotlinVersion: String by rootProject.extra

val minecraftVersion: String by rootProject.extra

dependencies {
	compileOnly(kotlin("stdlib-jdk8", kotlinVersion))
	compile("org.spigotmc:spigot-api:$minecraftVersion") {
		exclude(group = "org.bukkit")
	}
	compile("io.netty:netty-all:4.1.28.Final")
	archives("org.ow2.asm:asm-all:5.2")
	archives("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.0") {
		exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib")
	}

	configurations.compile.extendsFrom(configurations.archives)
}

tasks.withType<Jar> {
	from(Callable {
		configurations.getByName("archives").map {
			@Suppress("IMPLICIT_CAST_TO_ANY")
			if (it.isDirectory) it else zipTree(it)
		}
	})
}

//
//artifacts {
//	add("archives", tasks.getByName("jar"))
//}