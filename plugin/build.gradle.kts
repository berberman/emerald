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

apply {
	plugin("kotlin")
}

val kotlinVersion: String by rootProject.extra

repositories {
	mavenCentral()
}

dependencies {
	compile(kotlin("stdlib-jdk8", kotlinVersion))
	compile(project(":common"))
}

tasks.withType<Jar> {
	baseName = "EmeraldLib"

	from(projectDir.listFiles { i: File -> i.name.endsWith("yml") })
	from(Callable {
		configurations.compile.filter {
			it.name.contains("kotlin") ||
					it.name == "common.jar"
		}.map {
			@Suppress("IMPLICIT_CAST_TO_ANY")
			if (it.isDirectory) it else zipTree(it)
		}
	})
}

task<Copy>("copyPlugin") {
	from(project.buildDir.listFiles { f: File -> f.name == "libs" })
	into(System.getProperty("target"))
}