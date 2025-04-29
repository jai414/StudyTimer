plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.studytimer"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.studytimer"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        // No Compose: using traditional XML layouts
        compose = false
    }
}

dependencies {
    // Core Kotlin extensions
    implementation(libs.androidx.core.ktx)

    // AppCompat for backward-compatible UI components
    implementation(libs.androidx.appcompat.v161)

    // Lifecycle helpers (optional but recommended for modern Android)
    implementation(libs.androidx.lifecycle.runtime.ktx.v261)

    // (Optional) Material Components if using Material widgets in XML
    implementation(libs.material)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
}
