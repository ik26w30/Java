package com.ik26w30.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ItemLaunch implements Listener {

    @EventHandler
    public void onLaunch(ProjectileLaunchEvent e){
        e.setCancelled(true);
    }

}
