package cn.berberman.emerald.command.dsl

import cn.berberman.emerald.command.CommandResult
import org.bukkit.command.CommandSender

class CommandScope internal constructor(val sender: CommandSender,
                                        val args: Array<out String>,
                                        name: String,
                                        private val block: CommandScope.() -> CommandResult) {

	var name: String = name
		internal set

	infix fun CommandResult.otherwise(block: () -> CommandResult) =
			if (this is Uncertain) block() else this


	class Uncertain(expect: String) : CommandResult.Failed("You are not a(n) ${expect.toLowerCase()}")


	inline fun <reified T : CommandSender>
			whenSenderIs(block: (casted: T) -> CommandResult): CommandResult = throw NotImplementedError()
}
