package io.github.scaredsmods.metallicmc.block;

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

public class ModBlocks {


    public static final Block SCARED_RABBITIUM_BLOCK = registerBlock("scared_rabbitium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
    public static final Block SCARED_RABBITIUM_ORE = registerBlock("scared_rabbitium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.STONE).strength(2F)));
    public static final Block DEEPSLATE_SCARED_RABBITIUM_ORE = registerBlock("deepslate_scared_rabbitium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4F)));
    public static final Block NETHERRACK_SCARED_RABBITIUM_ORE = registerBlock("netherrack_scared_rabbitium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5F)));
    public static final Block END_STONE_SCARED_RABBITIUM_ORE = registerBlock("end_stone_scared_rabbitium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4.5F)));

    /*
    public static final Block INGOT_SEPARATOR = registerBlock("ingot_separator",
            new IngotSeparatorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));
    */





    public static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(MetallicMC.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MetallicMC.MOD_ID, name),
                block);
    }

    public static void registerModBlocks() {
        MetallicMC.LOGGER.info("Registering mod items for: " + MetallicMC.MOD_ID);
    }
}
