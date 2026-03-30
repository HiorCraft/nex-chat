package de.hiorcraft.nex.nexchat

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import de.hiorcraft.nex.nexchat.command.teamchatCommand
import de.hiorcraft.nex.nexchat.listener.PlayerAdvancementListener
import de.hiorcraft.nex.nexchat.listener.PlayerConnectListener
import de.hiorcraft.nex.nexchat.listener.PlayerDeathListener
import org.bukkit.plugin.java.JavaPlugin

val plugin get() = JavaPlugin.getPlugin(BukkitMain::class.java)

class BukkitMain : SuspendingJavaPlugin() {

    override fun onEnable() {
        logger.info("Nex-Chat Plugin ist starting.....")

        val manager = server.pluginManager

        manager.registerEvents(PlayerConnectListener(), this)
        manager.registerEvents(PlayerAdvancementListener(),this)
        manager.registerEvents(PlayerDeathListener, this)
        logger.info("Enabled Listeners.")

        teamchatCommand()
        logger.info("Commands Listeners.")
    }

    override fun onDisable() {
        logger.info("Bye <3")
    }
}
