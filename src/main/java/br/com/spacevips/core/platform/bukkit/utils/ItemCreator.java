package br.com.spacevips.core.platform.bukkit.utils;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {

    @Getter
    private ItemStack itemStack;

    @Getter
    private ItemMeta itemMeta;

    public ItemCreator(Material material) {
        parse(new ItemStack(material));
    }

    private void parse(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemCreator setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemCreator setDisplayName(String displayName) {
        this.itemMeta.setDisplayName(displayName.replace("&", "§"));
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator setUnbreakable(boolean unbreakable) {
        this.itemMeta.spigot().setUnbreakable(unbreakable);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public String toBase64() {
        return null;
    }
}