package com.ik26w30.utils.scoreboard;

import com.ik26w30.utils.ColorUtil;
import com.ik26w30.utils.internet.Ping;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ParkourScore {

    private static final HashMap<UUID, ParkourScore> players = new HashMap<>();

    public static boolean hasScore(Player player) {
        return players.containsKey(player.getUniqueId());
    }

    public static ParkourScore createScore(Player player) {
        return new ParkourScore(player);
    }

    public static ParkourScore getByPlayer(Player player) {
        return players.get(player.getUniqueId());
    }

    public static ParkourScore removeScore(Player player) {
        return players.remove(player.getUniqueId());
    }

    private final Scoreboard scoreboard;
    private final Objective sidebar;

    private ParkourScore(Player player) {
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        sidebar = scoreboard.registerNewObjective("sidebar", "dummy");
        sidebar.setDisplaySlot(DisplaySlot.SIDEBAR);
        // Create Teams
        for(int i=1; i<=15; i++) {
            Team team = scoreboard.registerNewTeam("SLOT_" + i);
            team.addEntry(genEntry(i));
        }
        player.setScoreboard(scoreboard);
        players.put(player.getUniqueId(), this);
    }

    public void setTitle(String title) {
        title = ChatColor.translateAlternateColorCodes('&', title);
        sidebar.setDisplayName(title.length()>32 ? title.substring(0, 32) : title);
    }

    public void setSlot(int slot, String text) {
        Team team = scoreboard.getTeam("SLOT_" + slot);
        String entry = genEntry(slot);
        if(!scoreboard.getEntries().contains(entry)) {
            sidebar.getScore(entry).setScore(slot);
        }

        text = ChatColor.translateAlternateColorCodes('&', text);
        String pre = getFirstSplit(text);
        String suf = getFirstSplit(ChatColor.getLastColors(pre) + getSecondSplit(text));
        team.setPrefix(pre);
        team.setSuffix(suf);
    }

    public void removeSlot(int slot) {
        String entry = genEntry(slot);
        if(scoreboard.getEntries().contains(entry)) {
            scoreboard.resetScores(entry);
        }
    }

    public void setSlotsFromList(List<String> list) {
        while(list.size()>15) {
            list.remove(list.size()-1);
        }

        int slot = list.size();

        if(slot<15) {
            for(int i=(slot +1); i<=15; i++) {
                removeSlot(i);
            }
        }

        for(String line : list) {
            setSlot(slot, line);
            slot--;
        }
    }

    private String genEntry(int slot) {
        return ChatColor.values()[slot].toString();
    }

    private String getFirstSplit(String s) {
        return s.length()>16 ? s.substring(0, 16) : s;
    }

    private String getSecondSplit(String s) {
        if(s.length()>32) {
            s = s.substring(0, 32);
        }
        return s.length()>16 ? s.substring(16) : "";
    }

    public static void updateScore(Player player)
    {
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        LuckPerms luck = provider.getProvider();

        User user = luck.getPlayerAdapter(Player.class).getUser(player.getPlayer());

        String primaryGroup = ColorUtil.chat(user.getPrimaryGroup());
        String secondaryGroup = user.getCachedData().getMetaData().getPrefix();

        Ping ping = new Ping();

        ParkourScore parkour;

        for(Player p:Bukkit.getOnlinePlayers()){
            parkour = ParkourScore.createScore(player);
            parkour.setTitle("&9&lPARKOUR &7(&9" + Bukkit.getOnlinePlayers().size() + "&7)");
            parkour.setSlot(13, "&7&m--------------------------------");
            parkour.setSlot(12, "&9Player Name&f: " + player.getName());
            parkour.setSlot(11, "");
            parkour.setSlot(10, "&9Permission&f: " + primaryGroup);
            parkour.setSlot(9, "&9Rank&f: " + secondaryGroup);
            parkour.setSlot(8, "");
            parkour.setSlot(7, "&9Ping&f: " + ping.getPing(p.getPlayer()));
            parkour.setSlot(6, "");
            parkour.setSlot(5, "&9Parkour&f: " + player.getLocation().getWorld().getName());
            parkour.setSlot(4, "&9Tempo di gioco&f: 0 hour");
            parkour.setSlot(3, "");
            parkour.setSlot(2, "&7&m--------------------------------");
            parkour.setSlot(1, "&9&nplay.NeptuneMC.ga");
        }
    }
}

