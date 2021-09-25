plugins {
    id("com.diffplug.spotless") version ("5.15.0")
}

subprojects {
    repositories {
        google()
        mavenCentral()
    }
}

spotless {
    kotlin {
        target("**/src/**/*.kt")
        ktfmt()
    }
}

