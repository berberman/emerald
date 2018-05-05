package cn.berberman.emerald.permission

import cn.berberman.emerald.command.annotation.CommonBuilderMarker
import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault


@PermissionBuilder
class PermissionBuilderDsl internal constructor(private val name: String) {


	var description: String = ""


	var defaultValue = PermissionDefault.OP


	fun childPermission(name: String, block: PermissionBuilderDsl.() -> Unit = {}) {
		throw NotImplementedError()
	}


	internal fun build(): Permission = throw NotImplementedError()
}


@CommonBuilderMarker
class PermissionsBuilderDsl internal constructor() {

	fun permission(name: String, block: PermissionBuilderDsl.() -> Unit = {}) {
		throw NotImplementedError()
	}
}

@DslMarker
internal annotation class PermissionBuilder


fun registerPermissions(block: PermissionsBuilderDsl.() -> Unit) {
	throw NotImplementedError()
}
