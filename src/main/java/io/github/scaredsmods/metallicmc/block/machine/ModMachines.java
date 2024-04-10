package io.github.scaredsmods.metallicmc.block.machine;

import io.github.scaredsmods.metallicmc.MetallicMC;
import io.github.scaredsmods.metallicmc.block.machine.metalcombiner.MetalCombinerBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModMachines {

    public static final Block METAL_COMBINER = registerBlock("metal_combiner",
            new MetalCombinerBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));




    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MetallicMC.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

    }
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MetallicMC.MOD_ID, name), block);
    }

    public static void registerModMachines() {
        MetallicMC.LOGGER.info("Registering machines for: " + MetallicMC.MOD_ID);
    }
}
