package dev.twelveoclock.plugintemplate.modules.base

import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

abstract class PluginModule : Module, Listener {

    protected abstract val plugin: JavaPlugin

    final override var isEnabled = false
        private set


    protected open fun onEnable() {}

    protected open fun onDisable() {}


    final override fun enable() {
        if (!isEnabled) {
            onEnable()
            plugin.server.pluginManager.registerEvents(this, plugin)
            isEnabled = true
        }
    }

    final override fun disable() {
        if (isEnabled) {
            onDisable()
            HandlerList.unregisterAll(this)
            isEnabled = false
        }
    }

}
