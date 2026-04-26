plugins {
    id("dev.slne.surf.surfapi.gradle.paper-plugin") version "1.21.11+"
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

group = "de.hiorcraft.nexchat"
version = findProperty("version") as String

surfPaperPluginApi {
    mainClass("de.hiorcraft.nex.chat.PaperMain")
    generateLibraryLoader(false)

    authors.add("HiorCraft")
}
