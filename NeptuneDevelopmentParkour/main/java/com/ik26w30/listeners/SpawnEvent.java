package com.ik26w30.listeners;

import com.ik26w30.utils.items.Items;
import com.ik26w30.utils.spawn.UtilsSpawn;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpawnEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        try {
            if (e.getItem().equals(Items.paperItem)) {
                UtilsSpawn.spawn(e.getPlayer());
            }
        }catch (NullPointerException ex){

        }


/*
        try {
            if (e.getItem().equals(paperItem)) {
                try {
                    if(join.getIsWaitingSpawn().get(e.getPlayer().getName())){
                        return;
                    }else {
                        UtilsSpawn.spawn(e.getPlayer());
                        join.getIsWaitingSpawn().put(e.getPlayer().getName(), true);
                    }
                }catch (NullPointerException ex1){
                    e.getPlayer().sendMessage(ColorUtil.chat("&cThere is a problem, try again!"));
                    join.getIsWaitingSpawn().put(e.getPlayer().getName(), false);
                }
            }
        }catch (NullPointerException ex){

        }
*/
    }

}
