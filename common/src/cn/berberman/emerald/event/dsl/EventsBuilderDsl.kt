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
	                                     noinline block: T.() -> Unit) =
			PackingEvent(T::class.java, eventPriority, ignoreCancelled, block).let(events::add).takeIf { it }
					?: throw IllegalArgumentException("Event listener already existed")

	@PublishedApi
	internal val events = mutableSetOf<PackingEvent<*>>()

	fun registerAll() = events.forEach { it.register(plugin) }

	fun unregisterAll() = events.forEach { it.unregister(plugin) }

}


fun registerEventListeners(plugin: Plugin, block: EventsBuilder.() -> Unit) =
		EventsBuilder(plugin).apply(block).also(EventsBuilder::registerAll)


inline fun <reified T : Event> eventListener(eventPriority: EventPriority = EventPriority.NORMAL,
                                             ignoreCancelled: Boolean = false,
                                             noinline block: T.() -> Unit) =
		PackingEvent(T::class.java, eventPriority, ignoreCancelled, block)
