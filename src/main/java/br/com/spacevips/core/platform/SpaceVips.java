package br.com.spacevips.core.platform;

import br.com.spacevips.core.platform.bukkit.database.MySQL;
import br.com.spacevips.core.platform.bukkit.manager.PlayerManager;
import br.com.spacevips.core.platform.bukkit.manager.SpacePluginsAPI;
import br.com.spacevips.core.platform.bukkit.utils.BukkitClassLoader;
import br.com.spacevips.core.platform.bukkit.utils.ConfigUtils;
import com.google.common.base.Stopwatch;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class SpaceVips extends JavaPlugin {
    private static SpaceVips instance;
    private static MySQL mysql;
    private static PlayerManager playerManager;

    public void onEnable() {
        instance = this;
        Stopwatch loadTime = Stopwatch.createStarted();
        SpacePluginsAPI api = new SpacePluginsAPI();
        BukkitClassLoader classLoader = api.getClassLoader(this);
        classLoader.load("br.com.spacevips.core.platform.bukkit.commands", BukkitClassLoader.LoaderType.COMMAND);
        classLoader.load("br.com.spacevips.core.platform.bukkit.api.events", BukkitClassLoader.LoaderType.LISTENER);
        classLoader.load("br.com.spacevips.core.platform.bukkit.events", BukkitClassLoader.LoaderType.LISTENER);
        ConfigUtils.loadFile("config.yml");
        mysql = new MySQL(getConfig().getString("options.database.user"), getConfig().getString("options.database.pass"), getConfig().getString("options.database.host"), getConfig().getInt("options.database.port"), getConfig().getString("options.database.db"));
        playerManager = new PlayerManager();
        Bukkit.getConsoleSender().sendMessage("[SpaceVips] [Premium] Successful plugin start (took "+loadTime+")");

    }

    public void onDisable() {
    }

    public static SpaceVips getInstance() {
        return instance;
    }
    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static MySQL getMySQL() {
        return mysql;
    }
}