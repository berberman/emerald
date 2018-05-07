package cn.berberman.emerald.context.supplied

import cn.berberman.emerald.command.dsl.CommandsBuilder
import cn.berberman.emerald.command.dsl.registerCommands
import cn.berberman.emerald.event.PackingEvent
import cn.berberman.emerald.event.dsl.EventsBuilder
import cn.berberman.emerald.event.dsl.registerEventListeners
import cn.berberman.emerald.util.ContextUtil


fun registerCommands(block: CommandsBuilder.() -> Unit) =
		registerCommands(ContextUtil.getPluginInstance(), block)

fun registerEventListeners(block: EventsBuilder.() -> Unit) =
		registerEventListeners(ContextUtil.getPluginInstance(), block)

fun PackingEvent<*>.register() = register(ContextUtil.getPluginInstance())

fun PackingEvent<*>.unregister() = unregister(ContextUtil.getPluginInstance())
