package cn.berberman.emerald.abandon

//TODO emmmmmm....

fun debug(msg: Any) = Unit

inline fun debug(msg: () -> Any) = debug(msg())