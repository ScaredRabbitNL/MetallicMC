package io.github.scaredsmods.metallicmc.item.cobalt;

import io.github.scaredsmods.metallicmc.MetallicMC;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CobaltItems {

    public static final Item COBALT_INGOT = registerItem("cobalt_ingot",
            new Item(new FabricItemSettings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MetallicMC.MOD_ID, name), item);

    }

    public static void registerCobaltItems() {
        MetallicMC.LOGGER.info("Registering cobalt items for: " + MetallicMC.MOD_ID);
    }
}
