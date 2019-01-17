import com.novoda.gradle.release.PublishExtension
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
	plugin("com.novoda.bintray-release")
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

tasks.withType<KotlinCompile> {
	kotlinOptions {
		suppressWarnings = true
	}
}

task<Jar>("sourceJar") {
	classifier = "sources"
	from(java.sourceSets["main"].allSource)
	group = "build"
}

tasks["jar"].dependsOn("sourceJar")


configure<PublishExtension> {
	userOrg = "berberman"
	groupId = "cn.berberman"
	artifactId = "emerald-api"
	publishVersion = rootProject.version.toString()
	desc = "the api of Emerald -- a minecraft bukkit plugin lib"
	website = "https://github.com/berberman/emerald"
}
