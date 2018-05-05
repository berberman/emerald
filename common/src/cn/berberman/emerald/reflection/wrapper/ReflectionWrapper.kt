package cn.berberman.emerald.reflection.wrapper

import cn.berberman.emerald.reflection.getFieldAccess
import cn.berberman.emerald.reflection.invokeMethod


abstract class ReflectionWrapper : IWrapper {

	protected abstract val clazz: Class<*>


	fun methods(name: String, vararg parameter: Any?): Any? =
			clazz.invokeMethod(handle, name, *parameter)

	fun fields(name: String): Any? = clazz.getFieldAccess()[handle, name]

}
