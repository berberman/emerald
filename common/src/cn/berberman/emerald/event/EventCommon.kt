@file:JvmName("EventUtil")


package cn.berberman.emerald.event

import cn.berberman.emerald.reflection.ReflectionUtil
import cn.berberman.emerald.reflection.invokeMethod
import cn.berberman.emerald.util.EmeraldUtil.pluginManager
import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import org.bukkit.plugin.EventExecutor
import org.bukkit.plugin.RegisteredListener
import org.bukkit.plugin.SimplePluginManager


internal fun RegisteredListener.getEventExecutor(): EventExecutor =
		ReflectionUtil.getField("executor", this)


@Suppress("UNCHECKED_CAST")
@Deprecated("low performance")
internal fun Class<out Event>.getEventListeners(): HandlerList {
	val getRegistrationClass = ReflectionUtil.getMethod(SimplePluginManager::class.java,
			"getRegistrationClass", Class::class.java)
	return (getRegistrationClass(pluginManager, this) as Class<out Event>).let {
		it.invokeMethod(it, "getHandlerList") as HandlerList
	}
}
