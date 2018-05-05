import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.utils.addToStdlib.cast
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
val minecraftVersion: String by rootProject.extra

dependencies {
	compile(kotlin("stdlib-jdk8", kotlinVersion))
	compile(project(":common"))
}


tasks.withType<Jar> {
	baseName = "EmeraldAPI"
}


task<Jar>("api") {
	classifier = "sources"
	from(java.sourceSets["main"].allSource)
	group = "build"
}

tasks["jar"].dependsOn("api")