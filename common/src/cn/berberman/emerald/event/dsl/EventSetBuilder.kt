package cn.berberman.emerald.event.dsl

import cn.berberman.emerald.event.PackingEvent
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.plugin.Plugin

@EventSetDsl
class EventSetBuilder internal constructor(private val plugin: Plugin) {

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


fun registerEventListeners(plugin: Plugin, block: EventSetBuilder.() -> Unit) =
        EventSetBuilder(plugin).apply(block).also(EventSetBuilder::registerAll)

inline fun <reified T : Event> eventListener(eventPriority: EventPriority = EventPriority.NORMAL,
                                             ignoreCancelled: Boolean = false,
                                             noinline block: T.() -> Unit) =
        PackingEvent(T::class.java, eventPriority, ignoreCancelled, block)
