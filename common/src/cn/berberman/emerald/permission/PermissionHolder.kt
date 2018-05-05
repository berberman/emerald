package cn.berberman.emerald.permission

import cn.berberman.emerald.context.supplied.debug
import cn.berberman.emerald.util.EmeraldUtil.pluginManager


internal object PermissionHolder {
	private val permissionList = mutableListOf<PermissionBuilderDsl>()


	internal fun addPermission(permissionBuilderDsl: PermissionBuilderDsl) = permissionList.add(permissionBuilderDsl)


	internal fun register() {
		permissionList.flatMap { it.getChildPermissionInstances() }.forEach(pluginManager::addPermission)
		permissionList.flatMap { it.getChildPermissionInstances() }.forEach {
			debug("registerPlugin child permission: ${it.name}")
		}
		permissionList.forEach { it.build().let(pluginManager::addPermission) }
		permissionList.forEach {
			it.build().let {
				debug("registerPlugin permission: ${it.name}")
			}
		}
	}
}
