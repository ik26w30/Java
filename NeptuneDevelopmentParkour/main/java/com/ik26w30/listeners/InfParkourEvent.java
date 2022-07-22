package com.ik26w30.listeners;

import com.ik26w30.infinityparkour.CasualBlock;
import com.ik26w30.utils.items.Items;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InfParkourEvent extends CasualBlock implements Listener {


    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        try {
            if (e.getItem().equals(Items.ladderItem)) {
                firstRandomBlockToPlayer(e.getPlayer());
            }
        } catch (NullPointerException ignored) {

        }
    }

}
