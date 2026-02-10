package de.hiorcraft.nex.nexchat.command

import de.hiorcraft.nex.nexchat.util.PermissionRegistry
import de.hiorcraft.nex.nexchat.util.PlayerDeathConfig
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText


fun playerDeathCommand() = commandTree("PlayerDeath") {
    withPermission(PermissionRegistry.COMMAND_PLAYERDEATH)
    playerExecutor { player, args ->
        PlayerDeathConfig.isOn = !PlayerDeathConfig.isOn
        val status = if (PlayerDeathConfig.isOn) "aktiviert" else "deaktiviert"
        player.sendText {
            appendPrefix()
            info("Der PlayerDeath-Broadcast wurde $status.")
        }


    }
}


