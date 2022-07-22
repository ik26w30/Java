package com.ik26w30.utils.eyeofender;

import com.ik26w30.Main;
import com.ik26w30.listeners.VisibilityPlayerInteract;
import com.ik26w30.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;


public class PlayerVisibility extends Thread {
    public static void playerOff(Player entity) {
        for (Player players : Bukkit.getOnlinePlayers()) {

            // ATTENDERE 5 SECONDI PER AVERE LA RIATTIVAZIONE DEI PLAYERS  //

            entity.sendMessage(ColorUtil.chat("&cWait 5 seconds"));

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    entity.sendMessage(ColorUtil.chat("&cWait 4 seconds"));
                }
            },20);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    entity.sendMessage(ColorUtil.chat("&cWait 3 seconds"));
                }
            },40);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    entity.sendMessage(ColorUtil.chat("&cWait 2 seconds"));
                }
            },60);


            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    entity.sendMessage(ColorUtil.chat("&cWait 1 seconds"));
                }
            },80);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {

                    final ItemStack ende = new ItemStack(Material.INK_SACK, 1, DyeColor.GRAY.getDyeData());
                    final ItemMeta endeMeta = ende.getItemMeta();
                    endeMeta.setDisplayName(ColorUtil.chat("&3&lPLAYER OFF!"));
                    ende.setItemMeta(endeMeta);

                    entity.hidePlayer(players);
                    entity.sendMessage(ColorUtil.chat("&cYou can't see any players now!"));
                    //entity.getInventory().setItem(6, ende);
                    entity.getInventory().setItem(6, ende);
                    VisibilityPlayerInteract.getIsWaiting().put(entity.getName(), false);
                }

            }, 100L);

        }

    }

    public static void playerOn(Player entity) {
        for (Player players : Bukkit.getOnlinePlayers()) {

            // ATTENDERE 5 SECONDI PER AVERE LA DISATTIVAZIONE DEI PLAYERS  //


            entity.sendMessage(ColorUtil.chat("&cWait 5 seconds"));

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    entity.sendMessage(ColorUtil.chat("&cWait 4 seconds"));
                }
            },20);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    entity.sendMessage(ColorUtil.chat("&cWait 3 seconds"));
                }
            },40);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    entity.sendMessage(ColorUtil.chat("&cWait 2 seconds"));
                }
            },60);


            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    entity.sendMessage(ColorUtil.chat("&cWait 1 seconds"));
                }
            },80);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new BukkitRunnable() {
                @Override
                public void run() {
                    final ItemStack eye = new ItemStack(Material.INK_SACK, 1, DyeColor.MAGENTA.getDyeData());
                    final ItemMeta eyeMeta = eye.getItemMeta();
                    eyeMeta.setDisplayName(ColorUtil.chat("&3&lPLAYER ON!"));
                    eye.setItemMeta(eyeMeta);

                    entity.showPlayer(players);
                    entity.sendMessage(ColorUtil.chat("&cYou can see all players now"));
                    //entity.getInventory().setItem(6, eye);
                    entity.getInventory().setItem(6, eye);
                    VisibilityPlayerInteract.getIsWaiting().put(entity.getName(), false);
                }
            }, 100L);
        }
    }
}
