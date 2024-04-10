package io.github.scaredsmods.metallicmc.datagen;

import io.github.scaredsmods.metallicmc.block.ModBlocks;
import io.github.scaredsmods.metallicmc.block.machine.ModBlockEntities;
import io.github.scaredsmods.metallicmc.block.machine.ModMachines;
import io.github.scaredsmods.metallicmc.item.ModItems;
import io.github.scaredsmods.metallicmc.item.cobalt.CobaltItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCARED_RABBITIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCARED_RABBITIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SCARED_RABBITIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHERRACK_SCARED_RABBITIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_SCARED_RABBITIUM_ORE);

        //blockStateModelGenerator.registerSimpleState(ModBlocks.INGOT_SEPARATOR);
        blockStateModelGenerator.registerSimpleState(ModMachines.METAL_COMBINER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SCARED_RABBITIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANTA_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANTA_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SCARED_RABBITIUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.SCARED_RABBITIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SCARED_RABBITIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SCARED_RABBITIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SCARED_RABBITIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SCARED_RABBITIUM_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.SCARED_RABBITIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SCARED_RABBITIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SCARED_RABBITIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SCARED_RABBITIUM_BOOTS);

        itemModelGenerator.register(CobaltItems.COBALT_INGOT, Models.GENERATED);
    }
}
