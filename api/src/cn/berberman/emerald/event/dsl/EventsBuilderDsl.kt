package cn.berberman.emerald.event.dsl

import cn.berberman.emerald.event.EventBuilder
import cn.berberman.emerald.event.PackingEvent
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.plugin.Plugin


@EventBuilder
class EventsBuilder internal constructor(private val plugin: Plugin) {

	@EventBuilder
	inline fun <reified T : Event> event(eventPriority: EventPriority = EventPriority.NORMAL,
	                                     ignoreCancelled: Boolean = false,
	                                     noinline block: T.() -> Unit): Boolean = throw NotImplementedError()


	fun registerAll(): Unit = throw NotImplementedError()

	fun unregisterAll(): Unit = throw NotImplementedError()

}


fun registerEventListeners(plugin: Plugin, block: EventsBuilder.() -> Unit): EventsBuilder =
		throw NotImplementedError()


inline fun <reified T : Event> eventListener(eventPriority: EventPriority = EventPriority.NORMAL,
                                             ignoreCancelled: Boolean = false,
                                             noinline block: T.() -> Unit): PackingEvent<T> =
		throw NotImplementedError()
