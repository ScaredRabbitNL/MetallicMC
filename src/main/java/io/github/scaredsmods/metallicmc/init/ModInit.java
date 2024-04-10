package io.github.scaredsmods.metallicmc.init;

import io.github.scaredsmods.metallicmc.block.ModBlocks;
import io.github.scaredsmods.metallicmc.block.machine.ModBlockEntities;
import io.github.scaredsmods.metallicmc.block.machine.ModMachines;
import io.github.scaredsmods.metallicmc.item.ModItemGroups;
import io.github.scaredsmods.metallicmc.item.ModItems;
import io.github.scaredsmods.metallicmc.api.recipe.ModRecipes;
import io.github.scaredsmods.metallicmc.screen.ModScreenHandlers;

public class ModInit {


    public static void init(){
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModItemGroups.registerModItemGroups();
        ModMachines.registerModMachines();
        ItemInit.registerMetalItems();
        ModBlockEntities.registerModBlockEntities();
        ModScreenHandlers.registerScreenHandlers();
        ModRecipes.registerRecipes();
    }
}
