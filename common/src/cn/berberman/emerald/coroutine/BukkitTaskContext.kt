package cn.berberman.emerald.coroutine

import org.bukkit.scheduler.BukkitTask
import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.CoroutineContext

class BukkitTaskContext(task: BukkitTask) : AbstractCoroutineContextElement(BukkitTaskContext),
                                            BukkitTask by task {
	companion object : CoroutineContext.Key<BukkitTaskContext>
}