package com.ik26w30.utils.spawn;

import com.ik26w30.Main;
import com.ik26w30.listeners.ItemJoin;
import com.ik26w30.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UtilsSpawn extends Thread{

    public static void spawn(Player entity){

        final ItemStack paperItem = new ItemStack(Material.PAPER);
        final ItemMeta paperMeta = paperItem.getItemMeta();
        paperMeta.setDisplayName(ColorUtil.chat("&4&lBack to Spawn!"));
        paperItem.setItemMeta(paperMeta);

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + entity.getName() + " world");
        entity.getPlayer().sendMessage(ColorUtil.chat("&cYou succesfully back to spawn"));

    }

}
