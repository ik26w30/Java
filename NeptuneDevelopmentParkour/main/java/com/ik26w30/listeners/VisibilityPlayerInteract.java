package com.ik26w30.listeners;

import com.ik26w30.utils.ColorUtil;
import com.ik26w30.utils.eyeofender.PlayerVisibility;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class VisibilityPlayerInteract implements Listener
{
    private static final HashMap<String, Boolean> isWaiting = new HashMap<>();

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        Player p = e.getPlayer();

        final ItemStack ende = new ItemStack(Material.INK_SACK, 1, DyeColor.GRAY.getDyeData());
        final ItemMeta endeMeta = ende.getItemMeta();
        endeMeta.setDisplayName(ColorUtil.chat("&3&lPLAYER OFF!"));
        ende.setItemMeta(endeMeta);

        final ItemStack eye = new ItemStack(Material.INK_SACK, 1, DyeColor.MAGENTA.getDyeData());
        final ItemMeta eyeMeta = eye.getItemMeta();
        eyeMeta.setDisplayName(ColorUtil.chat("&3&lPLAYER ON!"));
        eye.setItemMeta(eyeMeta);


    try {
        if (e.getItem().equals(eye)) {
            try {
                if (isWaiting.get(e.getPlayer().getName())) {
                    return;
                } else {
                    PlayerVisibility.playerOff(p);
                    isWaiting.put(e.getPlayer().getName(), true);
                }
            } catch (NullPointerException ex) {
                e.getPlayer().sendMessage(ColorUtil.chat("&cThere is a problem, try again!"));
                isWaiting.put(e.getPlayer().getName(), false);
            }

        }
    }catch (NullPointerException ex){

    }

    try {
        if (e.getItem().equals(ende)) {
            try {
                if (isWaiting.get(e.getPlayer().getName())) {
                    return;
                } else {
                    PlayerVisibility.playerOn(p);
                    isWaiting.put(e.getPlayer().getName(), true);
                }
            } catch (NullPointerException ex) {
                e.getPlayer().sendMessage(ColorUtil.chat("&cThere is a problem, try again!"));
                isWaiting.put(e.getPlayer().getName(), false);
            }

        }
    }catch (NullPointerException ex){

    }

}

    public static HashMap<String, Boolean> getIsWaiting() {
        return isWaiting;
    }

}
