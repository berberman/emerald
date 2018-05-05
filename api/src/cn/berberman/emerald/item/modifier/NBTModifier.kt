package cn.berberman.emerald.item.modifier

import cn.berberman.emerald.reflection.wrapper.item.NmsItemStack
import cn.berberman.emerald.reflection.wrapper.nbt.NmsNBTTagCompound
import org.bukkit.inventory.ItemStack


abstract class NBTModifier(itemStack: ItemStack) {
	protected val nms = NmsItemStack(itemStack)

	protected val tag: NmsNBTTagCompound

	init {
		tag = if (nms.hasTag()) nms.getTag() else NmsNBTTagCompound()
	}

	internal abstract fun getResult(): ItemStack
}
