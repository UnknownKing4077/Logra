plugins {
    id("com.android.application")
}

android {
    namespace = "xyz.wingio.logra"  // Add this line - use your app package
    compileSdk = 34
    
    defaultConfig {
        applicationId = "xyz.wingio.logra"
        minSdk = 21
        targetSdk = 36
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
