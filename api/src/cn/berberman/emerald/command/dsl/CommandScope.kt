package cn.berberman.emerald.command.dsl

import cn.berberman.emerald.command.CommandResult
import org.bukkit.command.CommandSender

@CommandScopeDsl
class CommandScope internal constructor(val sender: CommandSender,
                                        val args: Array<out String>,
                                        name: String,
                                        private val block: CommandScope.() -> CommandResult) {

    var name: String = name
        internal set

    internal fun dispatchCommand(): Pair<String, CommandResult> = throw NotImplementedError()


    infix fun CommandResult.otherwise(block: () -> CommandResult): CommandResult =
            throw NotImplementedError()


    class Uncertain(expect: String) : CommandResult.Failed("You are not a(n) ${expect.toLowerCase()}")


    inline fun <reified T : CommandSender>
            whenSenderIs(block: (casted: T) -> CommandResult): CommandResult =
            throw NotImplementedError()

}
