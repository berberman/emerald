package cn.berberman.emerald.reflection.wrapper.chat

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.wrapper.chat.interfaces.NmsIChatBaseComponent

class NmsIChatBaseComponentWrapper(nmsMsg: Any) : NmsIChatBaseComponent() {

	override val nmsChat: Any = nmsMsg

	override val clazz: Class<*> = ReflectionClasses.Nms.IChatBaseComponent()
}
