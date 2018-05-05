package cn.berberman.emerald.reflection.wrapper.nbt

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.ReflectionUtil
import cn.berberman.emerald.reflection.getConstructorAccess
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper


class NmsNBTTagList : ReflectionWrapper {

	override val clazz: Class<*> = ReflectionClasses.Nms.NBTTagList()


	constructor() {
		handle = clazz.getConstructorAccess().newInstance()
		internalList = ReflectionUtil.getField(clazz, "list", handle)
	}


	constructor(original: Any) {
		handle = original
		internalList = ReflectionUtil.getField(clazz, "list", handle)
	}

	override val handle: Any

	private val internalList: ArrayList<*>


	fun remove(index: Int) {
		methods("remove", index)
	}


	fun add(any: Any) {
		methods("add", any)
	}

	fun get(index: Int) = methods("get", index)


	internal fun getInternal() = internalList

	fun internalClear() = internalList.clear()

	fun internalSize() = internalList.size

}
