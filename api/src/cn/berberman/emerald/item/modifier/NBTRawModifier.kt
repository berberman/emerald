package cn.berberman.emerald.item.modifier

import cn.berberman.emerald.reflection.wrapper.nbt.NmsNBTTagCompound
import org.bukkit.inventory.ItemStack

class NBTRawModifier(itemStack: ItemStack) : NBTModifier(itemStack) {


	fun addRawTag(name: String, block: NmsNBTTagCompound.() -> Unit) {
		throw NotImplementedError()
	}

	fun getRawTagOrNull(name: String): NmsNBTTagCompound? = throw NotImplementedError()

	fun removeRawTag(name: String): Unit = throw NotImplementedError()


	override fun getResult(): ItemStack = throw NotImplementedError()
}
