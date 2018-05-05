package cn.berberman.emerald.reflection.wrapper.server

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.invokeMethod
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper
import cn.berberman.emerald.util.unsafeCast
import org.bukkit.Bukkit

object NmsMinecraftServer : ReflectionWrapper() {

	override val clazz: Class<*> = ReflectionClasses.Nms.MinecraftServer()

	override val handle: Any = ReflectionClasses.CraftBukkit.CraftServer().invokeMethod(
			Bukkit.getServer(),
			"getServer"
	)!!

	val primaryThread: Thread = fields("primaryThread")!!.unsafeCast()
}
