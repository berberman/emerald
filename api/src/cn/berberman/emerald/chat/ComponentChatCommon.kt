@file:JvmName("ComponentChatBuilderUtil")

package cn.berberman.emerald.chat

import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.ComponentBuilder


fun componentChat(text: String, block: ComponentBuilder.() -> Unit = {}): ComponentBuilder = throw NotImplementedError()

fun ComponentBuilder.executeCommandOnClick(command: String): ComponentBuilder = throw NotImplementedError()

fun ComponentBuilder.showTextOnHover(vararg components: BaseComponent): ComponentBuilder = throw NotImplementedError()

fun ComponentBuilder.append(text: String, block: ComponentBuilder.() -> Unit): ComponentBuilder = throw NotImplementedError()
