@file:JvmName("LocationUtil")

package cn.berberman.emerald.coordinate

import org.bukkit.Location


operator fun Location.plus(location: Location): Location = add(location)


operator fun Location.minus(location: Location): Location = subtract(location)


operator fun Location.times(double: Double): Location = multiply(double)


operator fun Location.get(axis3D: Axis3D) = when (axis3D) {
	Axis3D.X -> x
	Axis3D.Y -> y
	Axis3D.Z -> z
}


operator fun Location.set(axis3D: Axis3D, double: Double) = when (axis3D) {
	Axis3D.X -> x = double
	Axis3D.Y -> y = double
	Axis3D.Z -> z = double
}

fun Location.approximate(location: Location) =
		blockX == location.blockX
				&& blockY == location.blockY
				&& blockZ == location.blockZ
