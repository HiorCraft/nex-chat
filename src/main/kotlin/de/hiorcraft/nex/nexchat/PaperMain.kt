package de.hiorcraft.nex.nexchat

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import de.hiorcraft.nex.nexchat.command.playerDeathCommand
import de.hiorcraft.nex.nexchat.command.teamchatCommand
import de.hiorcraft.nex.nexchat.listener.PlayerConnect
import de.hiorcraft.nex.nexchat.listener.PlayerDeath
import org.bukkit.plugin.java.JavaPlugin

val plugin get() = JavaPlugin.getPlugin(BukkitMain::class.java)

class BukkitMain : SuspendingJavaPlugin() {

    override fun onEnable() {
        logger.info("Nex-Chat Plugin ist starting.....")

        val manager = server.pluginManager

        manager.registerEvents(PlayerConnect(), this)
        manager.registerEvents(PlayerDeath(),this)
        logger.info("Enabled Listeners.")

        teamchatCommand()
        playerDeathCommand()
        logger.info("Commands Listeners.")
    }

    override fun onDisable() {
        logger.info("Bye <3")
    }
}
