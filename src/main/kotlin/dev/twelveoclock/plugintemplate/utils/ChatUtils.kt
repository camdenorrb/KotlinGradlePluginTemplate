package dev.twelveoclock.plugintemplate.utils

import org.bukkit.ChatColor

/**
 * Utilities to make chat stuff easier
 */
object ChatUtils {

    /**
     * Attempt to convert Minecraft color codes in a string to their UTF representation
     * @param input The text you want to colorize
     * @return The colorized text
     */
    fun colorize(input: String): String {
        return ChatColor.translateAlternateColorCodes('&', input)
    }

}