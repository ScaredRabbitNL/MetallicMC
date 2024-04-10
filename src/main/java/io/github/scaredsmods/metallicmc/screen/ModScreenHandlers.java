package io.github.scaredsmods.metallicmc.screen;

import io.github.scaredsmods.metallicmc.MetallicMC;
import io.github.scaredsmods.metallicmc.screen.metalcombiner.MetalCombiningScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {

    public static final ScreenHandlerType<MetalCombiningScreenHandler> METAL_COMBINING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(MetallicMC.MOD_ID, "metal_combining"),
                    new ExtendedScreenHandlerType<>(MetalCombiningScreenHandler::new));

    public static void registerScreenHandlers() {
        MetallicMC.LOGGER.info("Registering screen handlers for: " + MetallicMC.MOD_ID);
    }
}