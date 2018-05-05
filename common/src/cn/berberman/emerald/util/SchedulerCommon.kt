@file:JvmName("SchedulerUtil")

package cn.berberman.emerald.util

import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitTask


fun bukkitAsyncLoop(plugin: Plugin, delay: Long = 0L, block: () -> Boolean) = bukkitAsync(plugin, delay) {
	var result = block()
	while (result)
		result = block()
}


fun bukkitAsync(plugin: Plugin, delay: Long = 0L, block: () -> Unit): BukkitTask =
		Bukkit.getScheduler().let {
			if (delay != 0L) it.runTaskAsynchronously(plugin, block)
			else it.runTaskLaterAsynchronously(plugin, block, delay)
		}


fun runOnServerThread(plugin: Plugin, delay: Long = 0L, block: () -> Unit): BukkitTask =
		Bukkit.getScheduler().let {
			if (delay != 0L) it.runTask(plugin, block)
			else it.runTaskLater(plugin, block, delay)
		}

fun bukkitPeriodAsync(plugin: Plugin, delay: Long = 0L, period: Long, block: () -> Unit): BukkitTask =
		Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, block, delay, period)
