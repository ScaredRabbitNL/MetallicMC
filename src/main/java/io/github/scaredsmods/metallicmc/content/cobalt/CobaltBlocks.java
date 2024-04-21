package io.github.scaredsmods.metallicmc.content.cobalt;

import io.github.scaredsmods.metallicmc.MetallicMC;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class CobaltBlocks {

    public static final Block COBALT_BLOCK = registerBlock("cobalt_block",
            new Block(FabricBlockSettings.copyOf(Blocks.LAPIS_BLOCK)));

    public static final Block COBALT_ORE = registerBlock("cobalt_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,3), FabricBlockSettings.copyOf(Blocks.LAPIS_ORE)));

    public static final Block DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_LAPIS_ORE)));

    public static final Block NETHER_COBALT_ORE = registerBlock("nether_cobalt_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4,5), FabricBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE)));

    public static final Block END_COBALT_ORE = registerBlock("end_cobalt_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0,5), FabricBlockSettings.copyOf(Blocks.END_STONE)));


    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MetallicMC.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MetallicMC.MOD_ID, name),
                block);
    }


    public static void registerCobaltBlocks() {
        MetallicMC.LOGGER.info("Registerings cobalt blocks for: " + MetallicMC.MOD_ID);
    }
}
