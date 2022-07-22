package com.ik26w30.listeners;

import com.ik26w30.utils.scoreboard.ParkourScore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldEvent implements Listener {

    @EventHandler
    public void onWorldLoad(PlayerChangedWorldEvent e){
        ParkourScore score = ParkourScore.removeScore(e.getPlayer());
        ParkourScore.updateScore(e.getPlayer());
    }
}
