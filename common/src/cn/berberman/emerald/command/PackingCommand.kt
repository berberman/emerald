package cn.berberman.emerald.command

import cn.berberman.emerald.command.dsl.Action
import cn.berberman.emerald.command.dsl.CommandScope
import cn.berberman.emerald.context.supplied.debug
import org.bukkit.ChatColor
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
		if (permissionMessage.isNotBlank())
			super.setPermissionMessage(permissionMessage)
		if (permission.isNotBlank())
			super.setPermission(permission)
	}


	override fun execute(p0: CommandSender, p1: String, p: Array<out String>): Boolean {
		before(p0, p1)
		return CommandScope(p0, p, p1, action).let(CommandScope::dispatchCommand).let { result ->
			if (result.second === CommandResult.Successful) true
			else {
				p0.sendMessage(ChatColor.RED.toString() + if (result.second.message.isNotBlank()) result.second.message
				else "An error occurs during you execute command: /${result.first}")
				debug("plugin command:/${result.first} execute with error(s) by $p0" +
						" ${if (result.second.message.isNotBlank()) "message: ${result.second.message}" else ""}")
				after(p0, p1)
				false
			}
		}
	}

	override fun tabComplete(sender: CommandSender, alias: String, args: Array<out String>): List<String> {
		return completer.onTabComplete(sender, this, alias, args)
	}
}
