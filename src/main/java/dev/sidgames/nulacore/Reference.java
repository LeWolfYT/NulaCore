package dev.sidgames.nulacore;

import dev.sidgames.nulacore.util.ModConfig;
import net.fabricmc.loader.api.FabricLoader;

public class Reference {
    public static final ModConfig MOD = new Mod();

    public static final String MODRINTH_API = "https://api.modrinth.com/v2";

    private static class Mod implements ModConfig {
        @Override
        public String getName() {
            return "NulaCore";
        }

        @Override
        public String getId() {
            return "nulacore";
        }

        @Override
        public String getVersion() {
            return FabricLoader.getInstance().getModContainer(getId()).get().getMetadata().getVersion().toString();
        }

        @Override
        public String getMcVersion() {
            return "1.19.2";
        }

        @Override
        public String getModrinthId() {
            return "nulacore";
        }
    }
}
