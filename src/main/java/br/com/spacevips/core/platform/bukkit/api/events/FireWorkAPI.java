package br.com.spacevips.core.platform.bukkit.api.events;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Collections;

public class FireWorkAPI {
    public static void spawnFirework(Location location, Color withFade, Color withColor, int fireWorkPower) {
        Firework firework = location.getWorld().spawn(location, Firework.class);
        FireworkMeta meta = firework.getFireworkMeta();
        FireworkEffect.Builder builder = FireworkEffect.builder();
        builder.with(FireworkEffect.Type.BURST);
        builder.withColor(Collections.singleton(withColor));
        builder.withFade(Collections.singleton(withFade));
        meta.addEffect(builder.build());
        meta.setPower(fireWorkPower);
        firework.setFireworkMeta(meta);
    }
}
