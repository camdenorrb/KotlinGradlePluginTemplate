package dev.twelveoclock.plugintemplate.modules

import dev.twelveoclock.plugintemplate.modules.base.PluginModule
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class PlayerModule(override val plugin: JavaPlugin) : PluginModule() {

    @EventHandler
    private fun onJoin(event: PlayerJoinEvent) {
        val player = event.player
        player.playSound(player.location, Sound.ENTITY_CAT_PURR, 1.0F, 1.0F)
    }

}