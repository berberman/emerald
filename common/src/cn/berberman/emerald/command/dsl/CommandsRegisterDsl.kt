package cn.berberman.emerald.command.dsl

import cn.berberman.emerald.abandon.debug
import cn.berberman.emerald.command.CommandResult
import cn.berberman.emerald.command.PackingCommand
import cn.berberman.emerald.command.PackingTabCompleter
import cn.berberman.emerald.command.annotation.CommonBuilderMarker
import cn.berberman.emerald.util.EmeraldUtil
import org.bukkit.command.Command
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin


@CommonBuilderMarker
class CommandsBuilder internal constructor() {

	private val commands = mutableSetOf<PackingCommand>()


	private var before: (CommandSender, String) -> Unit = { _, _ -> }


	private var after: (CommandSender, String) -> Unit = { _, _ -> }


	fun before(block: (CommandSender, String) -> Unit) {
		before = block
	}


	fun after(block: (CommandSender, String) -> Unit) {
		after = block
	}


	fun command(name: String, block: CommandBuilderDsl.() -> Unit) {
		CommandBuilderDsl(name).apply(block).apply {
			PackingCommand(this.name,
					description,
					usageMessage,
					aliases,
					action,
					permission,
					permissionMessage, before, after, PackingTabCompleter(defaultProcessTabComplete))
					.takeUnless { commands.any { e -> e.name == it.name } }?.let(commands::add)
					?: throw IllegalArgumentException("Command Already Existed")

		}
	}


	internal fun register(plugin: Plugin, commandMap: CommandMap) {
		commands.forEach {
			commandMap.register(plugin.name, it as Command)
			debug("register command: /${it.name}")
		}
	}
}


fun registerCommands(plugin: Plugin, block: CommandsBuilder.() -> Unit) =
		generateCommands(plugin, block).register(plugin)


fun CommandsBuilder.register(plugin: Plugin) =
		register(plugin, EmeraldUtil.commandMap)

fun generateCommands(plugin: Plugin, block: CommandsBuilder.() -> Unit) =
		CommandsBuilder().apply(block)

typealias Action = CommandScope.() -> CommandResult
