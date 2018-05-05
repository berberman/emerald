package cn.berberman.emerald.item.modifier

import cn.berberman.emerald.item.tag.NBTAttributeTagBuilder
import org.bukkit.inventory.ItemStack


class NBTAttributeModifier(itemStack: ItemStack) : NBTModifier(itemStack) {


	fun addAttributeTag(block: NBTAttributeTagBuilder.() -> Unit): Unit = throw NotImplementedError()

	private fun removeAttributeByString(key: String): Unit = throw NotImplementedError()

	fun removeAttributeTagByType(type: NBTAttributeTagBuilder.NBTType): Unit =
			removeAttributeByString(type.getNBTName())

	fun removeAttributeTagByName(name: String): Unit =
			throw NotImplementedError()

	fun clearAllAttributeTags(): Unit = throw NotImplementedError()


	override fun getResult(): ItemStack = throw NotImplementedError()


}

