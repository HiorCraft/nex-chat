package de.hiorcraft.nex.nexchat.listener

import dev.slne.surf.surfapi.bukkit.api.extensions.server
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class PlayerDeath : Listener {

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val player = event.entity
        event.deathMessage(null)

        val msg = Component.text("[", NamedTextColor.GRAY)
            .append(Component.text("☠", NamedTextColor.DARK_RED))
            .append(Component.text("]", NamedTextColor.GRAY))
            .append(Component.text(" ${player.name} ", NamedTextColor.DARK_GRAY))
            .append(Component.text("ist gestorben.", NamedTextColor.DARK_GRAY))

        server.sendMessage(msg)
    }
}