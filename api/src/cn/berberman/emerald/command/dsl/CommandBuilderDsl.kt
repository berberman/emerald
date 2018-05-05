package cn.berberman.emerald.command.dsl

import cn.berberman.emerald.command.annotation.CommandBuilderMarker


@CommandBuilderMarker
class CommandBuilderDsl internal constructor(internal val name: String) {


	var description: String = ""

	var usageMessage: String = ""

	internal val aliases: MutableList<String> = throw NotImplementedError()

	var permission: String = ""

	var permissionMessage: String = ""


	fun action(block: Action) {
		throw NotImplementedError()
	}


	fun subCommand(name: String, block: SubCommandBuilderDsl.() -> Unit) {
		throw NotImplementedError()
	}


	fun addAlias(alias: String): Boolean = throw NotImplementedError()


}
