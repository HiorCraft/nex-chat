package de.hiorcraft.nex.nexchat.command

import com.sun.tools.javac.tree.TreeInfo.args
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.arguments.GreedyStringArgument
import dev.jorel.commandapi.arguments.StringArgument
import dev.jorel.commandapi.executors.PlayerCommandExecutor
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class ModChat(private val plugin: JavaPlugin) {

    fun register() {
        CommandAPICommand("teamchat")
            .withPermission("teamchat.use")
            .withArguments(GreedyStringArgument("message"))
            .executesPlayer(PlayerCommandExecutor { player, args ->
                val player = player as Player
                val message = args[0] as String

                // Nachricht an alle Mods senden
                plugin.server.onlinePlayers
                    .filter { it.hasPermission("teamchat.use") }
                    .forEach { mod ->
                        mod.sendMessage(
                            Component.text("(TEAM) ${player.name}: $message", NamedTextColor.GRAY)
                            )
                    }
            })
            .register()
    }
}