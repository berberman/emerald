package cn.berberman.emerald.reflection.wrapper.chat.interfaces

import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper


abstract class NmsIChatBaseComponent protected constructor() : ReflectionWrapper() {

	abstract val nmsChat: Any

	final override val handle: Any
		get() = nmsChat
}
