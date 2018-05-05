package cn.berberman.emerald.chat.tallraw

import com.google.gson.JsonElement
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class TellrawMessageSerializer : JsonSerializer<TellrawMessage> {

	override fun serialize(tellraw: TellrawMessage, type: Type, context: JsonSerializationContext): JsonElement =
			throw NotImplementedError()

}
