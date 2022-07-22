package com.ik26w30.utils.gui;

import com.ik26w30.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryShop {
    private final Inventory inv;

    public InventoryShop() {
        inv = Bukkit.createInventory(null, 45, ColorUtil.chat("&9&lShop!"));
        init();
    }

    public void init(){
        inv.setItem(12, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 1, " "));
        inv.setItem(14, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 2, " "));
        inv.setItem(20, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 3, " "));
        inv.setItem(24, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 4, " "));
        inv.setItem(30, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 5, " "));
        inv.setItem(32, createGui(Material.STAINED_GLASS_PANE, 1, (byte) 6, " "));

        //MODALITY ITEM

        inv.setItem(22, createGui(Material.FEATHER, 1, (byte) 1, ColorUtil.chat("&3&lIn coming...")));
    }

    private ItemStack createGui(Material material, int amount, byte data, String name){
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
