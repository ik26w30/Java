package com.ik26w30.listeners;

import com.ik26w30.utils.gui.InventoryShop;
import com.ik26w30.utils.items.Items;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ShopEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        try {

            if (e.getItem().equals(Items.bookItem)) {
                InventoryShop shop = new InventoryShop();
                shop.openInv(e.getPlayer());
            }
         }catch (NullPointerException ex){
            ex.printStackTrace();
        }

    }

}
