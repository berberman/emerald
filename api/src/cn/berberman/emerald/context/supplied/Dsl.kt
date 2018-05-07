package cn.berberman.emerald.context.supplied

import cn.berberman.emerald.command.dsl.CommandsBuilder
import cn.berberman.emerald.event.PackingEvent
import cn.berberman.emerald.event.dsl.EventsBuilder


fun registerCommands(block: CommandsBuilder.() -> Unit): Unit =
		throw NotImplementedError()

fun registerEventListeners(block: EventsBuilder.() -> Unit): EventsBuilder =
		throw NotImplementedError()


fun PackingEvent<*>.register(): Unit = throw NotImplementedError()

fun PackingEvent<*>.unregister(): Unit = throw NotImplementedError()


