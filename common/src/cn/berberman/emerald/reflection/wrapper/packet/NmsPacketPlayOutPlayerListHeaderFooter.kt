package cn.berberman.emerald.reflection.wrapper.packet

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.getConstructorAccess
import cn.berberman.emerald.reflection.wrapper.chat.interfaces.NmsIChatBaseComponent

class NmsPacketPlayOutPlayerListHeaderFooter(header: NmsIChatBaseComponent,
                                             footer: NmsIChatBaseComponent) : NmsPacket() {
	override val clazz: Class<*> = ReflectionClasses.Nms.PacketPlayOutPlayerListHeaderFooter()

	override val nmsPacket: Any = clazz.getConstructorAccess().newInstance()

	init {
		clazz.getDeclaredField("a").also { it.isAccessible = true }[handle] = header.nmsChat

		clazz.getDeclaredField("b").also { it.isAccessible = true }[handle] = footer.nmsChat
	}

}
