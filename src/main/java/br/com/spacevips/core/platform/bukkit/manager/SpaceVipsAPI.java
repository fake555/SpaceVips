package br.com.spacevips.core.platform.bukkit.manager;

import br.com.spacevips.core.platform.bukkit.cache.CacheUser;

public class SpaceVipsAPI {

    private CacheUser cacheUser;
    private SpaceVipsAPI() {
        cacheUser = new CacheUser();
    }

    public static SpaceVipsAPI core() {
        return new SpaceVipsAPI();
    }

    public CacheUser getCacheManager() {
        return cacheUser;
    }
}
