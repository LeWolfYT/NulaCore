package dev.sidgames.nulacore.feature.updater;

import dev.sidgames.nulacore.util.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class InstalledMods {
    private static final Logger logger = LoggerFactory.getLogger(InstalledMods.class);
    private static final List<ModConfig> LIST = new ArrayList<>();

    public static void register(ModConfig config) {
        LIST.add(config);
        logger.info("Registered mod with NulaCore update checker: " + config.getName());
    }

    public static List<ModConfig> get() {
        return LIST;
    }
}
