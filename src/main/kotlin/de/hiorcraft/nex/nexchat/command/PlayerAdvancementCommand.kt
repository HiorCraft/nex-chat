package de.hiorcraft.nex.nexchat.command

import de.hiorcraft.nex.nexchat.util.PermissionRegistry
import de.hiorcraft.nex.nexchat.util.PlayerAdvancementConfig
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText


fun playerAdvancementCommand() = commandTree("PlayerAdvancement") {
    withPermission(PermissionRegistry.COMMAND_PLAYERADVANCEMENT)
    playerExecutor { player, args ->
        PlayerAdvancementConfig.isOn = !PlayerAdvancementConfig.isOn
        val status = if (PlayerAdvancementConfig.isOn) "aktiviert" else "deaktiviert"
        player.sendText {
            appendPrefix()
            info("Der PlayerAdvancement-Broadcast wurde $status.")
        }
    }
}