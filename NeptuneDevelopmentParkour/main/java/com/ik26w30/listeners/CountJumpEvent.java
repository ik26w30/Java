package com.ik26w30.listeners;

import com.ik26w30.utils.mysql.SQLTable;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class CountJumpEvent implements Listener {
    @EventHandler
    public void onJump(PlayerMoveEvent e){
        Location from = e.getFrom();
        Location to = e.getTo();
        Player player = e.getPlayer();
/*
        if (from.getBlockY() < to.getBlockY() && !player.isFlying())
        {
            try {
                int i = Integer.parseInt(SQLTable.getInfo("jumps", e.getPlayer().getName()));
                SQLTable.insertTable("jumps", e.getPlayer().getName(), i+1);
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }
        }
*/
    }

}
