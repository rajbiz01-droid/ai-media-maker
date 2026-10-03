plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.universalcreator"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.universalcreator"
        minSdk = 24
        targetSdk = 34
        versionCode = 10
        versionName = "10.0"
    }
    buildTypes {
        release { isMinifyEnabled = false }
    }
}
dependencies {}
