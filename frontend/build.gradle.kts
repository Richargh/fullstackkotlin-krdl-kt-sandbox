import org.jetbrains.kotlin.gradle.tasks.KotlinJsDce

plugins {
	id("org.jetbrains.kotlin.js")
}

apply(plugin = "kotlin-dce-js")

repositories {
	mavenCentral()
}

kotlin {
	target {
		browser {
			webpackTask {
				val runDceKotlin by tasks.getting(KotlinJsDce::class)
				dependsOn(runDceKotlin)
			}
		}
	}

	sourceSets["main"].dependencies {
		/** Npm Main Dependencies **/
		// none
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
