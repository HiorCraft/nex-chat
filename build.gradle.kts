import dev.slne.surf.surfapi.gradle.util.withSurfApiBukkit

plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
}

group = "de.hiorcraft.nex.nexchat"
version = findProperty("version") as String

surfPaperPluginApi {
    mainClass("de.hiorcraft.nex.nexchat.BukkitMain")
    authors.add("HiorCraft")

    runServer {
        withSurfApiBukkit()
    }
}