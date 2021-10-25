package dev.twelveoclock.plugintemplate.config

import com.moandjiezana.toml.Toml
import dev.twelveoclock.plugintemplate.utils.ChatUtils

data class PluginConfig(val catName: String) {

    companion object {

        fun from(toml: Toml): PluginConfig {
            return PluginConfig(ChatUtils.colorize(toml.getString("catName", "&c&lMidnight")))
        }

    }

}