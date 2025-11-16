plugins {
    id("com.android.application") version "8.2.2" apply false
    kotlin("android") version "1.8.10" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
