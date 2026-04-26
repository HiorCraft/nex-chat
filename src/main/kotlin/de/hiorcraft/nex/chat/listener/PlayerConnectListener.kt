package de.hiorcraft.nex.chat.listener


import de.hiorcraft.nex.chat.hook.LuckPermsHook
import dev.slne.surf.surfapi.bukkit.api.extensions.server
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class PlayerConnectListener : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.joinMessage(null)

        val prefix = LuckPermsHook.getPrefix(event.player)
        val prefixComponent = if (prefix.isNotEmpty())
            LegacyComponentSerializer.legacyAmpersand().deserialize(prefix)
        else
            Component.empty()

        val msg = Component.text("[", NamedTextColor.GRAY)
            .append(Component.text("+", NamedTextColor.GREEN))
            .append(Component.text("] ", NamedTextColor.GRAY))
            .append(prefixComponent)
            .append(Component.text(event.player.name, NamedTextColor.GRAY))

        server.sendMessage(msg)
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        event.quitMessage(null)

        val prefix = LuckPermsHook.getPrefix(event.player)
        val prefixComponent = if (prefix.isNotEmpty())
            LegacyComponentSerializer.legacyAmpersand().deserialize(prefix)
        else
            Component.empty()

        val msg = Component.text("[", NamedTextColor.GRAY)
            .append(Component.text("-", NamedTextColor.RED))
            .append(Component.text("] ", NamedTextColor.GRAY))
            .append(prefixComponent)
            .append(Component.text(event.player.name, NamedTextColor.GRAY))

        server.sendMessage(msg)
    }
}