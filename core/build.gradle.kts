import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("java-library")
  id("kotlin")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

val compileKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions { jvmTarget = JavaVersion.VERSION_1_8.toString() }

val compileTestKotlin: KotlinCompile by tasks

compileTestKotlin.kotlinOptions { jvmTarget = JavaVersion.VERSION_1_8.toString() }

dependencies {
  implementation("javax.inject:javax.inject:1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")

  testImplementation("junit:junit:4.13.2")
  testImplementation("io.mockk:mockk:1.12.0")
  testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1")
}
