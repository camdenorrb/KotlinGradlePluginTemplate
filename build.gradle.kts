plugins {
    kotlin("jvm") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.1.0"
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

    compileOnly("org.spigotmc:spigot-api:1.17.1-R0.1-SNAPSHOT")

    implementation(kotlin("stdlib-jdk8"))
    implementation("com.moandjiezana.toml:toml4j:0.7.2")

    testImplementation(kotlin("test-junit5"))
    testImplementation("com.github.seeseemelk:MockBukkit-v1.17:1.10.4")
}


tasks {
    test {
        useJUnitPlatform()
    }
    shadowJar {
        relocate("kotlin", "dev.twelveoclock.plugintemplate.libs.kotlin")
        relocate("org.jetbrains", "dev.twelveoclock.plugintemplate.libs.org.jetbrains")
        relocate("org.intellij", "dev.twelveoclock.plugintemplate.libs.org.intellij")
        relocate("com.google", "dev.twelveoclock.plugintemplate.libs.com.google")
        relocate("com.moandjiezana", "dev.twelveoclock.plugintemplate.libs.com.moandjiezana")
    }

}
