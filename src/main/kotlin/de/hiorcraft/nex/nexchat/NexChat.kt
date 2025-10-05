package de.hiorcraft.nex.nexchat

import de.hiorcraft.nex.nexchat.command.ModChat
import dev.jorel.commandapi.CommandAPI
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.java.JavaPlugin

class NexChat : JavaPlugin(), Listener {

    override fun onEnable() {
        logger.info("ModChat Plugin ist starting.....")


        server.pluginManager.registerEvents(this, this)

        // Befehle registrieren
        ModChat(this).register()
        logger.info("ModChat Plugin ist started")
    }

    override fun onDisable() {
        CommandAPI.onDisable()
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.joinMessage(null)
        val msg = Component.text("[+]", NamedTextColor.GREEN)
            .append(Component.text(" ${event.player.name}", NamedTextColor.GRAY))
        server.broadcast(msg)
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        event.quitMessage(null)
        val msg = Component.text("[-]", NamedTextColor.RED)
            .append(Component.text(" ${event.player.name}", NamedTextColor.GRAY))
        server.broadcast(msg)
    }
}
