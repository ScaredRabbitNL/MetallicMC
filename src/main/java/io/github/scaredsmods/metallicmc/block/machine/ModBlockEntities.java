package io.github.scaredsmods.metallicmc.block.machine;

import io.github.scaredsmods.metallicmc.MetallicMC;
import io.github.scaredsmods.metallicmc.block.ModBlocks;
import io.github.scaredsmods.metallicmc.block.machine.metalcombiner.blockentity.MetalCombinerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {


    public static final BlockEntityType<MetalCombinerBlockEntity> METAL_COMBINER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MetallicMC.MOD_ID, "metal_combiner_be"),
                    FabricBlockEntityTypeBuilder.create(MetalCombinerBlockEntity::new, ModMachines.METAL_COMBINER).build());


    public static void registerModBlockEntities() {
        MetallicMC.LOGGER.info("Registering block entities for: " + MetallicMC.MOD_ID);
    }
}
