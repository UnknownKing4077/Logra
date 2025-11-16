plugins {
    id("com.android.application")
    kotlin("android")
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    kotlinOptions {
        jvmTarget = "11"
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
    implementation("androidx.core:core-ktx:1.9.0")
}
