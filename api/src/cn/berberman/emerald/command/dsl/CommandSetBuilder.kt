package cn.berberman.emerald.command.dsl

import cn.berberman.emerald.command.CommandResult
import cn.berberman.emerald.command.PackingCommand
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin

@CommandSetDsl
class CommandSetBuilder internal constructor() {

    private val commands = mutableSetOf<PackingCommand>()


    private var before: (CommandSender, String) -> Unit = { _, _ -> }


    private var after: (CommandSender, String) -> Unit = { _, _ -> }


    fun before(block: (CommandSender, String) -> Unit) {
        throw NotImplementedError()
    }


    fun after(block: (CommandSender, String) -> Unit) {
        throw NotImplementedError()
    }


    fun command(name: String, block: CommandBuilder.() -> Unit) {
        throw NotImplementedError()
    }


    internal fun register(plugin: Plugin, commandMap: CommandMap) {
        throw NotImplementedError()
    }
}


fun registerCommands(plugin: Plugin, block: CommandSetBuilder.() -> Unit) {
    throw NotImplementedError()
}


fun CommandSetBuilder.register(plugin: Plugin) {
    throw NotImplementedError()
}

fun generateCommands(plugin: Plugin, block: CommandSetBuilder.() -> Unit): CommandSetBuilder =
        throw NotImplementedError()

typealias Action = CommandScope.() -> CommandResult
