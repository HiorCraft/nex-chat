package de.hiorcraft.nex.nexchat.util

object PermissionRegistry {

    private const val PREFIX = "nexchat"
    private const val COMMAND_PREFIX = "$PREFIX.command"

    const val COMMAND_TEAMCHAT = "$COMMAND_PREFIX.teamchat"
    const val COMMAND_PLAYERDEATH = "$COMMAND_PREFIX.playerdeath"
    const val COMMAND_PLAYERADVANCEMENT = "$COMMAND_PREFIX.playeradvancement"
}