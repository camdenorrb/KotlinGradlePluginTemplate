package dev.twelveoclock.plugintemplate.modules

import dev.twelveoclock.plugintemplate.TemplatePlugin
import dev.twelveoclock.plugintemplate.commands.MeowCommand
import dev.twelveoclock.plugintemplate.modules.base.PluginModule
import org.bukkit.entity.Cat
import org.bukkit.entity.Firework
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntitySpawnEvent
import org.bukkit.util.Vector

class CatModule(override val plugin: TemplatePlugin) : PluginModule() {

    val meowCommand by lazy {
        MeowCommand(plugin.pluginConfig.catName)
    }


    override fun onEnable() {
        plugin.getCommand("meow")!!.setExecutor(meowCommand)
    }

    override fun onDisable() {
        plugin.getCommand("meow")!!.setExecutor(null)
    }


    @EventHandler
    private fun onSpawn(event: EntitySpawnEvent) {

        val cat = event.entity

        // If isn't the expected cat, return
        if (
            cat !is Cat ||
            cat.customName == null ||
            !cat.customName.equals(plugin.pluginConfig.catName)
        ) {
            return
        }

        cat.launchProjectile(Firework::class.java, Vector(0, 5, 0))
    }



}