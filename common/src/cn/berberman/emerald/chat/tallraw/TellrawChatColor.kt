package cn.berberman.emerald.chat.tallraw

import org.bukkit.ChatColor

enum class TellrawChatColor(val code: Char, val jsonName: String) {
	BLACK('0', "black"),
	DARK_BLUE('1', "dark_blue"),
	DARK_GREEN('2', "dark_green"),
	DARK_AQUA('3', "dark_aqua"),
	DARK_RED('4', "dark_red"),
	DARK_PURPLE('5', "dark_purple"),
	GOLD('6', "gold"),
	GRAY('7', "gray"),
	DARK_GRAY('8', "dark_gray"),
	BLUE('9', "blue"),
	GREEN('a', "green"),
	AQUA('b', "aqua"),
	RED('c', "red"),
	LIGHT_PURPLE('d', "light_purple"),
	YELLOW('e', "yellow"),
	WHITE('f', "white"),
	MAGIC('k', "obfuscated"),
	BOLD('l', "bold"),
	STRIKETHROUGH('m', "strikethrough"),
	UNDERLINE('n', "underline"),
	ITALIC('o', "italic"),
	RESET('r', "reset");

	fun toBukkit() = ChatColor.valueOf(name)

	companion object {
		const val COLOR_CHAR = '\u00A7'
		const val ALL_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRr"

		fun translateAlternateColorCodes(altColorChar: Char, textToTranslate: String): String {
			val b = textToTranslate.toCharArray()
			for (i in 0 until b.size - 1) {
				if (b[i] == altColorChar && ALL_CODES.indexOf(b[i + 1]) > -1) {
					b[i] = COLOR_CHAR
					b[i + 1] = Character.toLowerCase(b[i + 1])
				}
			}
			return String(b)
		}
	}
}
