package br.com.spacevips.core.platform.bukkit.utils;

import br.com.spacevips.core.platform.SpaceVips;
import org.bukkit.Bukkit;

public class ConfigUtils {
    public static void loadFile(String name) {
        if (SpaceVips.getInstance().getResource(name) != null) {
            Bukkit.getPluginManager().getPlugin("SpaceVips").saveDefaultConfig();
        }
    }
}
