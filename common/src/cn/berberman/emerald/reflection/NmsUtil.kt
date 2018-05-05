package cn.berberman.emerald.reflection

import cn.berberman.emerald.reflection.wrapper.item.NmsItemStack
import cn.berberman.emerald.util.safeCast
import cn.berberman.emerald.util.unsafeCast
import org.bukkit.Bukkit
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.IllegalPluginAccessException


object NmsUtil {
	val version = Bukkit.getServer()::class.java.`package`.name.split(".")[3]
	private val nmsPackageName = "net.minecraft.server.$version"
	private val craftBukkitPackageName = "org.bukkit.craftbukkit.$version"


	fun getNMSClass(name: String): Class<*> = Class.forName("$nmsPackageName.$name")
			?: throw IllegalPluginAccessException("Can't find this class: $name")


	fun getCraftBukkitClass(nameWithPackage: String): Class<*> = Class.forName("$craftBukkitPackageName.$nameWithPackage")
			?: throw IllegalPluginAccessException("Can't find this class: $nameWithPackage")


	fun asNMSCopy(original: ItemStack): Any = ReflectionClasses.CraftBukkit.CraftItemStack()
			.invokeMethodSpecificTypes(null, "asNMSCopy", arrayOf(ItemStack::class.java.unsafeCast()), original)
			?: throw IllegalPluginAccessException("Convert $original error.")


	fun asBukkitCopy(original: NmsItemStack): ItemStack = ReflectionClasses.CraftBukkit.CraftItemStack()
			.invokeMethodSpecificTypes(null, "asBukkitCopy", arrayOf(ReflectionClasses.Nms.ItemStack()), original.handle)
			.safeCast() ?: throw IllegalPluginAccessException("Convert $original error.")
}
