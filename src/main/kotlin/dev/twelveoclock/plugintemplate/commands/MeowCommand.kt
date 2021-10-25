package dev.twelveoclock.plugintemplate.commands

import org.bukkit.ChatColor
import org.bukkit.DyeColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Cat
import org.bukkit.entity.Player

class MeowCommand(val catName: String) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) {
            sender.sendMessage("This command can only be ran as a Player")
            return true
        }

        val location = sender.location

        location.world?.spawn(location, Cat::class.java) { cat ->
            cat.isInvulnerable = true
            cat.catType = Cat.Type.BLACK
            cat.collarColor = DyeColor.RED
            cat.customName = catName
            cat.isCustomNameVisible = true
        }

        sender.sendMessage("${ChatColor.GREEN}${ChatColor.BOLD}Meow!")

        return true
    }
}