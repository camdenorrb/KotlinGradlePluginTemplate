plugins {
    kotlin("jvm") version "1.8.20"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "dev.twelveoclock"
version = "1.0.0"

repositories {

    mavenCentral()

    maven("https://hub.spigotmc.org/nexus/content/repositories/public/") {
        name = "SpigotMC"
    }
}

dependencies {

    compileOnly("org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT")

    implementation(kotlin("stdlib-jdk8"))
    implementation("com.moandjiezana.toml:toml4j:0.7.2")

    testImplementation(kotlin("test-junit5"))
    testImplementation("com.github.seeseemelk:MockBukkit-v1.17:1.13.0")
}


tasks {

    test {
        useJUnitPlatform()
    }

    // TODO: Change the second parameter to your plugin's package + the suffix.
    //       For example, if your main package is "me.example.catplugin",
    //       change the second parameter for the first relocate to:
    //       "me.example.catplugin.libs.org.jetbrains".
    //       Then, follow this pattern to the other relocate calls.
    shadowJar {
        relocate("org.jetbrains", "dev.twelveoclock.plugintemplate.libs.org.jetbrains")
        relocate("org.intellij", "dev.twelveoclock.plugintemplate.libs.org.intellij")
        relocate("com.google", "dev.twelveoclock.plugintemplate.libs.com.google")
        relocate("com.moandjiezana", "dev.twelveoclock.plugintemplate.libs.com.moandjiezana")
        relocate("kotlin", "dev.twelveoclock.plugintemplate.libs.kotlin")
    }

}
