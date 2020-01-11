import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.jetbrains.kotlin.jvm")
	application
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
val ktorVersion = "1.2.5"

repositories {
	mavenCentral()
	jcenter()
}

val developmentOnly by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation(project(":api"))

	implementation("io.javalin:javalin:3.6.0")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.10.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.0")
	implementation("org.slf4j:slf4j-simple:1.8.0-beta4")
	implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.6.12")

	testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
	testImplementation("org.assertj:assertj-core:3.11.1")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

application {
	mainClassName = "de.richargh.sandbox.reaktjs.backend.MainKt"
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks {
	processResources {
		dependsOn(":frontend:browserWebpack")
		from(project(":frontend").projectDir.resolve("build/kotlin-js-min/main/")) {
			include("*")
			into("public/")
		}
	}
}
