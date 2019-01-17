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
        dispatchSubCommand(sender, args).also {
            it.first.takeIf { it.isNotBlank() }?.let { name = it }
        }.second
    }
        private set

    var description: String = ""

    var usageMessage: String = ""

    internal val aliases: MutableList<String> = mutableListOf()

    var permission: String = ""

    var permissionMessage: String = ""


    fun action(block: Action) {
        action = {
            dispatchSubCommand(sender, args).let {
                if (it.second === CommandResult.SubCommandUnDispatched && args.isEmpty())
                    block()
                else it.also {
                    it.first.takeIf { it.isNotBlank() }?.let { name = it }
                }.second
            }
        }
    }


    fun subCommand(name: String, block: SubCommandBuilder.() -> Unit) {
        subCommands[name] = SubCommandBuilder(name).apply(block)
        debug("set subCommand: /${this.name}-$name")
    }


    fun addAlias(alias: String) = aliases.add(alias)


    private fun dispatchSubCommand(sender: CommandSender, args: Array<out String>) =
            if (args.isEmpty()) "" to CommandResult.SubCommandUnDispatched
            else subCommands[args[0]]?.let {
                CommandScope(sender, mutableListOf<String>()
                        .apply {
                            addAll(args)
                            remove(args[0])
                        }.toTypedArray(), "$name-${it.name}", it.action)
            }?.dispatchCommand()
                    ?: "" to CommandResult.SubCommandUnDispatched

    internal val defaultProcessTabComplete: PackingTabCompleter.(CommandSender, Array<out String>) -> Unit =
            { _, args ->
                subCommands.keys.filter { it.startsWith(args.last(), true) }.let(this::addAll)
                sort()
            }
}
