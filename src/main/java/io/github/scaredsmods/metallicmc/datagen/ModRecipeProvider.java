package io.github.scaredsmods.metallicmc.datagen;

import io.github.scaredsmods.metallicmc.block.ModBlocks;
import io.github.scaredsmods.metallicmc.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> SCARED_RABBITIUM_SMELTABLES = List.of(ModItems.RAW_SCARED_RABBITIUM,
            ModBlocks.SCARED_RABBITIUM_ORE, ModBlocks.DEEPSLATE_SCARED_RABBITIUM_ORE, ModBlocks.NETHERRACK_SCARED_RABBITIUM_ORE, ModBlocks.END_STONE_SCARED_RABBITIUM_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    public static final String group = "scared_rabbitium";

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, SCARED_RABBITIUM_SMELTABLES, RecipeCategory.MISC, ModItems.SCARED_RABBITIUM_INGOT,
                0.5f, 200, group);
        offerBlasting(exporter, SCARED_RABBITIUM_SMELTABLES, RecipeCategory.MISC, ModItems.SCARED_RABBITIUM_INGOT,
                1.0f, 100, group);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SCARED_RABBITIUM_INGOT ,RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.SCARED_RABBITIUM_BLOCK);



        //Default Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SCARED_RABBITIUM_PICKAXE, 1)
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARED_RABBITIUM_PICKAXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SCARED_RABBITIUM_SWORD, 1)
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" S ")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARED_RABBITIUM_SWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SCARED_RABBITIUM_AXE, 1)
                .pattern("II ")
                .pattern("IS ")
                .pattern(" S ")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARED_RABBITIUM_AXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SCARED_RABBITIUM_SHOVEL, 1)
                .pattern(" I ")
                .pattern(" S ")
                .pattern(" S ")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARED_RABBITIUM_SHOVEL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SCARED_RABBITIUM_HOE, 1)
                .pattern(" II")
                .pattern(" S ")
                .pattern(" S ")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARED_RABBITIUM_HOE)));

        //Axe and hoe reversed
       /* ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SCARED_RABBITIUM_AXE, 1)
                .pattern(" II")
                .pattern(" SI")
                .pattern(" S ")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SC)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SCARED_RABBITIUM_HOE, 1)
                .pattern("II ")
                .pattern(" S ")
                .pattern(" S ")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARED_RABBITIUM_HOE)));

        */
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SCARED_RABBITIUM_HELMET, 1)
                .pattern("III")
                .pattern("I I")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARED_RABBITIUM_HELMET)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SCARED_RABBITIUM_CHESTPLATE, 1)
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARED_RABBITIUM_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SCARED_RABBITIUM_LEGGINGS,1)
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARED_RABBITIUM_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SCARED_RABBITIUM_BOOTS, 1)
                .pattern("I I")
                .pattern("I I")
                .input('I', ModItems.SCARED_RABBITIUM_INGOT)
                .criterion(hasItem(ModItems.SCARED_RABBITIUM_INGOT), conditionsFromItem(ModItems.SCARED_RABBITIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SCARED_RABBITIUM_BOOTS)));
    }
}
