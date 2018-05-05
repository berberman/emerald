@file:JvmName("ItemStackUtil")


package cn.berberman.emerald.item

import cn.berberman.emerald.chat.tallraw.TellrawMessage
import cn.berberman.emerald.item.modifier.NBTAttributeModifier
import cn.berberman.emerald.item.modifier.NBTRawModifier
import cn.berberman.emerald.util.safeCast
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.ComponentBuilder
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BannerMeta
import org.bukkit.inventory.meta.BookMeta
import org.bukkit.inventory.meta.ItemMeta


fun ItemStack.operateMeta(block: ItemMeta.() -> Unit): ItemStack = throw NotImplementedError()


fun ItemStack.modifyNBTAttribute(block: NBTAttributeModifier.() -> Unit): ItemStack = throw NotImplementedError()

fun ItemStack.modifyNBTRaw(block: NBTRawModifier.() -> Unit): ItemStack = NBTRawModifier(this).apply(block).getResult()

fun ItemStack.operateBookMeta(block: BookMeta.() -> Unit): ItemStack = apply {
	itemMeta = itemMeta.safeCast<BookMeta>()?.apply(block)
			?: throw IllegalStateException("This is not a book!")
}

fun ItemStack.operateBannerMeta(block: BannerMeta.() -> Unit): ItemStack = throw NotImplementedError()


fun BookMeta.addPage(vararg baseComponent: BaseComponent): Unit = throw NotImplementedError()


fun BookMeta.addPage(text: String, block: ComponentBuilder.() -> Unit): Unit = throw NotImplementedError()


fun BookMeta.addPage(text: TellrawMessage) {
	throw NotImplementedError()

}

fun ItemMeta.addLore(lore: String): Boolean = throw NotImplementedError()


fun book(block: BookMeta.() -> Unit): ItemStack = throw NotImplementedError()
