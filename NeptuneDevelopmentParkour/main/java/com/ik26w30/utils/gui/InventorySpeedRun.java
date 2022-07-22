package com.ik26w30.utils.gui;

import com.ik26w30.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventorySpeedRun {
    private final Inventory inv;

    public InventorySpeedRun() {
        inv = Bukkit.createInventory(null, 45, ColorUtil.chat("&9&lSpeedRun!"));
        init();
    }

    public void init(){
        inv.setItem(12, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 2, " "));
        inv.setItem(14, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 2, " "));
        inv.setItem(20, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 2, " "));
        inv.setItem(22, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 2, " "));
        inv.setItem(24, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 2, " "));
        inv.setItem(30, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 2, " "));
        inv.setItem(32, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 2, " "));

        //MODALITY ITEM

        inv.setItem(21, createGui(Material.STAINED_CLAY, 1, (byte) 6, ColorUtil.chat("&c&lParkour #1")));
        inv.setItem(23, createGui(Material.STAINED_CLAY,1,(byte) 6,ColorUtil.chat("&c&lParkour #2")));
    }

    private ItemStack createGui(Material material,int amount, byte data, String name){
        ItemStack item = new ItemStack(material, amount, data);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);

        item.setItemMeta(meta);

        return item;
    }

    public void openInv(HumanEntity ent){
        ent.openInventory(inv);
    }

}
