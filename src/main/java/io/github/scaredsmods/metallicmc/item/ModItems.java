package io.github.scaredsmods.metallicmc.item;

import io.github.scaredsmods.metallicmc.MetallicMC;
import io.github.scaredsmods.metallicmc.init.ItemInit;
import io.github.scaredsmods.metallicmc.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    public static final Item SCARED_RABBITIUM_INGOT = registerItem("scared_rabbitium_ingot",
            new Item(new FabricItemSettings()));
    public static final Item VANTA_INGOT = registerItem("vanta_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item VANTA_DUST = registerItem("vanta_dust",
            new Item(new FabricItemSettings().fireproof()));

    public static final Item RAW_SCARED_RABBITIUM = registerItem("raw_scared_rabbitium",
            new Item(new FabricItemSettings()));


    public static final Item SCARED_RABBITIUM_PICKAXE = registerItem("scared_rabbitium_pickaxe",
            new PickaxeItem(ModToolMaterial.SCARED_RABBITIUM, 2, 3.5F, new FabricItemSettings()));

    public static final Item SCARED_RABBITIUM_SWORD = registerItem("scared_rabbitium_sword",
            new SwordItem(ModToolMaterial.SCARED_RABBITIUM,  7, 3f, new FabricItemSettings()));
    public static final Item SCARED_RABBITIUM_SHOVEL = registerItem("scared_rabbitium_shovel",
            new ShovelItem(ModToolMaterial.SCARED_RABBITIUM, 1, 3.5F , new FabricItemSettings()));
    public static final Item SCARED_RABBITIUM_AXE = registerItem("scared_rabbitium_axe",
            new AxeItem(ModToolMaterial.SCARED_RABBITIUM, 6, 3.5F, new FabricItemSettings()));
    public static final Item SCARED_RABBITIUM_HOE = registerItem("scared_rabbitium_hoe",
            new HoeItem(ModToolMaterial.SCARED_RABBITIUM, 2, 3.5F, new FabricItemSettings()));


    public static final Item SCARED_RABBITIUM_HELMET = registerItem("scared_rabbitium_helmet",
            new ModArmorItem(ModArmorMaterial.SCARED_RABBITIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item SCARED_RABBITIUM_CHESTPLATE = registerItem("scared_rabbitium_chestplate",
            new ArmorItem(ModArmorMaterial.SCARED_RABBITIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SCARED_RABBITIUM_LEGGINGS = registerItem("scared_rabbitium_leggings",
            new ArmorItem(ModArmorMaterial.SCARED_RABBITIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SCARED_RABBITIUM_BOOTS = registerItem("scared_rabbitium_boots",
            new ArmorItem(ModArmorMaterial.SCARED_RABBITIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MetallicMC.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MetallicMC.LOGGER.info("Registering mod items for: " + MetallicMC.MOD_ID);

    }
}
