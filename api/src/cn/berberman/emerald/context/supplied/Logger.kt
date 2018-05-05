package cn.berberman.emerald.context.supplied

import cn.berberman.emerald.util.ContextUtil


fun info(msg: Any) = ContextUtil.getPluginInstance().logger.info(msg.toString())


inline fun info(supplier: () -> Any) = info(supplier())


fun warning(msg: Any) = ContextUtil.getPluginInstance().logger.warning(msg.toString())


inline fun warning(supplier: () -> Any) = warning(supplier())
