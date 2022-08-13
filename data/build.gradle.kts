plugins {
	id("org.jetbrains.kotlin.jvm") version "1.7.10"
}

group = "org.lorenzo"
version = "0.0.1"

repositories {
	mavenCentral()
}

dependencies {
	// Align versions of all Kotlin components
	implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

	// Use the Kotlin JDK 8 standard library.
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// This dependency is used by the application.
	implementation("com.google.guava:guava:30.1.1-jre")

	// Use the Kotlin test library.
	testImplementation("org.jetbrains.kotlin:kotlin-test")

	// Use the Kotlin JUnit integration.
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

	// Exposed
	implementation("org.jetbrains.exposed:exposed-core:0.36.2")
	implementation("org.jetbrains.exposed:exposed-dao:0.36.2")
	implementation("org.jetbrains.exposed:exposed-jdbc:0.36.2")
	// https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
	implementation("org.xerial:sqlite-jdbc:3.39.2.0")

	// Project
	implementation(project(":domain"))
}