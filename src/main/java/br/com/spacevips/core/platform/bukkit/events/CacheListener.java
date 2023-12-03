package br.com.spacevips.core.platform.bukkit.events;

import br.com.spacevips.core.platform.bukkit.cache.CacheUser;
import br.com.spacevips.core.platform.bukkit.manager.SpaceVipsAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static br.com.spacevips.core.platform.SpaceVips.getPlayerManager;

public class CacheListener implements Listener {
    CacheUser cacheUser = new CacheUser();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        SpaceVipsAPI.core().getCacheManager().loadCache(event.getPlayer());
        getPlayerManager().loadPlayer(event.getPlayer().getName());
    }


    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        SpaceVipsAPI.core().getCacheManager().unloadCache(event.getPlayer());
        getPlayerManager().salvarPlayer(getPlayerManager().getPlayer(event.getPlayer().getName()));
    }
}
