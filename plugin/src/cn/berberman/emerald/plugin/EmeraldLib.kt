package cn.berberman.emerald.plugin

import cn.berberman.emerald.event.events.player.EmeraldChannelHandler
import cn.berberman.emerald.event.events.server.EmeraldProxySelector
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.net.ProxySelector


class EmeraldLib : JavaPlugin() {
	private lateinit var configFile: File

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

		if (useProxySelector)
			EmeraldProxySelector.init(ProxySelector.getDefault())
		if (addNettyHandler)
			EmeraldChannelHandler.register(this)

	}

}