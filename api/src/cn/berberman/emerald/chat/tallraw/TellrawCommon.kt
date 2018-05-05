@file:JvmName("TellrawUtil")


package cn.berberman.emerald.chat.tallraw

import org.bukkit.ChatColor

fun tellrawMessage(text: String, block: TellrawMessage.() -> Unit = {}): TellrawMessage = throw NotImplementedError()

fun ChatColor.toTellraw(): TellrawChatColor = throw NotImplementedError()
