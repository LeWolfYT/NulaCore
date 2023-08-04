package dev.sidgames.nulacore;

import dev.sidgames.nulacore.feature.updater.InstalledMods;
import dev.sidgames.nulacore.feature.updater.UpdateChecker;
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
            var updates = UpdateChecker.recursiveCheck();
            for (UpdateChecker.Update update : updates) {
                if (update.available()) {
                    logger.info("You have a mod update available! " + update.id() + " " + update.currentVersion() + " -> " + update.latestVersion());
                }
            }
        }, "NulaCore Update Checker");
        updateThread.start();
    }
}
