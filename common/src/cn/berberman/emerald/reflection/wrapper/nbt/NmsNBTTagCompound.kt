package cn.berberman.emerald.reflection.wrapper.nbt

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.ReflectionUtil
import cn.berberman.emerald.reflection.getConstructorAccess
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper


class NmsNBTTagCompound : ReflectionWrapper {

	override val clazz: Class<*> = ReflectionClasses.Nms.NBTTagCompound()


	constructor() {
		handle = clazz.getConstructorAccess().newInstance()
		internalMap = ReflectionUtil.getField(clazz, "map", handle)
	}


	constructor(original: Any) {
		handle = original
		internalMap = ReflectionUtil.getField(clazz, "map", handle)
	}

	override val handle: Any

	private val internalMap: HashMap<*, *>

	fun setInt(name: String, value: Int) {
		methods("setInt", name, value)
	}


	fun setString(name: String, value: String) {
		methods("setString", name, value)
	}

	fun setDouble(name: String, value: Double) {
		methods("setDouble", name, value)
	}


	fun remove(name: String) {
		methods("remove", name)
	}


	fun set(name: String, any: Any) {
		methods("set", name, any)
	}

	fun get(name: String): Any? = methods("get", name)


	internal fun getInternal() = internalMap

	fun internalClear() = internalMap.clear()
}
