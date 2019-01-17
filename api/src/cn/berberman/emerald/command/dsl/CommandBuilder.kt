package cn.berberman.emerald.command.dsl

import cn.berberman.emerald.abandon.debug
import cn.berberman.emerald.command.CommandResult
import cn.berberman.emerald.command.PackingTabCompleter
import org.bukkit.command.CommandSender


@CommandDsl
class CommandBuilder internal constructor(internal val name: String) {
    private val subCommands =
            mutableMapOf<String, SubCommandBuilder>()


    var action: Action = {
        throw NotImplementedError()
    }
        private set

    var description: String = ""

    var usageMessage: String = ""

    internal val aliases: MutableList<String> = mutableListOf()

    var permission: String = ""

    var permissionMessage: String = ""


    fun action(block: Action) {
        throw NotImplementedError()
    }


    fun subCommand(name: String, block: SubCommandBuilder.() -> Unit) {
        throw NotImplementedError()

    }


    fun addAlias(alias: String) :Boolean=        throw NotImplementedError()



    private fun dispatchSubCommand(sender: CommandSender, args: Array<out String>): Pair<String, CommandResult> =
            throw NotImplementedError()


    internal val defaultProcessTabComplete: PackingTabCompleter.(CommandSender, Array<out String>) -> Unit =
            { _, _ ->
                throw NotImplementedError()
            }
}
