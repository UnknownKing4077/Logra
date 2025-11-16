plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")  // Add this line
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

    buildFeatures {
        compose = true  // If using Compose
        viewBinding = true  // If using ViewBinding
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
    implementation("androidx.core:core-ktx:1.12.0")  // Add Kotlin extensions
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("dev.rikka.shizuku:api:13.1.5")
    implementation("dev.rikka.shizuku:provider:13.1.5")
    
    // If using Compose
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.ui:ui:1.5.4")
}
