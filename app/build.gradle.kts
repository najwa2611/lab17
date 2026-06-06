plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.receiverdemo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.receiverdemo"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
}