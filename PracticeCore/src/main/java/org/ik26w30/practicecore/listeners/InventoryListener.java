package org.ik26w30.practicecore.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.ik26w30.practicecore.config.SetupConfig;
import org.ik26w30.practicecore.config.arenaconfig.ArenaConfig;

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){

        if(event.getClickedInventory().getTitle().equals("§b§lRanked§3§lCrew")){
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§lNo§3§lDebuff")){
                SetupConfig.getYaml().getItemStack("nodebuff");
                event.getWhoClicked().closeInventory();
            }else if(event.getCurrentItem() == null){
                return;
            }
            event.setCancelled(true);
        }else if(event.getClickedInventory().getTitle().equals("§b§lUnRanked§3§lCrew")){
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals("§5§lNo§3§lDebuff")){
                event.getWhoClicked().sendMessage("FFFFFFFFFFFFFFFFFF");
            }
            event.setCancelled(true);
        }else if(event.getCurrentItem() == null){
            return;
        }

        event.setCancelled(true);
    }
}
