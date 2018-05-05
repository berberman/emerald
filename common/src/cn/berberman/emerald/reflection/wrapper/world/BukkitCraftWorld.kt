package cn.berberman.emerald.reflection.wrapper.world

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper
import cn.berberman.emerald.reflection.wrapper.WrapperHolder
import org.bukkit.World

class BukkitCraftWorld(world: World) : ReflectionWrapper() {

	override val clazz: Class<*> = ReflectionClasses.CraftBukkit.CraftWorld()

	override val handle: Any = world

	fun getHandle() = NmsWorldServer.Holder[methods("getHandle")!!]

	object Holder : WrapperHolder<World, BukkitCraftWorld>(::BukkitCraftWorld)
}
