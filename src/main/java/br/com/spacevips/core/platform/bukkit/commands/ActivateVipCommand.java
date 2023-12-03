package br.com.spacevips.core.platform.bukkit.commands;

import br.com.spacevips.core.platform.SpaceVips;
import br.com.spacevips.core.platform.bukkit.api.events.FireWorkAPI;
import br.com.spacevips.core.platform.bukkit.objects.PlayerOBJ;
import br.com.spacevips.core.platform.bukkit.utils.BukkitCommand;
import br.com.spacevips.core.platform.bukkit.utils.BukkitSender;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

import static br.com.spacevips.core.platform.SpaceVips.getPlayerManager;

public class ActivateVipCommand extends BukkitCommand {

    public ActivateVipCommand() {
        super("ativarvip");
        setAliases("activatevip");
    }

    @Override
    public boolean onExecute(BukkitSender commandSender, String label, String[] args) {
        if (commandSender.isPlayer()) {
            Player player = (Player) commandSender.getPlayer();

            if ((!player.hasPermission("spacevips.command.activatevip"))) {
                player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.msg-noPermission").replace("&", "§"));
            } else {

                if (args.length == 0) {
                    player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.usage-CommandActivateVip").replace("&", "§"));
                    return true;
                }
            }

                String vipType = args[0].toLowerCase();
                double chance = randomChance();
                PlayerOBJ po = getPlayerManager().getPlayer(player.getName());

                switch (vipType) {
                    case "diamond":
                        player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.activating-Vip").replace("&", "§"));
                        player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.activateVip-Diamond").replace("&", "§"));
                        po.setQuantidade(po.getQuantidade() + 1);

                        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                        String command1 = SpaceVips.getInstance().getConfig().getString("Vips.vip1.command-activatevip");
                        String commandReplaced = command1.replace("%player%", player.getName());
                        Bukkit.getServer().dispatchCommand(console, commandReplaced);

                        String commandReco = SpaceVips.getInstance().getConfig().getString("Vips.vip1.command-reward");
                        String commandReplaceReco = commandReco.replace("%player%", player.getName());
                        if (chance > 50) {
                            player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.reward-Received").replace("&", "§"));
                            Bukkit.getServer().dispatchCommand(console, commandReplaceReco);
                            FireWorkAPI.spawnFirework(player.getLocation(), Color.YELLOW, Color.RED, 1);
                            player.playEffect(player.getLocation(), Effect.HAPPY_VILLAGER, 0);
                        } else {
                            player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.reward-NotReceived").replace("&", "§"));
                        }
                        break;
                    case "gold":
                        player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.activating-Vip").replace("&", "§"));
                        player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.activateVip-Gold").replace("&", "§"));
                        po.setQuantidade(po.getQuantidade() + 1);

                        ConsoleCommandSender console2 = Bukkit.getServer().getConsoleSender();
                        String command2 = SpaceVips.getInstance().getConfig().getString("Vips.vip2.command-activatevip");
                        String commandReplaced2 = command2.replace("%player%", player.getName());
                        Bukkit.getServer().dispatchCommand(console2, commandReplaced2);

                        String commandReco2 = SpaceVips.getInstance().getConfig().getString("Vips.vip2.command-reward");
                        String commandReplaceReco2 = commandReco2.replace("%player%", player.getName());
                        if (chance > 50) {
                            player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.reward-Received").replace("&", "§"));
                            Bukkit.getServer().dispatchCommand(console2, commandReplaceReco2);
                            FireWorkAPI.spawnFirework(player.getLocation(), Color.YELLOW, Color.RED, 1);
                            player.playEffect(player.getLocation(), Effect.HAPPY_VILLAGER, 0);
                        } else {
                            player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.reward-NotReceived").replace("&", "§"));
                        }
                        break;
                    case "iron":
                        player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.activating-Vip").replace("&", "§"));
                        player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.activateVip-Iron").replace("&", "§"));
                        po.setQuantidade(po.getQuantidade() + 1);

                        ConsoleCommandSender console3 = Bukkit.getServer().getConsoleSender();
                        String command3 = SpaceVips.getInstance().getConfig().getString("Vips.vip3.command-activatevip");
                        String commandReplaced3 = command3.replace("%player%", player.getName());
                        Bukkit.getServer().dispatchCommand(console3, commandReplaced3);

                        String commandReco3 = SpaceVips.getInstance().getConfig().getString("Vips.vip3.command-reward");
                        String commandReplaceReco3 = commandReco3.replace("%player%", player.getName());
                        if (chance > 50) {
                            player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.reward-Received").replace("&", "§"));
                            Bukkit.getServer().dispatchCommand(console3, commandReplaceReco3);
                            FireWorkAPI.spawnFirework(player.getLocation(), Color.YELLOW, Color.RED, 1);
                            player.playEffect(player.getLocation(), Effect.HAPPY_VILLAGER, 0);
                        } else {
                            player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.reward-NotReceived").replace("&", "§"));
                        }
                        break;
                    default:
                        player.sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.vip-NotFound").replace("&", "§"));
                        break;
                }
            } else {
            Bukkit.getConsoleSender().sendMessage(SpaceVips.getInstance().getConfig().getString("Mensagens.command-NotPlayer").replace("&", "§"));
        }
        return true;
    }

    private double randomChance() {
        Random random = new Random();
        return random.nextDouble() * 100;
    }
}
