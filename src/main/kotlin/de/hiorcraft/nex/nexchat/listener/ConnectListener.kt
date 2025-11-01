package de.hiorcraft.nex.nexchat.listener

import de.hiorcraft.nex.nexchat.plugin
import dev.slne.surf.surfapi.bukkit.api.extensions.server
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class ConnectListener : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.joinMessage(null)
        val msg = Component.text("[+]", NamedTextColor.GREEN)
            .append(Component.text(" ${event.player.name}", NamedTextColor.GRAY))
        server.sendMessage(msg)
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        event.quitMessage(null)
        val msg = Component.text("[-]", NamedTextColor.RED)
            .append(Component.text(" ${event.player.name}", NamedTextColor.GRAY))
        server.sendMessage(msg)
    }
}