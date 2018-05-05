package cn.berberman.emerald.reflection.wrapper.item

import cn.berberman.emerald.reflection.NmsUtil
import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper
import cn.berberman.emerald.reflection.wrapper.nbt.NmsNBTTagCompound
import org.bukkit.inventory.ItemStack


class NmsItemStack(itemStack: ItemStack) : ReflectionWrapper() {

	override val clazz: Class<*> = ReflectionClasses.Nms.ItemStack()

	override val handle: Any = NmsUtil.asNMSCopy(itemStack)


	fun hasTag() = methods("hasTag") as Boolean


	fun getTag() = NmsNBTTagCompound(methods("getTag")!!)


	fun setTag(nmsNBTTagCompound: NmsNBTTagCompound) {
		methods("setTag", nmsNBTTagCompound.handle)
	}
}
