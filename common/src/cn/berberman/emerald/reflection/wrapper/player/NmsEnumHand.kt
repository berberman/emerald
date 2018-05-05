package cn.berberman.emerald.reflection.wrapper.player

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.invokeMethod
import cn.berberman.emerald.reflection.wrapper.IWrapper

enum class NmsEnumHand : IWrapper {
	MAIN_HAND,
	OFF_HAND;

	override val handle: Any =
			ReflectionClasses.Nms.EnumHand()
					.invokeMethod(null, "valueOf", name)!!
}
