package cn.berberman.emerald.item.modifier

import cn.berberman.emerald.item.tag.NBTAttributeTagBuilder
import cn.berberman.emerald.reflection.NmsUtil
import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.ReflectionUtil
import cn.berberman.emerald.reflection.wrapper.nbt.NmsNBTTagCompound
import cn.berberman.emerald.reflection.wrapper.nbt.NmsNBTTagList
import org.bukkit.inventory.ItemStack


class NBTAttributeModifier(itemStack: ItemStack) : NBTModifier(itemStack) {


	fun addAttributeTag(block: NBTAttributeTagBuilder.() -> Unit) = operateList {
		add(NBTAttributeTagBuilder().apply(block).nbtTagCompound.handle)
	}

	fun removeAttributeTagByIndex(index: Int) = operateList {
		remove(index)
	}

	private fun removeAttributeByString(key: String) = operateList {
		getInternal().map(::NmsNBTTagCompound).filter {
			val value = it.get(key) ?: return@filter false
			ReflectionUtil.getField<String>(ReflectionClasses.Nms.NBTTagString(),
					"data", value) == key
		}.let {
			getInternal().removeAll(it.map(NmsNBTTagCompound::handle))
		}
	}

	fun removeAttributeTagByType(type: NBTAttributeTagBuilder.NBTType) =
			removeAttributeByString(type.getNBTName())

	fun removeAttributeTagByName(name: String) =
			removeAttributeByString(name)

	fun clearAllAttributeTags() = operateList { internalClear() }


	private fun operateList(block: NmsNBTTagList.() -> Unit) =
			tag.set("AttributeModifiers", getOrNewList().apply(block).handle)

	private fun getOrNewList() = tag.get("AttributeModifiers")?.let { NmsNBTTagList(it) }
			?: NmsNBTTagList()

	override fun getResult() = NmsUtil.asBukkitCopy(nms.apply { setTag(this@NBTAttributeModifier.tag) })


}

