package cn.berberman.emerald.command.dsl


@SubCommandDsl
class SubCommandBuilder internal constructor(internal val name: String) {

    var action: Action = { throw NotImplementedError() }
        private set


    fun action(block: Action) {
        throw NotImplementedError()
    }

}
