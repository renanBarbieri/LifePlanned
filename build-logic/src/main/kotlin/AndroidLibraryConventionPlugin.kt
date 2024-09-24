import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.applyPlugins(Config.Plugins.ANDROID_LIBRARY, Config.Plugins.KOTLIN_ANDROID)
        project.extensions.configureLibrary()
    }

    private fun ExtensionContainer.configureLibrary() {
        this.configure<LibraryExtension> {
            compileSdk = Config.Android.compileSdk

            defaultConfig.apply {
                minSdk = Config.Android.minSdk
                targetSdk = Config.Android.targetSdk

                testInstrumentationRunner = Config.Android.testInstrumentationRunner
            }

            compileOptions.apply {
                sourceCompatibility = Config.Java.sourceCompatibility
                targetCompatibility = Config.Java.targetCompatibility
            }

            packaging.resources.excludes += Config.Android.packagingResourcesExcludes
        }
    }
}