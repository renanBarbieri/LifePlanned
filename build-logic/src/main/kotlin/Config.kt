import org.gradle.api.JavaVersion

object Config {
    object Android {
        val compileSdk = 34
        val minSdk = 26
        val targetSdk = 34

        val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val packagingResourcesExcludes = "/META-INF/{AL2.0,LGPL2.1}"
    }

    object Java {
        val sourceCompatibility = JavaVersion.VERSION_17
        val targetCompatibility = JavaVersion.VERSION_17
    }

    enum class Plugins(val alias: String) {
        ANDROID_APPLICATION("android-application"),
        ANDROID_LIBRARY("android-library"),
        KOTLIN_ANDROID("kotlin-android"),
    }
}