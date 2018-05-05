package cn.berberman.emerald.util

import org.bukkit.plugin.Plugin

object ContextUtil {
	private val pluginClassLoaderClass: Class<*> = throw NotImplementedError()

	fun findPluginInstance(): Plugin? = throw NotImplementedError()


	fun getPluginInstance(): Plugin = throw NotImplementedError()

	private fun Any.getPluginClassLoader(): ClassLoader = throw NotImplementedError()
}
