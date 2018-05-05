package cn.berberman.emerald.reflection.wrapper

import java.util.*

open class WrapperHolder<E, T : ReflectionWrapper>(private val constructor: (E) -> T) {
	private val wrappers = WeakHashMap<E, T>()

	open operator fun get(instance: E) = wrappers[instance] ?: constructor(instance).also {
		wrappers[instance] = it
	}
}
