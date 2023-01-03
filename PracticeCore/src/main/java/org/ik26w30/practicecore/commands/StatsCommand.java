package org.ik26w30.practicecore.commands;

import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cHi!");
            return true;
        }

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e--------- &6&l> &b&lLake&3&lStats &6&l< &e--------"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e-"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e-"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e- &bWins: &3&l" + ((Player) sender).getStatistic(Statistic.PLAYER_KILLS)));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e-"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e-"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e- &6&l&bLoser: &3&l" + ((Player) sender).getStatistic(Statistic.DEATHS)));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e-"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e-"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e--------- &6&l> &b&lLake&3&lStats &6&l< &e--------"));
        return false;
    }
}
