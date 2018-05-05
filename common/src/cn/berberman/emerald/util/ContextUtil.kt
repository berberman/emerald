package cn.berberman.emerald.util

import cn.berberman.emerald.reflection.ReflectionUtil
import org.bukkit.plugin.IllegalPluginAccessException
import org.bukkit.plugin.Plugin

object ContextUtil {
	private val pluginClassLoaderClass: Class<*> = Class.forName("org.bukkit.plugin.java.PluginClassLoader")

	var debug = false

	fun findPluginInstance(): Plugin? =
			getPluginClassLoader()?.let {
				ReflectionUtil.getField(pluginClassLoaderClass, "plugin", it)
			}


	fun getPluginInstance() = getPluginClassLoader()?.let {
		ReflectionUtil.getField<Plugin>(pluginClassLoaderClass, "plugin", it)
	}
			?: throw IllegalPluginAccessException("Not plugin context")

	private fun Any.getPluginClassLoader() =
			javaClass.classLoader.takeIf { pluginClassLoaderClass.isInstance(it) }
}
