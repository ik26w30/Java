package com.ik26w30.utils.items;

import com.ik26w30.utils.ColorUtil;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
    public static final ItemStack compassItem = new ItemStack(Material.COMPASS);
    public static final ItemMeta compassMeta = compassItem.getItemMeta();

    public static final ItemStack bookItem = new ItemStack(Material.ENCHANTED_BOOK);
    public static final ItemMeta bookMeta = bookItem.getItemMeta();

    public static final ItemStack ladderItem = new ItemStack(Material.LADDER);
    public static final ItemMeta ladderMeta = ladderItem.getItemMeta();

    public static final ItemStack eyeItem = new ItemStack(Material.INK_SACK, 1, DyeColor.MAGENTA.getDyeData());
    public static final ItemMeta eyeMeta = eyeItem.getItemMeta();

    public static final ItemStack paperItem = new ItemStack(Material.PAPER);
    public static final ItemMeta paperMeta = paperItem.getItemMeta();

    public static final ItemStack bedItem = new ItemStack(Material.BED);
    public static final ItemMeta bedMeta = bedItem.getItemMeta();


    public static void setItems(Player p){
        //clear inventory when he join to set items againg :)) //ik26w30 on top!
        p.getInventory().clear();

        //compass item

        compassMeta.setDisplayName(ColorUtil.chat("&5&lSelect a modality!"));
        compassItem.setItemMeta(compassMeta);

        p.getInventory().setItem(0, compassItem);

        // BOOK ITEM //


        bookMeta.setDisplayName(ColorUtil.chat("&1&lShop!"));
        bookItem.setItemMeta(bookMeta);

        p.getInventory().setItem(1, bookItem);

        // LADDER ITEM //


        ladderMeta.setDisplayName(ColorUtil.chat("&2&lInfinite Parkour!"));
        ladderItem.setItemMeta(ladderMeta);

        p.getInventory().setItem(2, ladderItem);

        //   EYE OF ENDER ITEM   //


        eyeMeta.setDisplayName(ColorUtil.chat("&3&lPLAYER ON!"));
        eyeItem.setItemMeta(eyeMeta);

        p.getInventory().setItem(6, eyeItem);

        // PAPER ITEM //


        paperMeta.setDisplayName(ColorUtil.chat("&4&lBack to Spawn!"));
        paperItem.setItemMeta(paperMeta);

        p.getInventory().setItem(7, paperItem);

        // BED ITEM //


        bedMeta.setDisplayName(ColorUtil.chat("&6&lBack to Hub!"));
        bedItem.setItemMeta(bedMeta);

        p.getInventory().setItem(8, bedItem);
    }

}
