@file:JvmMultifileClass
@file:JvmName("CommonUtil")

package cn.berberman.emerald.util

import cn.berberman.emerald.reflection.wrapper.server.NmsMinecraftServer
import org.bukkit.command.CommandMap

object EmeraldUtil {

	val commandMap: CommandMap = throw NotImplementedError()

	val minecraftServer: NmsMinecraftServer = throw NotImplementedError()

	val serverThread: Thread = throw NotImplementedError()

}
