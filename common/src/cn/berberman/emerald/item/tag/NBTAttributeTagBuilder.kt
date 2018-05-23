package cn.berberman.emerald.item.tag

import cn.berberman.emerald.abandon.debug
import org.apache.commons.lang.math.RandomUtils
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class NBTAttributeTagBuilder : NBTTagBuilder() {

	interface INBTTagName {

		fun getNBTName(): String
	}


	internal enum class TagName : INBTTagName {
		Name,
		Type,
		Amount,
		Operation,
		UUIDLeast,
		UUIDMost,
		Slot;

		override fun getNBTName() = if (this == Type) "AttributeName" else name
	}


	enum class NBTType(private val nbtName: String) : INBTTagName {

		AttackDamage("attackDamage"),

		AttackSpeed("attackSpeed"),

		MaxHealth("maxHealth"),

		MovementSpeed("movementSpeed"),

		Armor("armor"),

		Luck("luck"),

		Undefined("null");

		override fun getNBTName() = "generic.$nbtName"
	}


	enum class Slot(private val nbtName: String) : INBTTagName {

		MainHand("mainhand"),

		OffHand("offhand"),

		Feet("feet"),

		Legs("legs"),

		Chest("chest"),

		Head("head"),

		Undefined("null");

		override fun getNBTName() = nbtName
	}


	enum class Operation(private val nbtValue: Short) {

		Additive(0),

		Multiplicative(1),

		@Deprecated("magic value", ReplaceWith("Multiplicative"))
		MultipleMultiplicative(2);

		fun getNBTValue() = nbtValue
	}

	private fun setTypeName(type: NBTType) {
		debug("NBT:add Type:${type.getNBTName()}")
		nbtTagCompound.setString("AttributeName", type.getNBTName())
	}

	private fun String.toNBTTagName(transformer: (String) -> String) =
			transformer(this).let {
				object : INBTTagName {
					override fun getNBTName(): String = it
				}
			}


	private fun setString(tagName: INBTTagName, value: String) {
		setString(tagName.getNBTName(), value)
	}

	private fun setInt(tagName: INBTTagName, value: Int) {
		setInt(tagName.getNBTName(), value)
	}

	private fun setDouble(tagName: INBTTagName, value: Double) {
		setDouble(tagName.getNBTName(), value)
	}

	private fun remove(tagName: INBTTagName) {
		remove(tagName.getNBTName())
	}

	companion object {

		val DEFAULT_OPERATION = Operation.Additive

		const val DEFAULT_UUID_LEAST = 10000

		const val DEFAULT_UUID_MOST = 30000
	}


	var type: NBTType by NBTAttributeTagDelegate(NBTType.Undefined, TagName.Type)

	var slot: Slot by NBTAttributeTagDelegate(Slot.Undefined, TagName.Slot)

	var amount: Double by NBTAttributeTagDelegate(.0, TagName.Amount)

	var operation: Operation by NBTAttributeTagDelegate(DEFAULT_OPERATION, TagName.Operation)

	var uuidLeast: Int by NBTAttributeTagDelegate(DEFAULT_UUID_LEAST, TagName.UUIDLeast)

	var uuidMost: Int by NBTAttributeTagDelegate(DEFAULT_UUID_MOST, TagName.UUIDMost)


	var name: String by NBTAttributeTagDelegate("random", TagName.Name)


	private inner class NBTAttributeTagDelegate<T>(initialValue: T, private val tagName: TagName)
		: ReadWriteProperty<Any?, T> {
		internal var field = initialValue

		init {
			//force init :P
			setValue(null, this::field, field)
		}

		override fun getValue(thisRef: Any?, property: KProperty<*>) = field

		override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
			remove(tagName)
			when (value) {
				is String    -> setString(tagName, if (value == "random")
					RandomUtils.nextDouble().toString() else value)
				is Int       -> setInt(tagName, value)
				is Double    -> setDouble(tagName, value)
				is Operation -> setInt(tagName, value.getNBTValue().toInt())
				is NBTType   -> {
					setTypeName(value)

				}
				is Slot      -> setString(tagName, value.getNBTName())
				else         -> throw IllegalStateException("That's impossible.")
			}
			field = value
		}

	}
}
