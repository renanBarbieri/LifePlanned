import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.applyPlugins(Config.Plugins.ANDROID_APPLICATION, Config.Plugins.KOTLIN_ANDROID)
        project.extensions.configureApplication()
    }

    private fun ExtensionContainer.configureApplication() {
        this.configure<ApplicationExtension> {
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