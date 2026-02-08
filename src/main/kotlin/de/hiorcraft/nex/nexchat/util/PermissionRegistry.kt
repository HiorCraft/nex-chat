package de.hiorcraft.nex.nexchat.util

object PermissionRegistry {

    private const val PREFIX = "nexchat"
    private const val COMMAND_PREFIX = "$PREFIX.command"

    const val COMMAND_TEAMCHAT = "$COMMAND_PREFIX.teamchat"
    const val COMMAND_PLAYERDEATH = "$COMMAND_PREFIX.playerdeath"
    const val COMMAND_PLAYERDEATH_OFF = "$COMMAND_PREFIX.playerdeath_off"
    const val COMMAND_PLAYERDEATH_NEX = "$COMMAND_PREFIX.playerdeath_nex"
    const val COMMAND_PLAYERDEATH_VANILLA = "$COMMAND_PREFIX.playerdeath_vanilla"
}