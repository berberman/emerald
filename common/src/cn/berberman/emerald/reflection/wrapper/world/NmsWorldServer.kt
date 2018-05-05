package cn.berberman.emerald.reflection.wrapper.world

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper
import cn.berberman.emerald.reflection.wrapper.WrapperHolder

class NmsWorldServer(worldServer: Any) : ReflectionWrapper() {
	override val clazz: Class<*> = ReflectionClasses.Nms.WorldServer()

	override val handle: Any = worldServer

	object Holder : WrapperHolder<Any, NmsWorldServer>(::NmsWorldServer)
}
