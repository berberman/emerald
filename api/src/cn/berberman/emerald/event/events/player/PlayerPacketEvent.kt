package cn.berberman.emerald.event.events.player

import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList
import org.bukkit.event.player.PlayerEvent

sealed class PlayerPacketEvent(player: Player, var msg: Any) : PlayerEvent(player), Cancellable {


	override fun setCancelled(cancel: Boolean) {
		throw NotImplementedError()
	}

	override fun isCancelled(): Boolean = throw NotImplementedError()


	class PlayerPacketPlayInEvent(player: Player, msg: Any) : PlayerPacketEvent(player, msg) {
		override fun getHandlers(): HandlerList = throw NotImplementedError()

		companion object {
			@JvmStatic
			fun getHandlerList(): HandlerList = throw NotImplementedError()
		}
	}

	class PlayerPacketPlayOutEvent(player: Player, msg: Any) : PlayerPacketEvent(player, msg) {
		override fun getHandlers(): HandlerList = throw NotImplementedError()

		companion object {
			@JvmStatic
			fun getHandlerList(): HandlerList = throw NotImplementedError()
		}
	}
}
