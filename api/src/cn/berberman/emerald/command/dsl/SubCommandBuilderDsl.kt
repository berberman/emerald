package cn.berberman.emerald.command.dsl

import cn.berberman.emerald.command.annotation.SubCommandBuilderMarker


@SubCommandBuilderMarker
class SubCommandBuilderDsl internal constructor(internal val name: String) {


	fun action(block: Action) {
		throw NotImplementedError()
	}

}
