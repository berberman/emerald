package cn.berberman.emerald.command.dsl

import cn.berberman.emerald.command.CommandResult
import cn.berberman.emerald.command.annotation.SubCommandBuilderMarker


@SubCommandBuilderMarker
class SubCommandBuilderDsl internal constructor(internal val name: String) {

	var action: Action = { CommandResult.Successful }
		private set


	fun action(block: Action) {
		action = block
	}

}
