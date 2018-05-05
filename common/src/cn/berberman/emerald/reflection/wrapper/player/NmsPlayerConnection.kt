package cn.berberman.emerald.reflection.wrapper.player

import cn.berberman.emerald.reflection.NmsUtil
import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.getField
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper
import cn.berberman.emerald.reflection.wrapper.WrapperHolder
import cn.berberman.emerald.reflection.wrapper.packet.NmsPacket
import cn.berberman.emerald.util.unsafeCast
import io.netty.channel.Channel


class NmsPlayerConnection(nmsPlayerConnection: Any) : ReflectionWrapper() {
	override val clazz: Class<*> = ReflectionClasses.Nms.PlayerConnection()

	override val handle: Any = nmsPlayerConnection

	val channel: Channel = fields("networkManager").let {
		NmsUtil.getNMSClass("NetworkManager").getField(it!!, "channel")!!.unsafeCast()
	}


	fun sendPacket(packet: NmsPacket) {
		methods("sendPacket", packet.nmsPacket)
	}

	object Holder : WrapperHolder<Any, NmsPlayerConnection>(::NmsPlayerConnection)
}
