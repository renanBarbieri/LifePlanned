import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
//    compileOnly(libs.firebase.crashlytics.gradlePlugin)
//    compileOnly(libs.firebase.performance.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
//    implementation(libs.truth)
}

gradlePlugin {
    plugins {
        register("androidApplicationConventionPlugin") {
            id = "com.hblabs.android.convention.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibraryConventionPlugin") {
            id = "com.hblabs.android.convention.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
}