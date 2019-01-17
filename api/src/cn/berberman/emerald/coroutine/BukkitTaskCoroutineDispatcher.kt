package cn.berberman.emerald.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import org.bukkit.plugin.Plugin
import kotlin.coroutines.CoroutineContext


class BukkitTaskCoroutineDispatcher(private val plugin: Plugin,
                                    private val thread: Thread,
                                    private val runOnServerThread: Boolean)
	: CoroutineDispatcher() {
	override fun dispatch(context: CoroutineContext, block: Runnable): Unit =
			throw NotImplementedError()
}
