package cn.berberman.emerald.reflection.wrapper.packet

import cn.berberman.emerald.reflection.NmsUtil
import cn.berberman.emerald.reflection.ReflectionClasses.Nms.*
import cn.berberman.emerald.reflection.wrapper.chat.NmsChatMessageType
import cn.berberman.emerald.reflection.wrapper.chat.interfaces.NmsIChatBaseComponent


class NmsPacketPlayOutChat : NmsPacket {
	override val nmsPacket: Any

	override val clazz: Class<*> = PacketPlayOutChat()

	constructor(chatBaseComponent: NmsIChatBaseComponent) {
		nmsPacket = clazz.getConstructor(IChatBaseComponent()).newInstance(chatBaseComponent.nmsChat)
	}


	constructor(chatBaseComponent: NmsIChatBaseComponent, chatMessageType: NmsChatMessageType) {
		nmsPacket = IChatBaseComponent().let {
			if (shouldUseNewFormat())
				clazz.getConstructor(it,
						ChatMessageType()).newInstance(chatBaseComponent.nmsChat,
						chatMessageType.handle)
			else clazz.getConstructor(it, Byte::class.java)
					.newInstance(chatBaseComponent, chatMessageType.type)
		}


	}

	private fun shouldUseNewFormat() = NmsUtil.version.split("_")[1] >= "12"

}
