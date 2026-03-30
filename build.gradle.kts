import dev.slne.surf.surfapi.gradle.util.withSurfApiBukkit

plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin")
}

group = "de.hiorcraft.nex.nexchat"
version = findProperty("version") as String

repositories {
    mavenCentral()
    maven("https://repo.lucko.me/")
}

dependencies {
    compileOnly("net.luckperms:api:5.4")
}

surfPaperPluginApi {
    mainClass("de.hiorcraft.nex.nexchat.BukkitMain")
    authors.add("HiorCraft")
}
