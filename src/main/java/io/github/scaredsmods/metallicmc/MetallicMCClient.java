package io.github.scaredsmods.metallicmc;

import io.github.scaredsmods.metallicmc.screen.ModScreenHandlers;
import io.github.scaredsmods.metallicmc.screen.metalcombiner.MetalCombiningScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class MetallicMCClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.METAL_COMBINING_SCREEN_HANDLER, MetalCombiningScreen::new);
    }
}
