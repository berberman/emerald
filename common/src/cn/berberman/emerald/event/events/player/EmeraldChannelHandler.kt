package cn.berberman.emerald.event.events.player

import cn.berberman.emerald.event.dsl.eventListener
import cn.berberman.emerald.player.toCraftPlayer
import cn.berberman.emerald.util.EmeraldUtil
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelPromise
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventPriority
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.Plugin

@ChannelHandler.Sharable
object EmeraldChannelHandler : ChannelDuplexHandler() {
	override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
		PlayerPacketEvent.PlayerPacketPlayInEvent(Bukkit.getPlayer(ctx.name()), msg).also(EmeraldUtil.pluginManager::callEvent).let {
			if (!it.isCancelled)
				super.channelRead(ctx, it.msg)
		}
	}

	override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise?) {
		PlayerPacketEvent.PlayerPacketPlayOutEvent(Bukkit.getPlayer(ctx.name()), msg).also(EmeraldUtil.pluginManager::callEvent).let {
			if (!it.isCancelled)
				super.write(ctx, it.msg, promise)
		}
	}

	private fun addChannelHandler(player: Player) {
		player.toCraftPlayer().getHandle()
				.playerConnection.channel.pipeline()
				.addBefore("packet_handler", player.name, this)
	}

	private fun removeChannelHandler(player: Player) {
		player.toCraftPlayer().getHandle()
				.playerConnection.channel.let {
			it.eventLoop().submit { it.pipeline().remove(player.name) }
		}
	}

	private val joinInject =
			eventListener<PlayerJoinEvent>(EventPriority.HIGHEST, true) {
				addChannelHandler(player)
			}
	private val quitInject =
			eventListener<PlayerQuitEvent>(EventPriority.HIGHEST, true) {
				removeChannelHandler(player)
			}

	fun register(plugin: Plugin) {
		joinInject.register(plugin)
		quitInject.register(plugin)
	}
}
