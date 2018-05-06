package cn.berberman.emerald.event.events.server

import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import java.net.URI

class ServerNetworkEvent(var uri: URI) : Event(), Cancellable {
	override fun setCancelled(cancel: Boolean) {
		throw NotImplementedError()
	}

	override fun isCancelled(): Boolean = throw NotImplementedError()


	override fun getHandlers(): HandlerList = throw NotImplementedError()

	companion object {
		private val handlers = HandlerList()

		@JvmStatic
		fun getHandlerList(): HandlerList = throw NotImplementedError()
	}
}
