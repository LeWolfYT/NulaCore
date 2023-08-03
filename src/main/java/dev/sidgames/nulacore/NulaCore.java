package dev.sidgames.nulacore;

import dev.sidgames.nulacore.feature.updater.InstalledMods;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dev.sidgames.nulacore.Reference.*;

public class NulaCore implements ModInitializer {
    private static final Logger logger = LoggerFactory.getLogger(NulaCore.class);

    @Override
    public void onInitialize() {
        logger.info("Initializing " + MOD.getName() + " v" + MOD.getMcVersion() + "-" + MOD.getVersion());

        InstalledMods.register(MOD);

        Thread updateThread = new Thread(() -> {
            try {
                synchronized (Thread.currentThread()) {
                    Thread.currentThread().wait(5000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("Checking for updates");
        }, "NulaCore Update Checker");
        updateThread.start();
    }
}
