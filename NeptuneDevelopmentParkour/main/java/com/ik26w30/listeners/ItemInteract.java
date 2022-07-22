package com.ik26w30.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemInteract implements Listener
{

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrag(InventoryDragEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onItem(InventoryMoveItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) { e.setCancelled(true); }

}
