package cn.berberman.emerald.command

import cn.berberman.emerald.command.dsl.Action
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter


internal class PackingCommand
(name: String,
 description: String,
 usageMessage: String,
 aliases: List<String>,
 private val action: Action,
 permission: String,
 permissionMessage: String,
 private val before: (CommandSender, String) -> Unit,
 private val after: (CommandSender, String) -> Unit,
 private val completer: TabCompleter
) : Command(name,
		description,
		usageMessage,
		aliases) {
	init {
		throw NotImplementedError()
	}


	override fun execute(p0: CommandSender, p1: String, p: Array<out String>): Boolean = throw NotImplementedError()

	override fun tabComplete(sender: CommandSender, alias: String, args: Array<out String>): List<String> = throw NotImplementedError()
}
