package br.com.spacevips.core.platform.bukkit.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.bukkit.entity.Player;

public class CacheUser {

    private Cache<String, Player> playerCache = Caffeine.newBuilder().build();

    public void loadCache(Player player) {
        playerCache.put(player.getUniqueId().toString(), player);
    }

    public void unloadCache(Player player) {
        playerCache.invalidate(player.getUniqueId().toString());
    }
}
