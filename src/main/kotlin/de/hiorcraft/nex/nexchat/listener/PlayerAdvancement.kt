package de.hiorcraft.nex.nexchat.listener

import dev.slne.surf.surfapi.bukkit.api.extensions.server
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerAdvancementDoneEvent

class PlayerAdvancement : Listener {

    @EventHandler
    fun onPlayerAdvancement(event: PlayerAdvancementDoneEvent) {
        val player = event.player

        event.advancement.display?.let {
            val title = it.title()

            val msg = Component.text("[", NamedTextColor.GRAY)
                .append(Component.text("✓", NamedTextColor.GREEN))
                .append(Component.text("]", NamedTextColor.GRAY))
                .append(Component.text(" ${player.name} ", NamedTextColor.GRAY))
                .append(Component.text("hat den Fortschritt ", NamedTextColor.GRAY))
                .append(title.color(NamedTextColor.GOLD))
                .append(Component.text(" geschaft.", NamedTextColor.GRAY))

            server.sendMessage(msg)
        }
    }
}