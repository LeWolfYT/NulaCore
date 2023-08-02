package dev.sidgames.nulacore;

import net.fabricmc.api.ModInitializer;

import static dev.sidgames.nulacore.Reference.*;

public class NulaCore implements ModInitializer {
    @Override
    public void onInitialize() {
        logger.info("Initializing " + NAME + " v" + MC_VERSION + "-" + VERSION);
    }
}
