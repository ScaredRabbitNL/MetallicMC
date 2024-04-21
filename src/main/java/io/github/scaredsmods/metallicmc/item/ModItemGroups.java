package io.github.scaredsmods.metallicmc.item;

import io.github.scaredsmods.metallicmc.MetallicMC;
import io.github.scaredsmods.metallicmc.block.ModBlocks;
import io.github.scaredsmods.metallicmc.block.machine.ModMachines;
import io.github.scaredsmods.metallicmc.content.cobalt.CobaltBlocks;
import io.github.scaredsmods.metallicmc.content.cobalt.CobaltItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MMC_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MetallicMC.MOD_ID, "metallic_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.metallicmc.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.SCARED_RABBITIUM_BLOCK)).entries((displayContext, entries) -> {

                                entries.add(ModBlocks.SCARED_RABBITIUM_BLOCK);
                                entries.add(ModBlocks.SCARED_RABBITIUM_ORE);
                                entries.add(ModBlocks.DEEPSLATE_SCARED_RABBITIUM_ORE);
                                entries.add(ModBlocks.NETHERRACK_SCARED_RABBITIUM_ORE);
                                entries.add(ModBlocks.END_STONE_SCARED_RABBITIUM_ORE);

                                //Cobalt
                                entries.add(CobaltBlocks.COBALT_BLOCK);
                                entries.add(CobaltBlocks.COBALT_ORE);
                                entries.add(CobaltBlocks.DEEPSLATE_COBALT_ORE);
                                entries.add(CobaltBlocks.NETHER_COBALT_ORE);
                                entries.add(CobaltBlocks.END_COBALT_ORE);
                            }
                    ).build());
    public static final ItemGroup MMC_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MetallicMC.MOD_ID, "metallic_items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.metallicmc.items"))
                    .icon(() -> new ItemStack(ModItems.SCARED_RABBITIUM_PICKAXE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.SCARED_RABBITIUM_PICKAXE);
                        entries.add(ModItems.SCARED_RABBITIUM_SWORD);
                        entries.add(ModItems.SCARED_RABBITIUM_AXE);
                        entries.add(ModItems.SCARED_RABBITIUM_SHOVEL);
                        entries.add(ModItems.SCARED_RABBITIUM_HOE);
                        entries.add(ModItems.SCARED_RABBITIUM_HELMET);
                        entries.add(ModItems.SCARED_RABBITIUM_CHESTPLATE);
                        entries.add(ModItems.SCARED_RABBITIUM_LEGGINGS);
                        entries.add(ModItems.SCARED_RABBITIUM_BOOTS);

                    })

                    .build());
    public static final ItemGroup MMC_MACHINES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MetallicMC.MOD_ID, "metallic_machines"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.metallicmc.machines"))
                    .icon(() -> new ItemStack(ModMachines.METAL_COMBINER)).entries((displayContext, entries) -> {
                        entries.add(ModMachines.METAL_COMBINER);
                        //entries.add(ModBlocks.INGOT_SEPARATOR);
                            })
                    .build());

    public static final ItemGroup MMC_INGOTS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MetallicMC.MOD_ID, "metallic_ingots"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.metallicmc.ingots"))
                    .icon(() -> new ItemStack(ModItems.SCARED_RABBITIUM_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.SCARED_RABBITIUM_INGOT);
                        entries.add(CobaltItems.COBALT_INGOT);
                        entries.add(ModItems.VANTA_INGOT);
                    })
                    .build());
    public static final ItemGroup MMC_DUSTS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MetallicMC.MOD_ID, "metallic_dusts"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.metallicmc.dusts"))
                    .icon(() -> new ItemStack(ModItems.VANTA_DUST)).entries((displayContext, entries) -> {
                        entries.add(ModItems.VANTA_DUST);

                    })
                    .build());
    public static final ItemGroup MMC_RAW_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MetallicMC.MOD_ID, "metallic_raw_metals"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.metallicmc.raw_metals"))
                    .icon(() -> new ItemStack(ModItems.RAW_SCARED_RABBITIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_SCARED_RABBITIUM);
                        entries.add(CobaltItems.RAW_COBALT);

                    })
                    .build());

    public static void registerModItemGroups(){
        MetallicMC.LOGGER.info("Registering mod item groups for: " + MetallicMC.MOD_ID);
    }
}
