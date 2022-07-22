package com.ik26w30.listeners;

import com.ik26w30.utils.ColorUtil;
import com.ik26w30.utils.internet.Ping;
import com.ik26w30.utils.mysql.SQLTable;
import com.ik26w30.utils.scoreboard.ParkourScore;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        VisibilityPlayerInteract.getIsWaiting().put(e.getPlayer().getName(), false);

        e.getPlayer().setHealth(20);

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        LuckPerms luck = provider.getProvider();

        User user = luck.getPlayerAdapter(Player.class).getUser(e.getPlayer());

        String primaryGroup = ColorUtil.chat(user.getPrimaryGroup());
        String secondaryGroup = user.getCachedData().getMetaData().getPrefix();

        Ping ping = new Ping();

        for(Player p:Bukkit.getOnlinePlayers()){
            ParkourScore parkour = ParkourScore.createScore(e.getPlayer());
            parkour.setTitle("&9&lPARKOUR &7(&9" + Bukkit.getOnlinePlayers().size() + "&7)");
            parkour.setSlot(13, "&7&m--------------------------------");
            parkour.setSlot(12, "&9Player Name&f: " + e.getPlayer().getName());
            parkour.setSlot(11, "");
            parkour.setSlot(10, "&9Permission&f: " + primaryGroup);
            parkour.setSlot(9, "&9Rank&f: " + secondaryGroup);
            parkour.setSlot(8, "");
            parkour.setSlot(7, "&9Ping&f: " + ping.getPing(p.getPlayer()));
            parkour.setSlot(6, "");
            parkour.setSlot(5, "&9Parkour&f: " + e.getPlayer().getLocation().getWorld().getName());
            parkour.setSlot(4, "&9Tempo di gioco&f: 0 hour");
            parkour.setSlot(3, "");
            parkour.setSlot(2, "&7&m--------------------------------");
            parkour.setSlot(1, "&9&nplay.NeptuneMC.ga");
        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + e.getPlayer().getName() + " world");

        SQLTable.createTable(e.getPlayer().getName());
    }

}
