@file:JvmName("ItemStackUtil")


package cn.berberman.emerald.item

import cn.berberman.emerald.chat.componentChat
import cn.berberman.emerald.chat.tallraw.TellrawMessage
import cn.berberman.emerald.chat.tallraw.toIChatBaseComponent
import cn.berberman.emerald.item.modifier.NBTAttributeModifier
import cn.berberman.emerald.item.modifier.NBTRawModifier
import cn.berberman.emerald.reflection.wrapper.meta.BukkitCraftMetaBook
import cn.berberman.emerald.util.safeCast
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.ComponentBuilder
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BannerMeta
import org.bukkit.inventory.meta.BookMeta
import org.bukkit.inventory.meta.ItemMeta


fun ItemStack.operateMeta(block: ItemMeta.() -> Unit) = apply {
	itemMeta = itemMeta.apply(block)
}


fun ItemStack.modifyNBTAttribute(block: NBTAttributeModifier.() -> Unit) = NBTAttributeModifier(this).apply(block).getResult()

fun ItemStack.modifyNBTRaw(block: NBTRawModifier.() -> Unit) = NBTRawModifier(this).apply(block).getResult()

fun ItemStack.operateBookMeta(block: BookMeta.() -> Unit) = apply {
	itemMeta = itemMeta.safeCast<BookMeta>()?.apply(block)
			?: throw IllegalStateException("This is not a book!")
}

fun ItemStack.operateBannerMeta(block: BannerMeta.() -> Unit) = apply {
	itemMeta = itemMeta.safeCast<BannerMeta>()?.apply(block)
			?: throw IllegalStateException("This is not a banner!")
}

fun BookMeta.addPage(vararg baseComponent: BaseComponent) = spigot().addPage(baseComponent)

fun BookMeta.addPage(text: String, block: ComponentBuilder.() -> Unit) = spigot().addPage(componentChat(text, block).create())

fun BookMeta.addPage(text: TellrawMessage) {
	toCraft().addPage(text.toIChatBaseComponent())
}

fun ItemMeta.addLore(lore: String) = this.lore.add(lore)

fun BookMeta.toCraft() = BukkitCraftMetaBook.Holder[this]

fun book(block: BookMeta.() -> Unit) = ItemStack(Material.WRITTEN_BOOK).operateBookMeta(block)
