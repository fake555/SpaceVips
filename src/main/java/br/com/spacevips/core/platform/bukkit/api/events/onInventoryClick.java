package br.com.spacevips.core.platform.bukkit.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class onInventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!event.getView().getTitle().equals("Vips - Principal")) {
                return;
        }
        int slot = event.getSlot();
        event.setCancelled(true);
    }
}
