package de.hiorcraft.nex.nexchat.command

import de.hiorcraft.nex.nexchat.permissions.PermissionRegistry
import de.hiorcraft.nex.nexchat.plugin
import dev.jorel.commandapi.arguments.GreedyStringArgument
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.playerExecutor
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.entity.Player

 fun teamchatCommand() = commandAPICommand("teamchat") {
    withPermission(PermissionRegistry.COMMAND_TEAMCHAT)
    withArguments(GreedyStringArgument("message"))

        playerExecutor { player, args ->
            val player = player as Player
            val message = args[0] as String


            plugin.server.onlinePlayers
                    .filter { it.hasPermission("teamchat.use") }
                    .forEach { mod ->
                        mod.sendMessage(
                            Component.text("(TEAM) ${player.name}: $message", NamedTextColor.DARK_AQUA)
                            )
                    }
            }
            register()

    }

