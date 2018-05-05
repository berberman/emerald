package cn.berberman.emerald.event

import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.plugin.EventExecutor
import org.bukkit.plugin.Plugin


class PackingEvent<in T : Event>(val type: Class<out Event>,
                                 private val eventPriority: EventPriority,
                                 private val ignoredCancelled: Boolean,
                                 private val block: (T) -> Unit) {
	var isRegistered: Boolean = throw NotImplementedError()


	private val executor: EventExecutor = throw NotImplementedError()


	fun register(plugin: Plugin) {
		throw NotImplementedError()
	}


	fun unregister(plugin: Plugin) {
		throw NotImplementedError()
	}
}
