package io.github.scaredsmods.metallicmc;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.scaredsmods.metallicmc.init.ModInit.init;

public class MetallicMC implements ModInitializer {


	public static final String MOD_ID = "metallicmc";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		init();

	}
}