import com.android.build.gradle.internal.tasks.factory.dependsOn
import org.apache.tools.ant.taskdefs.condition.Os

plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = Sdk.TARGET_SDK_VERSION

  defaultConfig {
    applicationId = AppCoordinates.APP_ID
    minSdk = Sdk.MIN_SDK_VERSION
    targetSdk = Sdk.TARGET_SDK_VERSION
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables { useSupportLibrary = true }
  }

  buildTypes {
    // Build Type Names
    val release = "release"

    getByName(release) {
      // R8 Optimisations
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions { jvmTarget = "1.8" }
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = "1.0.1" }
  packagingOptions { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
}

dependencies {
  // Core
  implementation("androidx.core:core-ktx:1.6.0")
  implementation("androidx.appcompat:appcompat:1.3.1")
  implementation("com.google.android.material:material:1.4.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

  // Compose
  implementation("androidx.compose.ui:ui:1.0.2")
  implementation("androidx.compose.material:material:1.0.2")
  implementation("androidx.compose.ui:ui-tooling-preview:1.0.2")
  implementation("androidx.activity:activity-compose:1.3.1")
  implementation(project(mapOf("path" to ":core")))
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0-beta01")
  debugImplementation("androidx.compose.ui:ui-tooling:1.0.2")
  implementation("androidx.navigation:navigation-compose:2.4.0-alpha09")
  implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")

  // Hilt
  implementation("com.google.dagger:hilt-android:2.38.1")
  kapt("com.google.dagger:hilt-compiler:2.38.1")

  // Timber
  implementation("com.jakewharton.timber:timber:4.7.1")

  // Test
  testImplementation("junit:junit:4.13.2")
  testImplementation("io.mockk:mockk:1.12.0")
  testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1")

  // AndroidTest
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.2")
}

tasks {
  register("installGitHook", Copy::class.java) {
    val suffix = if (Os.isFamily(Os.FAMILY_WINDOWS)) "windows" else "unix"
    from(File(rootProject.rootDir, "scripts/pre-commit-$suffix"))
    into(File(rootProject.rootDir, ".git/hooks"))
    rename("pre-commit-$suffix", "pre-commit")
  }
  named("preBuild").dependsOn("installGitHook")
}
