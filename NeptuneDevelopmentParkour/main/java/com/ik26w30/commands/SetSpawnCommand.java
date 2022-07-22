package com.ik26w30.commands;

import com.ik26w30.file.YamlParkour;
import com.ik26w30.file.YamlSpawn;
import com.ik26w30.utils.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(sender.hasPermission("admin.setpspawn")) {
                if (args.length == 0) {
                    if (YamlSpawn.getSpawnConfig().getString("Spawn.WorldName").equalsIgnoreCase("insert")) {
                        YamlSpawn.getSpawnConfig().set("Spawn.WorldName", ((Player) sender).getLocation().getWorld().getName());

                        YamlSpawn.getSpawnConfig().set("Spawn.X", ((Player) sender).getLocation().getX());
                        YamlSpawn.getSpawnConfig().set("Spawn.Y", ((Player) sender).getLocation().getY());
                        YamlSpawn.getSpawnConfig().set("Spawn.Z", ((Player) sender).getLocation().getZ());

                        try {
                            YamlSpawn.getSpawnConfig().save(YamlSpawn.getSpawnFile());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        sender.sendMessage(ColorUtil.chat("Spawn succesfully set!"));

                    } else {
                        sender.sendMessage(ColorUtil.chat("Spawn Already Set, use /delpspawn to delete the spawn!"));
                        return true;
                    }
                } else {
                    sender.sendMessage(ColorUtil.chat("&cUsage: /setspawn <no-args>"));
                    return true;
                }
            }else {
                sender.sendMessage(ColorUtil.chat("&cYou don't have permission to execute this command!"));
                return true;
            }
        }else {
            sender.sendMessage(ColorUtil.chat("&cPlease, don't execute this command by console!"));
            return true;
        }
        return false;
    }
}
