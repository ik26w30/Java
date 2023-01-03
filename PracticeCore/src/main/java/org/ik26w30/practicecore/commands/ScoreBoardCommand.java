package org.ik26w30.practicecore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ik26w30.practicecore.utils.scoreboard.ScoreBoardUtils;

public class ScoreBoardCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Hi console! You can't execute this command");
            return true;
        }

        if(args.length == 1){
            ScoreBoardUtils scoreboard = new ScoreBoardUtils();
            if(args[0].equalsIgnoreCase("on")){
                scoreboard.setScoreBoard((Player) sender);
            }else if(args[0].equalsIgnoreCase("off")) {
                ((Player) sender).setScoreboard(scoreboard.board);
            }else {
                sender.sendMessage("§cError: use /scoreboard <on/off>");
                return true;
            }
        }else {
            sender.sendMessage("§cError: use /scoreboard <on/off>");
            return true;
        }

        return false;
    }
}
