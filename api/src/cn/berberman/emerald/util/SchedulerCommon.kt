@file:JvmName("SchedulerUtil")

package cn.berberman.emerald.util

import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitTask


fun bukkitAsyncLoop(plugin: Plugin, delay: Long = 0L, block: () -> Boolean): BukkitTask = throw NotImplementedError()


fun bukkitAsync(plugin: Plugin, delay: Long = 0L, block: () -> Unit): BukkitTask = throw NotImplementedError()


fun runOnServerThread(plugin: Plugin, delay: Long = 0L, block: () -> Unit): BukkitTask = throw NotImplementedError()


fun bukkitPeriodAsync(plugin: Plugin, delay: Long = 0L, period: Long, block: () -> Unit): BukkitTask = throw NotImplementedError()
