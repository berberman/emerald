package cn.berberman.emerald.permission

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault


class PermissionBuilderDsl internal constructor(private val name: String) {

    var description: String = ""


    var defaultValue = PermissionDefault.OP

    private val childPermissionNames = mutableListOf<String>()
    private val childPermission = mutableListOf<Permission>()

    fun childPermission(name: String, block: PermissionBuilderDsl.() -> Unit = {}) {
        var resolveName = name
        if (!resolveName.startsWith(this.name.removeSuffix("*")))
            resolveName = this.name.removeSuffix("*") + name
        childPermissionNames.add(resolveName)
        childPermission.add(PermissionBuilderDsl(resolveName).apply(block).build())
    }


    internal fun getChildPermissionInstances() = childPermission

    internal fun build(): Permission {
        val desc = description.takeIf { it.isNotBlank() }
        val map = mutableMapOf<String, Boolean>()
        childPermissionNames.takeIf { it.isNotEmpty() }?.forEach {
            map[it] = true
        }
        return Permission(name, desc, defaultValue, map)
    }
}


class PermissionSetBuilderDsl internal constructor() {

    fun permission(name: String, block: PermissionBuilderDsl.() -> Unit = {}) {
        PermissionBuilderDsl(name).apply(block).let(PermissionHolder::addPermission)
    }
}

fun registerPermissions(block: PermissionSetBuilderDsl.() -> Unit) {
    PermissionSetBuilderDsl().block()
    PermissionHolder.register()
}
