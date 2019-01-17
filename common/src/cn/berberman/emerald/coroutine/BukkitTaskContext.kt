package cn.berberman.emerald.coroutine

import org.bukkit.scheduler.BukkitTask
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext


class BukkitTaskContext(task: BukkitTask) : AbstractCoroutineContextElement(BukkitTaskContext),
                                            BukkitTask by task {
	companion object : CoroutineContext.Key<BukkitTaskContext>
}