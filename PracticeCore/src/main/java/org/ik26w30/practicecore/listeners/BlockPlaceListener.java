package org.ik26w30.practicecore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlace(BlockPlaceEvent event){
        event.setCancelled(true);
    }
}
