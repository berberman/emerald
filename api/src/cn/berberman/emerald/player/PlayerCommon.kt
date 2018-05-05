@file:JvmName("PlayerUtil")

package cn.berberman.emerald.player

import cn.berberman.emerald.chat.tallraw.TellrawMessage
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.ComponentBuilder
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BookMeta


fun Player.sendActionBar(text: String): Unit =
		throw NotImplementedError()


fun Player.tellraw(tellrawMessage: TellrawMessage): Unit =
		throw NotImplementedError()


fun Player.tellraw(text: String, builder: TellrawMessage.() -> Unit): Unit =
		throw NotImplementedError()


fun Player.sendComponentActionBar(vararg components: BaseComponent): Unit =
		throw NotImplementedError()


fun Player.sendComponentActionBar(builder: ComponentBuilder): Unit =
		throw NotImplementedError()


fun Player.sendComponentActionBar(text: String, builder: ComponentBuilder.() -> Unit = {}): Unit =
		throw NotImplementedError()


fun Player.sendComponentChat(vararg components: BaseComponent): Unit =
		throw NotImplementedError()


fun Player.sendComponentChat(builder: ComponentBuilder): Unit =
		throw NotImplementedError()


fun Player.sendComponentChat(text: String, builder: ComponentBuilder.() -> Unit = {}): Unit =
		throw NotImplementedError()


fun Player.broadcastCarriedItem(): Unit = throw NotImplementedError()


fun Player.openBook(book: ItemStack) {
	throw NotImplementedError()

}

fun Player.openBook(block: BookMeta.() -> Unit): Unit = throw NotImplementedError()


fun allPlayers(operation: Player.() -> Unit): Unit =
		throw NotImplementedError()


fun Player.setPlayerListHeaderAndFooter(header: TellrawMessage, footer: TellrawMessage) {
	throw NotImplementedError()

}
