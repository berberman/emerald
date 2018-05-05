@file:JvmName("PlayerUtil")

package cn.berberman.emerald.player

import cn.berberman.emerald.chat.componentChat
import cn.berberman.emerald.chat.tallraw.TellrawMessage
import cn.berberman.emerald.chat.tallraw.tellrawMessage
import cn.berberman.emerald.chat.tallraw.toIChatBaseComponent
import cn.berberman.emerald.item.book
import cn.berberman.emerald.reflection.wrapper.chat.NmsChatComponentText
import cn.berberman.emerald.reflection.wrapper.chat.NmsChatMessageType
import cn.berberman.emerald.reflection.wrapper.packet.NmsPacketPlayOutChat
import cn.berberman.emerald.reflection.wrapper.packet.NmsPacketPlayOutPlayerListHeaderFooter
import cn.berberman.emerald.reflection.wrapper.player.BukkitCraftPlayer
import cn.berberman.emerald.reflection.wrapper.player.NmsEnumHand
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.ComponentBuilder
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BookMeta


fun Player.toCraftPlayer() = BukkitCraftPlayer.Holder[this]


fun Player.sendActionBar(text: String) =
		toCraftPlayer()
				.getHandle()
				.playerConnection
				.sendPacket(NmsPacketPlayOutChat(NmsChatComponentText(text)
						, NmsChatMessageType.GAME_INFO))

fun Player.tellraw(tellrawMessage: TellrawMessage) =
		toCraftPlayer()
				.getHandle()
				.playerConnection
				.sendPacket(NmsPacketPlayOutChat(tellrawMessage.toIChatBaseComponent()))

fun Player.tellraw(text: String, builder: TellrawMessage.() -> Unit) =
		tellraw(tellrawMessage(text).apply(builder))


fun Player.sendComponentActionBar(vararg components: BaseComponent) =
		sendActionBar(components.joinToString { it.toLegacyText() })

fun Player.sendComponentActionBar(builder: ComponentBuilder) =
		spigot().sendMessage(ChatMessageType.ACTION_BAR, *builder.create())

fun Player.sendComponentActionBar(text: String, builder: ComponentBuilder.() -> Unit = {}) =
		spigot().sendMessage(ChatMessageType.ACTION_BAR, *componentChat(text, builder).create())

fun Player.sendComponentChat(vararg components: BaseComponent) =
		spigot().sendMessage(ChatMessageType.CHAT, *components)

fun Player.sendComponentChat(builder: ComponentBuilder) =
		spigot().sendMessage(ChatMessageType.CHAT, *builder.create())

fun Player.sendComponentChat(text: String, builder: ComponentBuilder.() -> Unit = {}) =
		spigot().sendMessage(ChatMessageType.CHAT, *componentChat(text, builder).create())


fun Player.broadcastCarriedItem() = toCraftPlayer().getHandle().broadcastCarriedItem()

fun Player.openBook(book: ItemStack) {
	if (book.type != Material.WRITTEN_BOOK)
		throw IllegalArgumentException("That's not a book")
	val temp = inventory.itemInMainHand
	inventory.itemInMainHand = book
	toCraftPlayer().getHandle().openBook(NmsEnumHand.MAIN_HAND)
	inventory.itemInMainHand = temp
}

fun Player.openBook(block: BookMeta.() -> Unit) = openBook(book(block))

fun allPlayers(operation: Player.() -> Unit) =
		Bukkit.getOnlinePlayers().forEach(operation)

fun Player.setPlayerListHeaderAndFooter(header: TellrawMessage, footer: TellrawMessage) {
	toCraftPlayer()
			.getHandle()
			.playerConnection
			.sendPacket(NmsPacketPlayOutPlayerListHeaderFooter(header.toIChatBaseComponent(), footer.toIChatBaseComponent()))
}
