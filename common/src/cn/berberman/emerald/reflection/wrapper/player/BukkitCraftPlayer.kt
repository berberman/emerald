package cn.berberman.emerald.reflection.wrapper.player

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper
import cn.berberman.emerald.reflection.wrapper.WrapperHolder
import org.bukkit.entity.Player


class BukkitCraftPlayer(player: Player) : ReflectionWrapper() {
	override val clazz: Class<*> = ReflectionClasses.CraftBukkit.CraftPlayer()

	override val handle: Any = player


	fun getHandle() =
			NmsEntityPlayer.Holder[(methods("getHandle")!!)]


	object Holder : WrapperHolder<Player, BukkitCraftPlayer>(::BukkitCraftPlayer)

}
