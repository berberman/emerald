package cn.berberman.emerald.permission

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault


class PermissionBuilderDsl internal constructor(private val name: String) {


    var description: String = ""


    var defaultValue = PermissionDefault.OP


    fun childPermission(name: String, block: PermissionBuilderDsl.() -> Unit = {}) {
        throw NotImplementedError()
    }


    internal fun build(): Permission = throw NotImplementedError()
}


class PermissionSetBuilderDsl internal constructor() {

    fun permission(name: String, block: PermissionBuilderDsl.() -> Unit = {}) {
        throw NotImplementedError()
    }
}


fun registerPermissions(block: PermissionSetBuilderDsl.() -> Unit) {
    throw NotImplementedError()
}
