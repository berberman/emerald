package cn.berberman.emerald.reflection.wrapper.packet

import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper


abstract class NmsPacket : ReflectionWrapper() {

	abstract val nmsPacket: Any

	final override val handle: Any
		get() = nmsPacket
}
