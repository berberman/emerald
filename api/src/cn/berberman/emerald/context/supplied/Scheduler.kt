package cn.berberman.emerald.context.supplied

import org.bukkit.scheduler.BukkitTask


fun bukkitAsyncLoop(delay: Long = 0L, block: () -> Boolean): BukkitTask = throw NotImplementedError()


fun bukkitAsync(delay: Long = 0L, block: () -> Unit): BukkitTask = throw NotImplementedError()


fun runOnServerThread(delay: Long = 0L, block: () -> Unit): BukkitTask = throw NotImplementedError()


fun bukkitPeriodAsync(delay: Long = 0L, period: Long, block: () -> Unit): BukkitTask = throw NotImplementedError()
