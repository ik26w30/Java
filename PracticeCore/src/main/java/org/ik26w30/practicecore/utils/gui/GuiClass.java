package org.ik26w30.practicecore.utils.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GuiClass {
    private final Player player;
    private final Inventory inventory = Bukkit.createInventory(null, 27, "§b§lKit§3§lEditor");
    public GuiClass(Player player) {
        this.player = player;
    }

    public ItemStack createInv(Material id, int amount, List<String> lore, String display){
        ItemStack item = new ItemStack(id, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(display);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public void open(){
        this.player.openInventory(inventory);
    }
}
