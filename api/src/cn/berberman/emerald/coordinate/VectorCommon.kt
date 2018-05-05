@file:JvmName("VectorUtil")

package cn.berberman.emerald.coordinate

import org.bukkit.util.Vector


operator fun Vector.plus(vector: Vector): Vector = throw NotImplementedError()


operator fun Vector.minus(vector: Vector): Vector = throw NotImplementedError()


operator fun Vector.times(vector: Vector): Vector = throw NotImplementedError()


operator fun Vector.times(double: Double): Vector = throw NotImplementedError()


operator fun Vector.div(vector: Vector): Vector = throw NotImplementedError()


operator fun Vector.get(axis3D: Axis3D): Double = throw NotImplementedError()


operator fun Vector.set(axis3D: Axis3D, double: Double): Unit = throw NotImplementedError()
