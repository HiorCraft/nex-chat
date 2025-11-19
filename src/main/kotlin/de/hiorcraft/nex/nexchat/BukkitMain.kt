package de.hiorcraft.nex.nexchat

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import de.hiorcraft.nex.nexchat.command.teamchatCommand
import de.hiorcraft.nex.nexchat.listener.ConnectListener
import de.hiorcraft.nex.nexchat.listener.ModButtons
import dev.jorel.commandapi.CommandAPI
import org.bukkit.plugin.java.JavaPlugin

val plugin get() = JavaPlugin.getPlugin(BukkitMain::class.java)

class BukkitMain : SuspendingJavaPlugin() {

    override fun onEnable() {
        logger.info("ModChat Plugin ist starting.....")

        val manager = server.pluginManager

        manager.registerEvents(ConnectListener(), this)
        //manager.registerEvents(ModButtons(), this)

        teamchatCommand()
        logger.info("ModChat Plugin ist started")
    }

    override fun onDisable() {
        logger.info("ModChat Plugin ist disabled")
        CommandAPI.onDisable()

        logger.info("Bye <3")
    }
}
