package cn.berberman.emerald.context.supplied

import cn.berberman.emerald.util.ContextUtil


fun info(msg: Any):Unit= throw NotImplementedError()


inline fun info(supplier: () -> Any):Unit = throw NotImplementedError()


fun warning(msg: Any):Unit = throw NotImplementedError()


inline fun warning(supplier: () -> Any):Unit = throw NotImplementedError()
