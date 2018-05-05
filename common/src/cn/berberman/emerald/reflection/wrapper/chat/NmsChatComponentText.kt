package cn.berberman.emerald.reflection.wrapper.chat

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.wrapper.chat.interfaces.NmsIChatBaseComponent


class NmsChatComponentText(val text: String) : NmsIChatBaseComponent() {


	override val clazz: Class<*> = ReflectionClasses.Nms.ChatComponentText()

	override val nmsChat: Any = clazz.getConstructor(String::class.java).newInstance(text)

}
