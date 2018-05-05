package cn.berberman.emerald.context.supplied

import cn.berberman.emerald.util.*
import org.bukkit.scheduler.BukkitTask


fun bukkitAsyncLoop(delay: Long = 0L, block: () -> Boolean): BukkitTask = bukkitAsyncLoop(ContextUtil.getPluginInstance(), delay, block)


fun bukkitAsync(delay: Long = 0L, block: () -> Unit): BukkitTask = bukkitAsync(ContextUtil.getPluginInstance(), delay, block)


fun runOnServerThread(delay: Long = 0L, block: () -> Unit): BukkitTask = runOnServerThread(ContextUtil.getPluginInstance(), delay, block)


fun bukkitPeriodAsync(delay: Long = 0L, period: Long, block: () -> Unit): BukkitTask =
		bukkitPeriodAsync(ContextUtil.getPluginInstance(), delay, period, block)
