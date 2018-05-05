@file:JvmName("ReflectionAsmUtil")


package cn.berberman.emerald.reflection

import com.esotericsoftware.reflectasm.ConstructorAccess
import com.esotericsoftware.reflectasm.FieldAccess
import com.esotericsoftware.reflectasm.MethodAccess


fun <T : Any> Class<T>.getMethodAccess(): MethodAccess = MethodAccess.get(this)


fun <T : Any> Class<T>.getFieldAccess(): FieldAccess = FieldAccess.get(this)


fun <T : Any> Class<T>.getConstructorAccess(): ConstructorAccess<T> = ConstructorAccess.get(this)


fun <T : Any> Class<T>.invokeMethod(instance: Any?, name: String, vararg parameters: Any?): Any? =
		getMethodAccess()(instance, name, *parameters)


fun <T : Any> Class<T>.getField(instance: Any?, name: String): Any? = getFieldAccess()[instance, name]

fun <T : Any> Class<T>.invokeMethodSpecificTypes(instance: Any?, name: String, parameterTypes: Array<Class<*>>, vararg parameters: Any?): Any? =
		getMethodAccess().let {
			it(instance, it.getIndex(name, *parameterTypes), *parameters)
		}
