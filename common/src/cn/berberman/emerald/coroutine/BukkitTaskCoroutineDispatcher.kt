package cn.berberman.emerald.coroutine

import cn.berberman.emerald.util.EmeraldUtil
import kotlinx.coroutines.CoroutineDispatcher
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import kotlin.coroutines.CoroutineContext

class BukkitTaskCoroutineDispatcher(private val plugin: Plugin,
                                    private val thread: Thread,
                                    private val runOnServerThread: Boolean)
    : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        if (thread == EmeraldUtil.serverThread) block.run()
        else context + (if (runOnServerThread)
            Bukkit.getScheduler().runTask(plugin) {
                block.run()
            }
        else Bukkit.getScheduler().runTaskAsynchronously(plugin) {
            block.run()
        }).let(::BukkitTaskContext)
    }
}
