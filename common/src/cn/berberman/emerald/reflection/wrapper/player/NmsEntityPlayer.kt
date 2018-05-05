package cn.berberman.emerald.reflection.wrapper.player

import cn.berberman.emerald.reflection.ReflectionClasses.Nms.*
import cn.berberman.emerald.reflection.getFieldAccess
import cn.berberman.emerald.reflection.invokeMethod
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper
import cn.berberman.emerald.reflection.wrapper.WrapperHolder
import cn.berberman.emerald.reflection.wrapper.item.NmsItemStack
import org.bukkit.Material
import org.bukkit.inventory.ItemStack


class NmsEntityPlayer(nmsEntityPlayer: Any) : ReflectionWrapper() {
	override val clazz: Class<*> = EntityPlayer()

	override val handle: Any = nmsEntityPlayer

	val playerConnection = NmsPlayerConnection.Holder[clazz.getFieldAccess()[nmsEntityPlayer, "playerConnection"]]

	private val nmsBook by lazy { NmsItemStack(ItemStack(Material.WRITTEN_BOOK)) }

	fun openBook(enumHand: NmsEnumHand) {
		clazz.invokeMethod(handle, "a", arrayOf(ItemStack(),
				EnumHand()), nmsBook.handle, enumHand.handle)
	}

	fun broadcastCarriedItem() {
		methods("broadcastCarriedItem")
	}

	companion object {


	}

	object Holder : WrapperHolder<Any, NmsEntityPlayer>(::NmsEntityPlayer)
}
