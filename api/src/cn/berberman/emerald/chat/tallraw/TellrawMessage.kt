package cn.berberman.emerald.chat.tallraw

import com.google.gson.annotations.JsonAdapter


@JsonAdapter(TellrawMessageSerializer::class)
class TellrawMessage(val text: String) {
	var color: TellrawChatColor = throw NotImplementedError()

	var bold: Boolean = false

	var italic: Boolean = false

	var underlined: Boolean = false

	var strikethrough: Boolean = false

	var obfuscated: Boolean = false

	var insertion: String = ""

	internal var clickEvent: TellrawClickEvent? = null

	internal var hoverEvent: TellrawHoverEvent? = null

	fun onHover(block: TellrawHoverEvent.() -> Unit) {
		throw NotImplementedError()
	}

	fun onClick(block: TellrawClickEvent.() -> Unit) {
		throw NotImplementedError()
	}

	fun toJsonString(): String = throw NotImplementedError()
}
