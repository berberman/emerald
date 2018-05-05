package cn.berberman.emerald.event.events.player

import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList
import org.bukkit.event.player.PlayerEvent

sealed class PlayerPacketEvent(player: Player, var msg: Any) : PlayerEvent(player), Cancellable {


	override fun setCancelled(cancel: Boolean) {
		cancelled = cancel
	}

	override fun isCancelled(): Boolean = cancelled

	private var cancelled = false


	class PlayerPacketPlayInEvent(player: Player, msg: Any) : PlayerPacketEvent(player, msg) {
		override fun getHandlers(): HandlerList = getHandlerList()

		companion object {
			private val handlers = HandlerList()

			@JvmStatic
			fun getHandlerList() = handlers
		}
	}

	class PlayerPacketPlayOutEvent(player: Player, msg: Any) : PlayerPacketEvent(player, msg) {
		override fun getHandlers(): HandlerList = getHandlerList()

		companion object {
			private val handlers = HandlerList()

			@JvmStatic
			fun getHandlerList() = handlers
		}
	}
}
