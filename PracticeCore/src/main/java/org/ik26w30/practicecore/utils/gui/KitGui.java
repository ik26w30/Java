package org.ik26w30.practicecore.utils.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitGui {
    private Player player;

    private final Inventory inventoryRanked = Bukkit.createInventory(null, 54, "§b§lRanked§3§lCrew");
    private final Inventory inventoryUnRanked = Bukkit.createInventory(null, 54, "§b§lUnRanked§3§lCrew");


    public KitGui(Player player) {
        this.player = player;
    }

    private ItemStack createGui(Material id, int amount, String displayName){
        ItemStack item = new ItemStack(id, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        item.setItemMeta(meta);

        return item;
    }

    public void openRanked(){
        inventoryRanked.setItem(0, createGui(Material.ENCHANTED_BOOK, 1 ,"§5§lNo§3§lDebuff"));
        this.player.openInventory(inventoryRanked);
    }

    public void openUnranked(){
        inventoryUnRanked.setItem(0, createGui(Material.ENCHANTED_BOOK, 1 ,"§5§lNo§3§lDebuff"));
        this.player.openInventory(inventoryUnRanked);
    }
}
