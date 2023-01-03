package org.ik26w30.practicecore.commands.kits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.ik26w30.practicecore.config.SetupConfig;

import java.util.ArrayList;
import java.util.List;

public class CreateKitCommand implements CommandExecutor {
    public final List<String> list = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Hi!");
            return true;
        }

        if(!(sender.hasPermission("createkit.admin"))){
            sender.sendMessage("§cYou don't have permissions to execute this command!");
            return true;
        }

        if(args.length == 1){
            String kitName = args[0];
            ConfigurationSection config = SetupConfig.getYaml().getConfigurationSection(kitName);
            if(kitName != null){
                if(!list.contains(args[0])){
                    PlayerInventory inventory = ((Player) sender).getInventory();
                    list.add(args[0]);
                    SetupConfig.getYaml().set(args[0] + ".name", args[0]);
                    SetupConfig.getYaml().set(args[0] + ".items", inventory.getContents());
                    SetupConfig.getYaml().set(args[0] + ".armor", inventory.getArmorContents());
                    SetupConfig.saveFile();
                }else {
                    sender.sendMessage("§cKit already exist");
                    return true;
                }
            }
        }else {
            sender.sendMessage("§cError: use /createkit [kit-name]");
            return true;
        }

        return false;
    }
}
