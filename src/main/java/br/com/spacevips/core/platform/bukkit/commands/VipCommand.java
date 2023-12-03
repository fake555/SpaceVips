package br.com.spacevips.core.platform.bukkit.commands;

import br.com.spacevips.core.platform.SpaceVips;
import br.com.spacevips.core.platform.bukkit.api.events.SkullBuilder;
import br.com.spacevips.core.platform.bukkit.utils.BukkitCommand;
import br.com.spacevips.core.platform.bukkit.utils.BukkitSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static br.com.spacevips.core.platform.SpaceVips.getPlayerManager;

public class VipCommand extends BukkitCommand {

    public VipCommand() {
        super("vip");
        setAliases("vipcommand");
    }

    @Override
    public boolean onExecute(BukkitSender commandSender, String label, String[] args) {
        if (commandSender.isPlayer()) {
            Player player = (Player) commandSender.getPlayer();

            if ((!player.hasPermission("spacevips.command.usevipcommand"))) {
                player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.msg-noPermission").replace("&", "§"));
            } else {

                Inventory vip = Bukkit.createInventory(null, 3 * 9, "Vips - Principal");
                ItemStack stats = new SkullBuilder(player.getName(), false)
                        .setDisplayName("§aSuas Informações")
                        .setLore("§aVocê ativou §7"+getPlayerManager().getPlayer(player.getName()).getQuantidade()+" §avips!")
                        .toItemStack();

                ItemMeta meta = stats.getItemMeta();
                stats.setItemMeta(meta);
                vip.setItem(10, stats);

                player.openInventory(vip);
                return true;
            }
            return true;
        } else {
            Bukkit.getConsoleSender().sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.command-NotPlayer").replace("&", "§"));
        }
        return true;
    }
}