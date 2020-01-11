import org.jetbrains.kotlin.gradle.tasks.KotlinJsDce

plugins {
	kotlin("js") version "1.3.50"
}

apply(plugin = "kotlin-dce-js")

repositories {
	mavenCentral()
}

kotlin {
	target {
		compilations.all {
			kotlinOptions {
				moduleKind = "umd"
			}
		}
		browser {
			webpackTask {
				val runDceKotlin by tasks.getting(KotlinJsDce::class)
				dependsOn(runDceKotlin)
			}
		}

		sourceSets["main"].dependencies {
			/** Npm Main Dependencies **/
//			implementation(npm("react", "16.8.3"))
		}
	}
}

dependencies {
	/** Language dependencies **/
	implementation(kotlin("stdlib-js"))

	/** Project dependencies **/
	implementation(project(":api"))

	/** Main dependencies **/
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.3.2")

	/** Test dependencies **/
	testImplementation(kotlin("test-js"))
}
