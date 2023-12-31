package br.com.spacevips.core.platform.bukkit.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerQuantityVipsActivatesPlaceHolder extends PlaceholderExpansion {


    @Override
    public @NotNull String getIdentifier() {
        return null;
    }

    @Override
    public @NotNull String getAuthor() {
        return "fake555";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String params) {
        if (params.equalsIgnoreCase("quantity")) {
            // Aqui você pode implementar a lógica para obter a quantidade desejada de jogadores
            return "100";
        }
        return null;
    }
}
