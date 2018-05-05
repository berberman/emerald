package cn.berberman.emerald.event.events.player

import cn.berberman.emerald.event.PackingEvent
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelPromise
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.Plugin

@ChannelHandler.Sharable
object EmeraldChannelHandler : ChannelDuplexHandler() {
	override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
		throw NotImplementedError()
	}

	override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise?) {
		throw NotImplementedError()
	}

	private fun addChannelHandler(player: Player) {
		throw NotImplementedError()
	}

	private fun removeChannelHandler(player: Player) {
		throw NotImplementedError()
	}

	private val joinInject: PackingEvent<PlayerJoinEvent> =
			throw NotImplementedError()
	private val quitInject: PackingEvent<PlayerQuitEvent> =
			throw NotImplementedError()

	fun register(plugin: Plugin) {
		throw NotImplementedError()
	}
}
