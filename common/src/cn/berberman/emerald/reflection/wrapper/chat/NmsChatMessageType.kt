package cn.berberman.emerald.reflection.wrapper.chat

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.invokeMethodSpecificTypes
import cn.berberman.emerald.reflection.wrapper.IWrapper


enum class NmsChatMessageType(val type: Byte) : IWrapper {

	CHAT(0),

	SYSTEM(1),

	GAME_INFO(2);


	override val handle: Any =
			ReflectionClasses.Nms.ChatMessageType()
					.invokeMethodSpecificTypes(null, "a",
							arrayOf(Byte::class.java as Class<*>), type)!!
}
