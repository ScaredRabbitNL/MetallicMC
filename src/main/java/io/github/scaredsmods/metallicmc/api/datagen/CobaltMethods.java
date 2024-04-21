package io.github.scaredsmods.metallicmc.api.datagen;

import io.github.scaredsmods.metallicmc.content.cobalt.CobaltBlocks;
import io.github.scaredsmods.metallicmc.content.cobalt.CobaltItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class CobaltMethods {

    public static void generateCobaltBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){
        blockStateModelGenerator.registerSimpleCubeAll(CobaltBlocks.COBALT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(CobaltBlocks.COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CobaltBlocks.DEEPSLATE_COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CobaltBlocks.NETHER_COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(CobaltBlocks.END_COBALT_ORE);
    }

    public static void generateCobaltItemModels(ItemModelGenerator generator) {
        generator.register(CobaltItems.COBALT_INGOT, Models.GENERATED);
        generator.register(CobaltItems.RAW_COBALT, Models.GENERATED);
    }
}
