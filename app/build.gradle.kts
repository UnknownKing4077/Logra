plugins {
    id("com.android.application")
}

android {
    namespace = "xyz.wingio.logra"
    compileSdk = 34
    
    defaultConfig {
        applicationId = "xyz.wingio.logra"
        minSdk = 26
        targetSdk = 34
        versionCode = 1330
        versionName = "1.30"
    }

    signingConfigs {
        create("release") {
            storeFile = file("keystore.jks")
            storePassword = System.getenv("KEYSTORE_PASSWORD")
            keyAlias = System.getenv("KEY_ALIAS")
            keyPassword = System.getenv("KEY_PASSWORD")
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("dev.rikka.shizuku:api:13.1.5")  // Add Shizuku API
    implementation("dev.rikka.shizuku:provider:13.1.5")  // Add Shizuku Provider
}
