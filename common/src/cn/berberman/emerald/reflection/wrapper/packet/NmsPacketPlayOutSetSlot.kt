package cn.berberman.emerald.reflection.wrapper.packet

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.wrapper.item.NmsItemStack

class NmsPacketPlayOutSetSlot(var1: Int, var2: Int, itemStack: NmsItemStack) : NmsPacket() {

	override val clazz: Class<*> = ReflectionClasses.Nms.PacketPlayOutSetSlot()

	override val nmsPacket: Any =
			clazz.getConstructor(Int::class.java, Int::class.java,
					ReflectionClasses.Nms.ItemStack())
					.newInstance(var1, var2, itemStack.handle)

}
