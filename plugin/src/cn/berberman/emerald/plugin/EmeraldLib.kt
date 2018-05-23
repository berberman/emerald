package cn.berberman.emerald.plugin

import cn.berberman.emerald.command.CommandResult
import cn.berberman.emerald.command.dsl.registerCommands
import cn.berberman.emerald.event.events.player.EmeraldChannelHandler
import cn.berberman.emerald.event.events.server.EmeraldProxySelector
import cn.berberman.emerald.util.EmeraldUtil
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.net.ProxySelector


class EmeraldLib : JavaPlugin() {
	private lateinit var configFile: File

	internal companion object {
		internal val plugin: EmeraldLib = EmeraldUtil.getPluginInstance()
		internal var debug: Boolean = false
	}

	override fun onEnable() {
		if (!dataFolder.exists())
			dataFolder.mkdir()
		configFile = File(dataFolder, "config.yml")
		if (!configFile.exists())
			saveDefaultConfig()
		reloadConfig()
		val useProxySelector = config.getBoolean("useProxySelector", true)
		val addNettyHandler = config.getBoolean("addNettyHandler", true)
		val printDebugMessage = config.getBoolean("debug-message", false)

		debug = printDebugMessage
		if (useProxySelector)
			EmeraldProxySelector.init(ProxySelector.getDefault())
		if (addNettyHandler)
			EmeraldChannelHandler.register(this)


		registerCommands(this) {

			command("test") {
				subCommand("a") {
					action { sender.sendMessage("Hi");CommandResult.Successful }
				}
				subCommand("b") {
					action {
						whenSenderIs<Player>
						{
							it.kickPlayer("GG")
							CommandResult.Successful
						} otherwise {
							sender.sendMessage("你不是玩家")
							CommandResult.Failed
						}
					}
				}
			}
		}
	}

}