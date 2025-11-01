package de.hiorcraft.nex.nexchat.listener

import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import org.bukkit.Bukkit

class ModButtons : JavaPlugin(), Listener {

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onChat(event: AsyncChatEvent) {
        val player = event.player
        val message = event.message()

        event.renderer { _, _, msg, _ ->

            val deleteButton = Component.text("[X]", NamedTextColor.RED)
                .hoverEvent(HoverEvent.showText(Component.text("Lösche Nachricht von ${player.name}")))
                .clickEvent(ClickEvent.callback { audience ->
                    Bukkit.getServer().deleteMessage(event.signedMessage())
                })


            val tpButton = Component.text("(TP)", NamedTextColor.AQUA)
                .hoverEvent(HoverEvent.showText(Component.text("Teleportiere zu ${player.name}")))
                .clickEvent(ClickEvent.runCommand("/tp ${player.name} 100 64 200"))

            tpButton.append(Component.text(" "))
                .append(deleteButton)
                .append(Component.text(" <${player.name}> ", NamedTextColor.YELLOW))
                .append(msg)
        }
    }
}