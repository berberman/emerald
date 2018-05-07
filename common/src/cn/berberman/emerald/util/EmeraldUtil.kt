@file:JvmMultifileClass
@file:JvmName("CommonUtil")

package cn.berberman.emerald.util

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.invokeMethod
import cn.berberman.emerald.reflection.wrapper.server.NmsMinecraftServer
import cn.berberman.emerald.reflection.wrapper.world.BukkitCraftWorld
import com.google.gson.Gson
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.command.CommandMap
import org.bukkit.event.Listener
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import java.io.Reader

object EmeraldUtil {

	val commandMap = ReflectionClasses.CraftBukkit.CraftServer()
			.invokeMethod(Bukkit.getServer(), "getCommandMap") as CommandMap

	val minecraftServer = NmsMinecraftServer

	val serverThread: Thread = NmsMinecraftServer.primaryThread

	internal val emptyListener = object : Listener {}


	inline fun <reified T : JavaPlugin> getPluginInstance(): T = JavaPlugin.getPlugin(T::class.java)


	val pluginManager: PluginManager = Bukkit.getPluginManager()


}

inline fun <reified T> Any?.safeCast() = this as? T

inline fun <reified T> Any.unsafeCast() = safeCast<T>()!!

inline fun <reified T : Any> Gson.fromJson(json: String): T = fromJson(json, T::class.java)

inline fun <reified T : Any> Gson.fromJson(json: Reader): T = fromJson(json, T::class.java)

fun <T : Any> T.toJson(): String = Gson().toJson(this)

fun World.toCraftWorld() = BukkitCraftWorld.Holder[this]

