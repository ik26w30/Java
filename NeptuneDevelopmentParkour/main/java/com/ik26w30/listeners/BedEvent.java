package com.ik26w30.listeners;

import com.ik26w30.utils.ColorUtil;
import com.ik26w30.utils.connection.ConnectServer;
import com.ik26w30.utils.gui.InventoryCompass;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BedEvent implements Listener {


    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        final ItemStack bedItem = new ItemStack(Material.BED);
        final ItemMeta bedMeta = bedItem.getItemMeta();
        bedMeta.setDisplayName(ColorUtil.chat("&6&lBack to Hub!"));
        bedItem.setItemMeta(bedMeta);
        try {
            if (e.getItem().equals(bedItem)) {
                ConnectServer.teleportServer(e.getPlayer(), "lobby");
            }
        }catch (NullPointerException ex){

        }
    }
}