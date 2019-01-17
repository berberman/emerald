package cn.berberman.emerald.event.dsl

import cn.berberman.emerald.event.PackingEvent
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.plugin.Plugin

@EventSetDsl
class EventSetBuilder internal constructor(private val plugin: Plugin) {

    inline fun <reified T : Event> event(eventPriority: EventPriority = EventPriority.NORMAL,
                                         ignoreCancelled: Boolean = false,
                                         noinline block: T.() -> Unit): Boolean =
            throw NotImplementedError()

    @PublishedApi
    internal val events = mutableSetOf<PackingEvent<*>>()

    fun registerAll() {
        throw NotImplementedError()
    }

    fun unregisterAll() {
        throw NotImplementedError()
    }

}


fun registerEventListeners(plugin: Plugin, block: EventSetBuilder.() -> Unit): EventSetBuilder =
        throw NotImplementedError()

inline fun <reified T : Event> eventListener(eventPriority: EventPriority = EventPriority.NORMAL,
                                             ignoreCancelled: Boolean = false,
                                             noinline block: T.() -> Unit): PackingEvent<T> =
        throw NotImplementedError()
