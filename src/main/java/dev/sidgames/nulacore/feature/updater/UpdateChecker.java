package dev.sidgames.nulacore.feature.updater;

import dev.sidgames.nulacore.feature.DisabledFeatureException;
import dev.sidgames.nulacore.feature.Feature;
import dev.sidgames.nulacore.util.ModConfig;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static dev.sidgames.nulacore.Reference.MODRINTH_API;

public class UpdateChecker implements Feature {
    private static final Logger logger = LoggerFactory.getLogger(UpdateChecker.class);
    public Update check(String id) {
        String cv = "";
        String lv = "";
        String mid = "";
        ModConfig mc = null;
        boolean ua = false;

        if (enabled) {
            for (ModConfig mod : InstalledMods.get()) if (mod.getId().equals(id)) {
                cv = mod.getVersion();
                mid = mod.getModrinthId();
                mc = mod;
            }

            try {
                URL url = new URL(MODRINTH_API + "/project/" + mid + "/version");

                HttpURLConnection req = (HttpURLConnection) url.openConnection();
                req.setRequestMethod("GET");
                req.connect();

                int rcode = req.getResponseCode();

                if (rcode != 200) {
                    throw new IOException("HttpResponseCode: " + rcode);
                } else {

                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());

                    //Write all the JSON data into a string using a scanner
                    while (scanner.hasNext()) {
                        inline += scanner.nextLine();
                    }

                    //Close the scanner
                    scanner.close();

                    var versions = new JSONArray(inline);
                    for (int ver = versions.length() - 1; ver >= 0; ver--) {
                        var version = versions.getJSONObject(ver);
                        var vernum = version.getString("version_number");
                        var mcver = version.getJSONArray("game_versions");
                        var vertype = version.getString("version_type");
                        var loaders = version.getJSONArray("loaders");

                        if (loaders.toList().contains("fabric") && mcver.toList().contains(mc.getMcVersion()) && vertype.equals("release") && !vernum.equals(cv)) {

                        }
                    }
                }
            } catch (Exception e) {
                logger.warn("Failed to check for updates", e);
            }
        } else {
            logger.warn("Attempted to use disabled feature 'UpdateChecker'", new DisabledFeatureException());
        }

        String finalCv = cv;
        ModConfig finalMc = mc;
        return new Update() {
            @Override
            public String currentVersion() {
                return finalCv;
            }

            @Override
            public String latestVersion() {
                return lv;
            }

            @Override
            public boolean available() {
                return ua;
            }

            @Override
            public String id() {
                return finalMc.getName();
            }
        };
    }

    public List<Update> recursiveCheck() {
        List<Update> r = new ArrayList<>();
        if (enabled) {
            for (ModConfig mod : InstalledMods.get()) {
                r.add(check(mod.getId()));
            }
        } else {
            logger.warn("Attempted to use disabled feature 'UpdateChecker'", new DisabledFeatureException());
        }
        return r;
    }

    private static boolean enabled = true;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }


    public interface Update {
        String currentVersion();
        String latestVersion();
        boolean available();
        String id();
    }
}
