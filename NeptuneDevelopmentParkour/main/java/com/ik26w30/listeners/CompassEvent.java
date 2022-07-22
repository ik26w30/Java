package com.ik26w30.listeners;

import com.ik26w30.file.YamlParkour;
import com.ik26w30.file.YamlSpeedRun;
import com.ik26w30.utils.ColorUtil;
import com.ik26w30.utils.gui.InventoryCompass;
import com.ik26w30.utils.gui.InventoryParkour;
import com.ik26w30.utils.gui.InventorySpeedRun;
import com.ik26w30.utils.items.Items;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CompassEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        try {
            if (e.getItem().equals(Items.compassItem)) {
                InventoryCompass compass = new InventoryCompass();
                compass.openInv(e.getPlayer());
            }
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }

    }

    @EventHandler
    public void onInv(InventoryClickEvent e){
        ItemStack goldenApple = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta goldenAppleMeta = goldenApple.getItemMeta();
        goldenAppleMeta.setDisplayName("&3&lParkour");
        goldenApple.setItemMeta(goldenAppleMeta);

        //-------------//

        ItemStack apple = new ItemStack(Material.APPLE);
        ItemMeta appleMeta = apple.getItemMeta();
        appleMeta.setDisplayName("&9&lSpeedRun");
        apple.setItemMeta(appleMeta);
    try {

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.chat("&3&lParkour"))) {
            InventoryParkour parkour = new InventoryParkour();
            try {
                e.getWhoClicked().getOpenInventory().close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            parkour.openInv(e.getWhoClicked());
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.chat("&9&lSpeedRun"))) {
            InventorySpeedRun run = new InventorySpeedRun();
            try {
                e.getWhoClicked().getOpenInventory().close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            run.openInv(e.getWhoClicked());
        }
    }catch (NullPointerException ex){

    }

    try {
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.chat("&2&lFacile"))) {
            String world = YamlParkour.getParkourConfig().getString("Parkour.Facile.WorldName");
            double x = YamlParkour.getParkourConfig().getDouble("Parkour.Facile.X");
            double y = YamlParkour.getParkourConfig().getDouble("Parkour.Facile.Y");
            double z = YamlParkour.getParkourConfig().getDouble("Parkour.Facile.Z");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + e.getWhoClicked().getName() + " " + world);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.chat("&6&lMedio"))) {
            String world = YamlParkour.getParkourConfig().getString("Parkour.Medio.WorldName");
            double x = YamlParkour.getParkourConfig().getDouble("Parkour.Medio.X");
            double y = YamlParkour.getParkourConfig().getDouble("Parkour.Medio.Y");
            double z = YamlParkour.getParkourConfig().getDouble("Parkour.Medio.Z");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + e.getWhoClicked().getName() + " " + world);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.chat("&c&lDifficile"))) {
            String world = YamlParkour.getParkourConfig().getString("Parkour.Difficile.WorldName");
            double x = YamlParkour.getParkourConfig().getDouble("Parkour.Difficile.X");
            double y = YamlParkour.getParkourConfig().getDouble("Parkour.Difficile.Y");
            double z = YamlParkour.getParkourConfig().getDouble("Parkour.Difficile.Z");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + e.getWhoClicked().getName() + " " + world);
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.chat("&c&lParkour #1"))) {
            String world = YamlSpeedRun.getSpeedRunConfig().getString("Parkour.Primo.WorldName");
            double x = YamlSpeedRun.getSpeedRunConfig().getDouble("Parkour.Primo.X");
            double y = YamlSpeedRun.getSpeedRunConfig().getDouble("Parkour.Primo.Y");
            double z = YamlSpeedRun.getSpeedRunConfig().getDouble("Parkour.Primo.Z");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + e.getWhoClicked().getName() + " " + world);

        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.chat("&c&lParkour #2"))){
            String world = YamlSpeedRun.getSpeedRunConfig().getString("Parkour.Secondo.WorldName");
            double x = YamlSpeedRun.getSpeedRunConfig().getDouble("Parkour.Secondo.X");
            double y = YamlSpeedRun.getSpeedRunConfig().getDouble("Parkour.Secondo.Y");
            double z = YamlSpeedRun.getSpeedRunConfig().getDouble("Parkour.Secondo.Z");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + e.getWhoClicked().getName() + " " + world);

        }
    }catch (NullPointerException exc){

    }
        e.setCancelled(true);
    }
}