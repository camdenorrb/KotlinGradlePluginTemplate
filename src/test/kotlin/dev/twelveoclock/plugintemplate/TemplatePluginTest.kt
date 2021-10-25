package dev.twelveoclock.plugintemplate

import be.seeseemelk.mockbukkit.MockBukkit
import be.seeseemelk.mockbukkit.ServerMock
import org.bukkit.Sound
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TemplatePluginTest {

    lateinit var server: ServerMock

    lateinit var plugin: TemplatePlugin


    @BeforeAll
    fun setup() {
        server = MockBukkit.mock()
        plugin = MockBukkit.load(TemplatePlugin::class.java)
    }


    @Test
    fun join() {
        val player = server.addPlayer()
        player.assertSoundHeard(Sound.ENTITY_CAT_PURR)
    }

    // TODO: Add more tests, unfortunately MockBukkit seems pretty limited


    @AfterAll
    fun tearDown() {
        MockBukkit.unmock()
    }

}