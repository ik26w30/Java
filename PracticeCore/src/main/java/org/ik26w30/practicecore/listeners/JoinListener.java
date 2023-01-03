package org.ik26w30.practicecore.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.ik26w30.practicecore.utils.scoreboard.ScoreBoardUtils;

public class JoinListener implements Listener {
    private final ItemStack ranked = new ItemStack(Material.DIAMOND_SWORD);
    private final ItemMeta meta = ranked.getItemMeta();

    public final ItemStack unranked = new ItemStack(Material.STONE_SWORD);
    private final ItemMeta unrankedMeta = unranked.getItemMeta();

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        meta.setDisplayName("§bRanked");
        ranked.setItemMeta(meta);


        unrankedMeta.setDisplayName("§7Unranked");
        unranked.setItemMeta(unrankedMeta);
        ScoreBoardUtils scoreboard = new ScoreBoardUtils();
        scoreboard.setScoreBoard(event.getPlayer());
        event.getPlayer().getInventory().setItem(3, unranked);
        event.getPlayer().getInventory().setItem(5, ranked);
    }
}
