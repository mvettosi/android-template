plugins { id("com.diffplug.spotless") version ("5.15.0") }

buildscript { dependencies { classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31") } }

spotless {
  kotlin {
    target("**/src/**/*.kt")
    ktfmt()
    toggleOffOn()
  }
  kotlinGradle {
    target("*.gradle.kts", "*/*.gradle.kts")
    ktfmt()
  }
}
