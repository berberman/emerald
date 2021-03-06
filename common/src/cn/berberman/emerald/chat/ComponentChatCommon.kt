@file:JvmName("ComponentChatBuilderUtil")

package cn.berberman.emerald.chat

import cn.berberman.emerald.reflection.wrapper.chat.NmsChatSerializer
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.ComponentBuilder
import net.md_5.bungee.api.chat.HoverEvent
import net.md_5.bungee.chat.ComponentSerializer

fun ComponentBuilder.createToIChatBaseList() =
		create().toIChatBaseList()

fun Array<BaseComponent>.toIChatBaseList() =
		map { ComponentSerializer.toString(it) }.map(NmsChatSerializer.Companion::decodeFromString)

fun componentChat(text: String, block: ComponentBuilder.() -> Unit = {}) =
		ComponentBuilder(text).apply(block)

fun ComponentBuilder.executeCommandOnClick(command: String): ComponentBuilder =
		event(ClickEvent(ClickEvent.Action.RUN_COMMAND, command))

fun ComponentBuilder.showTextOnHover(vararg components: BaseComponent): ComponentBuilder =
		event(HoverEvent(HoverEvent.Action.SHOW_TEXT, components))

fun ComponentBuilder.append(text: String, block: ComponentBuilder.() -> Unit) = append(componentChat(text, block).create())
