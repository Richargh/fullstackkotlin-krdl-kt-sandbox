rootProject.name = "fullstackkotlin"

include("backend", "frontend", "api")

pluginManagement {
	repositories {
		gradlePluginPortal()
	}
	plugins {
		val kotlinVersion = "1.3.50"
		id("org.jetbrains.kotlin.js") version kotlinVersion apply false
		id("org.jetbrains.kotlin.multiplatform") version kotlinVersion  apply false
		id("org.jetbrains.kotlin.jvm") version kotlinVersion apply false
	}
}