package de.hiorcraft.nex.nexchat.command

import de.hiorcraft.nex.nexchat.util.PermissionRegistry
import de.hiorcraft.nex.nexchat.util.PlayerDeathConfig
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.literalArgument
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText

fun playerDeathCommand() = commandTree("PlayerDeath") {
    withPermission(PermissionRegistry.COMMAND_PLAYERDEATH)

    literalArgument("off")
    withPermission(PermissionRegistry.COMMAND_PLAYERDEATH_OFF)
    playerExecutor { player, args ->
        PlayerDeathConfig.isOn = true
        player.sendText {
            appendPrefix()
            info("Die Spieler Todes Nachricht is jetzt aus")
        }
    }

    literalArgument("vanilla")
    withPermission(PermissionRegistry.COMMAND_PLAYERDEATH_VANILLA)
    playerExecutor { player, args ->
        PlayerDeathConfig.isOn = false
        PlayerDeathConfig.isNex = false
        player.sendText {
            appendPrefix()
            info("Die Spieler Todes Nachricht ist jetzt Vanilla ")
        }
    }

    literalArgument("Nex")
    withPermission(PermissionRegistry.COMMAND_PLAYERDEATH_NEX)
    playerExecutor { player, args ->
        PlayerDeathConfig.isOn = false
        PlayerDeathConfig.isNex = true
        player.sendText {
            appendPrefix()
            info("Die SPieler Todes Nachricht ist jetzt Nex-Chat")
        }
    }
}
