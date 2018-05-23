package cn.berberman.emerald.coroutine

import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.Runnable
import org.bukkit.plugin.Plugin
import kotlin.coroutines.experimental.CoroutineContext

class BukkitTaskCoroutineDispatcher(private val plugin: Plugin,
                                    private val thread: Thread,
                                    private val runOnServerThread: Boolean)
	: CoroutineDispatcher() {
	override fun dispatch(context: CoroutineContext, block: Runnable): Unit =
			throw NotImplementedError()
}
