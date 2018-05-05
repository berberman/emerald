@file:JvmName("LocationUtil")

package cn.berberman.emerald.coordinate

import org.bukkit.Location


operator fun Location.plus(location: Location): Location = throw NotImplementedError()


operator fun Location.minus(location: Location): Location = throw NotImplementedError()


operator fun Location.times(double: Double): Location = throw NotImplementedError()


operator fun Location.get(axis3D: Axis3D): Double = throw NotImplementedError()


operator fun Location.set(axis3D: Axis3D, double: Double): Unit = throw NotImplementedError()

fun Location.approximate(location: Location): Boolean = throw NotImplementedError()
