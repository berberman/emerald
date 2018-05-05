package cn.berberman.emerald.reflection.wrapper.chat

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.getConstructorAccess
import cn.berberman.emerald.reflection.invokeMethod
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper
import org.bukkit.plugin.IllegalPluginAccessException

class NmsChatSerializer : ReflectionWrapper() {

	companion object {
		private val clazz = ReflectionClasses.Nms.ChatSerializer()

		fun decodeFromString(raw: String) = clazz.invokeMethod(
				null, "a", raw
		)?.let { NmsIChatBaseComponentWrapper(it) } ?: throw IllegalPluginAccessException("Convert error.")
	}

	override val clazz: Class<*> = NmsChatSerializer.clazz

	override val handle: Any = clazz.getConstructorAccess().newInstance()

}
