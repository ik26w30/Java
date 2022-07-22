package com.ik26w30.commands;

import com.ik26w30.file.YamlSpawn;
import com.ik26w30.utils.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class DelSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(sender.hasPermission("admin.delpspawn")){
                if(args.length == 0){
                    if(!YamlSpawn.getSpawnConfig().getString("Spawn.WorldName").equalsIgnoreCase("SPAWN")){
                        YamlSpawn.getSpawnConfig().set("Spawn.WorldName", "insert");

                        YamlSpawn.getSpawnConfig().set("Spawn.X", "insert");
                        YamlSpawn.getSpawnConfig().set("Spawn.Y", "insert");
                        YamlSpawn.getSpawnConfig().set("Spawn.Z", "insert");

                        try {
                            YamlSpawn.getSpawnConfig().save(YamlSpawn.getSpawnFile());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        sender.sendMessage(ColorUtil.chat("Spawn succesfully deleted!"));
                    }
                }else {
                    sender.sendMessage(ColorUtil.chat("&cUsage: /delpspawn <no-args>"));
                    return true;
                }
            }else {
                sender.sendMessage(ColorUtil.chat("&cYou don't have permission to execute this command!"));
                return true;
            }
        }else {
            sender.sendMessage(ColorUtil.chat("&cYou can't execute this command by console!"));
            return true;
        }
        return false;
    }
}
