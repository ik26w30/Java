package com.ik26w30.listeners;

import com.ik26w30.infinityparkour.utils.Random;
import com.ik26w30.utils.items.Items;
import com.ik26w30.utils.mysql.SQLConnect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ItemJoin extends Random implements Listener
{
    private final SQLConnect sql = new SQLConnect();


    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Items.setItems(e.getPlayer());
    }

}
