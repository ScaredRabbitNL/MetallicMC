package io.github.scaredsmods.metallicmc.api.recipe;

import io.github.scaredsmods.metallicmc.MetallicMC;
import io.github.scaredsmods.metallicmc.api.recipe.metalcombiner.MetalCombiningRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(MetallicMC.MOD_ID, MetalCombiningRecipe.Serializer.ID),
                MetalCombiningRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(MetallicMC.MOD_ID, MetalCombiningRecipe.Type.ID),
                MetalCombiningRecipe.Type.INSTANCE);
    }
}
