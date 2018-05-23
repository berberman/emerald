package cn.berberman.emerald.item.tag

import cn.berberman.emerald.abandon.debug
import cn.berberman.emerald.reflection.wrapper.nbt.NmsNBTTagCompound

open class NBTTagBuilder {

	internal val nbtTagCompound = NmsNBTTagCompound()


	protected fun setString(tagName: String, value: String) {
		debug("NBT:add $tagName:$value")
		nbtTagCompound.setString(tagName, value)
	}

	protected fun setInt(tagName: String, value: Int) {
		debug("NBT:add $tagName:$value")
		nbtTagCompound.setInt(tagName, value)
	}

	protected fun setDouble(tagName: String, value: Double) {
		debug("NBT:add $tagName:$value")
		nbtTagCompound.setDouble(tagName, value)
	}

	protected fun remove(tagName: String) {
		debug("NBT:remove $tagName")
		nbtTagCompound.remove(tagName)
	}
}
