package cn.berberman.emerald.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class PackingTabCompleter(private val action: PackingTabCompleter.(CommandSender, Array<out String>) -> Unit) :
		TabCompleter,
		MutableList<String> by mutableListOf() {


	override fun onTabComplete(sender: CommandSender,
	                           command: Command,
	                           alias: String,
	                           args: Array<out String>): List<String> = throw NotImplementedError()

}

