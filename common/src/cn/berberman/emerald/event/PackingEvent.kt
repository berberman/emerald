package cn.berberman.emerald.event

import cn.berberman.emerald.context.supplied.debug
import cn.berberman.emerald.reflection.ReflectionUtil
import cn.berberman.emerald.util.EmeraldUtil
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.plugin.EventExecutor
import org.bukkit.plugin.Plugin


class PackingEvent<in T : Event>(val type: Class<out Event>,
                                 private val eventPriority: EventPriority,
                                 private val ignoredCancelled: Boolean,
                                 private val block: (T) -> Unit) {
	var isRegistered = false

	@Suppress("UNCHECKED_CAST")
	private val executor: EventExecutor = EventExecutor { _, event ->
		block(event as T)
	}


	fun register(plugin: Plugin) {
		if (isRegistered) return
		EmeraldUtil.pluginManager.registerEvent(type, EmeraldUtil.emptyListener, eventPriority,
				executor, plugin, ignoredCancelled)
		isRegistered = true
		debug("register event listener: ${type.simpleName}")
	}


	fun unregister(plugin: Plugin) {
		if (!isRegistered) return
		HandlerList.getRegisteredListeners(plugin).find { it.getEventExecutor() == executor }?.let {
			this.type.let { ReflectionUtil.getField<HandlerList>(it, "handlers", null) }.unregister(it)
			isRegistered = false
			debug("unregister event listener: ${type.simpleName}")
		}
	}
}
