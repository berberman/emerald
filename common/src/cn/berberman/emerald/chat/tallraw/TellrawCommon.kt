@file:JvmName("TellrawUtil")


package cn.berberman.emerald.chat.tallraw

import cn.berberman.emerald.reflection.wrapper.chat.NmsChatSerializer
import org.bukkit.ChatColor

fun tellrawMessage(text: String, block: TellrawMessage.() -> Unit = {}) =
		TellrawMessage(text).apply(block)

fun TellrawMessage.toIChatBaseComponent() =
		NmsChatSerializer.decodeFromString(toJsonString())

fun List<TellrawMessage>.toIChatBaseList() =
		map { NmsChatSerializer.decodeFromString(it.toJsonString()) }

fun ChatColor.toTellraw() = TellrawChatColor.valueOf(name)
