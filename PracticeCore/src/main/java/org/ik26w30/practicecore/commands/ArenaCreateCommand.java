package org.ik26w30.practicecore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ik26w30.practicecore.config.arenaconfig.ArenaConfig;

import java.util.ArrayList;
import java.util.List;

public class ArenaCreateCommand implements CommandExecutor {
    public final List<String> list = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Hi");
            return true;
        }

        if(!(sender.hasPermission("createarena.admin"))){
            sender.sendMessage("§cYou don't have permissions to execute this command");
            return true;
        }

        if(args.length == 2){
            String arenaName = args[0];
            int spawnInt = Integer.parseInt(args[1]);
            if(arenaName != null){
                if(args[1].equalsIgnoreCase("1")){
                    Location location = ((Player) sender).getLocation();
                    list.add(args[0]);
                    location.setX(location.getX());
                    location.setY(location.getY());
                    location.setZ(location.getZ());
                    ArenaConfig.getYaml().set(args[0] + ".name", args[0]);
                    ArenaConfig.getYaml().set(args[0] + ".arena-name", location.getWorld().getName());
                    ArenaConfig.getYaml().set(args[0] + ".spawn-int-1", args[1]);
                    ArenaConfig.getYaml().set(args[0] + ".getX", location.getX());
                    ArenaConfig.getYaml().set(args[0] + ".getY", location.getY());
                    ArenaConfig.getYaml().set(args[0] + ".getZ", location.getZ());
                    ArenaConfig.saveFile();
                    sender.sendMessage("§cArena Succesfully Created");
            } else if(args[1].equalsIgnoreCase("2")){
                        Location location = ((Player) sender).getLocation();
                        list.add(args[0]);
                        location.setX(location.getX());
                        location.setY(location.getY());
                        location.setZ(location.getZ());
                        ArenaConfig.getYaml().set(args[0] + ".name", args[0]);
                        ArenaConfig.getYaml().set(args[0] + ".arena-name", location.getWorld().getName());
                        ArenaConfig.getYaml().set(args[0] + ".spawn-int-2", args[1]);
                        ArenaConfig.getYaml().set(args[0] + ".get2X", location.getX());
                        ArenaConfig.getYaml().set(args[0] + ".get2Y", location.getY());
                        ArenaConfig.getYaml().set(args[0] + ".get2Z", location.getZ());
                        ArenaConfig.saveFile();
                        sender.sendMessage("§cArena Succesfully Created");
                }else {
                    sender.sendMessage("§cError: use /createarena [arena-name] [spawn-int (1/2)]");
                    return true;
                }
            }
        }else {
            sender.sendMessage("§cError: use /createarena [arena-name] [spawn-int (1/2)]");
            return true;
        }

        return false;
    }
}
