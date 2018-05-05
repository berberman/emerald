package cn.berberman.emerald.reflection.wrapper.meta

import cn.berberman.emerald.chat.toIChatBaseList
import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.getFieldAccess
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper
import cn.berberman.emerald.reflection.wrapper.WrapperHolder
import cn.berberman.emerald.reflection.wrapper.chat.interfaces.NmsIChatBaseComponent
import net.md_5.bungee.api.chat.BaseComponent
import org.bukkit.inventory.meta.BookMeta

class BukkitCraftMetaBook(meta: BookMeta) : ReflectionWrapper(), BookMeta by meta {
	override val clazz: Class<*> = ReflectionClasses.CraftBukkit.CraftMetaBook()

	override val handle: Any = meta

	@Suppress("UNCHECKED_CAST")
	private val pages: MutableList<Any> = clazz.getFieldAccess()[handle, "pages"] as MutableList<Any>

	fun addPage(vararg text: NmsIChatBaseComponent) =
			pages.addAll(text.map(NmsIChatBaseComponent::nmsChat))

	fun addPage(text: Array<BaseComponent>) = addPage(*text.toIChatBaseList().toTypedArray())

	object Holder : WrapperHolder<BookMeta, BukkitCraftMetaBook>(::BukkitCraftMetaBook)
}
