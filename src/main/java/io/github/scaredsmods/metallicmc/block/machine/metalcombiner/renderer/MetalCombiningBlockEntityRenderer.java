package io.github.scaredsmods.metallicmc.block.machine.metalcombiner.renderer;

import io.github.scaredsmods.metallicmc.block.machine.metalcombiner.blockentity.MetalCombinerBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class MetalCombiningBlockEntityRenderer implements BlockEntityRenderer<MetalCombinerBlockEntity> {

    public MetalCombiningBlockEntityRenderer(BlockEntityRendererFactory.Context context){

    }


    @Override
    public void render(MetalCombinerBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack input_1= entity.getStack(MetalCombinerBlockEntity.INPUT_SLOT_1);
        ItemStack input_2= entity.getStack(MetalCombinerBlockEntity.INPUT_SLOT_2);
        ItemStack output = entity.getStack(MetalCombinerBlockEntity.OUTPUT_SLOT);


        matrices.push();

        matrices.multiply(RotationAxis.POSITIVE_X.rotation(270));

        itemRenderer.renderItem(input_1, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        itemRenderer.renderItem(input_2, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        itemRenderer.renderItem(output, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);

        matrices.pop();

    }
    private int getLightLevel(World world, BlockPos pos){
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
