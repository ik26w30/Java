package com.ik26w30.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlocksEvent implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        e.setCancelled(true);
    }
}
