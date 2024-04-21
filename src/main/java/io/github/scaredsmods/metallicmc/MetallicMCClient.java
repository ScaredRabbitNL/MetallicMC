package io.github.scaredsmods.metallicmc;

import io.github.scaredsmods.metallicmc.block.machine.ModBlockEntities;
import io.github.scaredsmods.metallicmc.block.machine.metalcombiner.renderer.MetalCombiningBlockEntityRenderer;
import io.github.scaredsmods.metallicmc.screen.ModScreenHandlers;
import io.github.scaredsmods.metallicmc.screen.metalcombiner.MetalCombiningScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

public class MetallicMCClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.METAL_COMBINING_SCREEN_HANDLER, MetalCombiningScreen::new);

        BlockEntityRendererFactories.register(ModBlockEntities.METAL_COMBINER_BLOCK_ENTITY, MetalCombiningBlockEntityRenderer::new);
    }
}
