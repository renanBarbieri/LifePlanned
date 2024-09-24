import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.applyPlugins(vararg plugins: Config.Plugins) {
    plugins.forEach { plugin ->
        pluginManager.apply(findPluginId(plugin))
    }
}

private fun Project.findPluginId(plugin: Config.Plugins): String {
    val versionCatalog = extensions.getByType(VersionCatalogsExtension::class).named("libs")
    return versionCatalog.findPlugin(plugin.alias).get().get().pluginId
}