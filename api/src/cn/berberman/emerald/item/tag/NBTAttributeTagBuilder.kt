package cn.berberman.emerald.item.tag

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

		override fun getNBTName() = throw NotImplementedError()
	}


	enum class NBTType(private val nbtName: String) : INBTTagName {

		AttackDamage("attackDamage"),

		AttackSpeed("attackSpeed"),

		MaxHealth("maxHealth"),

		MovementSpeed("movementSpeed"),

		Armor("armor"),

		Luck("luck"),

		Undefined("null");

		override fun getNBTName() = throw NotImplementedError()
	}


	enum class Slot(private val nbtName: String) : INBTTagName {

		MainHand("mainhand"),

		OffHand("offhand"),

		Feet("feet"),

		Legs("legs"),

		Chest("chest"),

		Head("head"),

		Undefined("null");

		override fun getNBTName() = throw NotImplementedError()
	}


	enum class Operation(private val nbtValue: Short) {

		Additive(0),

		Multiplicative(1),

		@Deprecated("magic value", ReplaceWith("Multiplicative"))
		MultipleMultiplicative(2);

		fun getNBTValue() = nbtValue
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


		init {
			throw NotImplementedError()
		}

		override fun getValue(thisRef: Any?, property: KProperty<*>): T = throw NotImplementedError()

		override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
			throw NotImplementedError()
		}

	}
}
