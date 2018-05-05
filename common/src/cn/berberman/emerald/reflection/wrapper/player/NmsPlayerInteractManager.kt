package cn.berberman.emerald.reflection.wrapper.player

import cn.berberman.emerald.reflection.ReflectionClasses
import cn.berberman.emerald.reflection.wrapper.ReflectionWrapper
import cn.berberman.emerald.reflection.wrapper.world.NmsWorldServer

class NmsPlayerInteractManager(worldServer: NmsWorldServer) : ReflectionWrapper() {

	override val clazz: Class<*> = ReflectionClasses.Nms.PlayerInteractManager()

	override val handle: Any = clazz.constructors[0].newInstance(worldServer.handle)

}
