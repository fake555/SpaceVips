package br.com.spacevips.core.platform.bukkit.manager;

import br.com.spacevips.core.platform.SpaceVips;
import br.com.spacevips.core.platform.bukkit.utils.BukkitClassLoader;
import org.bukkit.plugin.java.JavaPlugin;

public class SpacePluginsAPI {
    public static SpacePluginsAPI getApi() {
        return new SpacePluginsAPI();
    }

    private String vipName;

    public SpacePluginsAPI getVip(String vipName) {
        this.vipName = vipName;
        return this;
    }

    public String getDisplay() {
        return vipName;
    }
    public BukkitClassLoader getClassLoader(JavaPlugin instance) {
        return new BukkitClassLoader(instance);
    }

    public SpaceVips getPlugin() {
        return SpaceVips.getInstance();
    }
}
