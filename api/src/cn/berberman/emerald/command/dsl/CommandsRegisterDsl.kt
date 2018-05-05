package cn.berberman.emerald.command.dsl

import cn.berberman.emerald.command.CommandResult
import cn.berberman.emerald.command.annotation.CommonBuilderMarker
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin


@CommonBuilderMarker
class CommandsBuilder internal constructor() {


	fun before(block: (CommandSender, String) -> Unit) {
		throw NotImplementedError()
	}


	fun after(block: (CommandSender, String) -> Unit) {
		throw NotImplementedError()
	}


	fun command(name: String, block: CommandBuilderDsl.() -> Unit): Unit = throw NotImplementedError()


	internal fun register(plugin: Plugin, commandMap: CommandMap): Unit = throw NotImplementedError()
}


fun registerCommands(plugin: Plugin, block: CommandsBuilder.() -> Unit): Unit = throw NotImplementedError()


fun CommandsBuilder.register(plugin: Plugin): Unit = throw NotImplementedError()

typealias Action = CommandScope.() -> CommandResult
