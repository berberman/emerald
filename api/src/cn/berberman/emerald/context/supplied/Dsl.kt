package cn.berberman.emerald.context.supplied

import cn.berberman.emerald.command.dsl.CommandsBuilder
import cn.berberman.emerald.event.PackingEvent
import cn.berberman.emerald.util.ContextUtil


fun registerCommands(block: CommandsBuilder.() -> Unit): Unit =
		cn.berberman.emerald.command.dsl.registerCommands(ContextUtil.getPluginInstance(), block)

fun PackingEvent<*>.register(): Unit = register(ContextUtil.getPluginInstance())

fun PackingEvent<*>.unregister(): Unit = unregister(ContextUtil.getPluginInstance())


