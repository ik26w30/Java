package org.ik26w30.practicecore.commands.kits;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ik26w30.practicecore.commands.kits.CreateKitCommand;
import org.ik26w30.practicecore.utils.gui.GuiClass;

public class KitEditorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cHi!");
            return true;
        }

        if(!(sender.hasPermission("kiteditor.vip"))){
            sender.sendMessage("§cYou don't have permissions to execute this commands!");
            return true;
        }

        if(args.length == 1){
            CreateKitCommand kitCommand = new CreateKitCommand();
            String kitName = args[0];
            if(kitName != null){
                if(kitCommand.list.contains(args[0])){
                    GuiClass gui = new GuiClass((Player) sender);
                    gui.open();
                }else {
                    sender.sendMessage("§cKit not exist!");
                    return true;
                }
            }
        }else {
            sender.sendMessage("§cError: use /kiteditor [kit-name]");
            return true;
        }
        return false;
    }
}
