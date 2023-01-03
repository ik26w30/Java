package org.ik26w30.practicecore.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.ik26w30.practicecore.utils.scoreboard.ScoreBoardUtils;

import java.util.HashMap;
import java.util.UUID;

public class DeathEvent implements Listener {
    private final HashMap<UUID, Integer> deathsMap = new HashMap<UUID, Integer>();

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        ScoreBoardUtils scoreboard = new ScoreBoardUtils();
        scoreboard.updateScore(
                event.getPlayer()
        );

        ItemStack ranked = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = ranked.getItemMeta();
        meta.setDisplayName("§bRanked");
        ranked.setItemMeta(meta);
        /*
        _____
         */

        ItemStack unranked = new ItemStack(Material.STONE_SWORD);
        ItemMeta unrankedMeta = unranked.getItemMeta();
        unrankedMeta.setDisplayName("§7Unranked");
        unranked.setItemMeta(unrankedMeta);
        scoreboard.setScoreBoard(event.getPlayer());
        event.getPlayer().getInventory().setItem(3, unranked);
        event.getPlayer().getInventory().setItem(5, ranked);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player loser = event.getEntity();
        Player winner = event.getEntity().getKiller();

        ScoreBoardUtils scoreboard = new ScoreBoardUtils();

        loser.sendMessage("§e--------- §6§l> §b§lLake§3§lOver §6§l< §e--------");
        loser.sendMessage("§e-");
        loser.sendMessage("§e- §bWinner: §3§l" + winner.getName());
        loser.sendMessage("§e-");
        loser.sendMessage("§e- §bLoser: §3§l" + loser.getName());
        loser.sendMessage("§e-");
        loser.sendMessage("§e--------- §6§l> §b§lLake§3§lOver §6§l< §e--------");
        scoreboard.updateScore(loser);
        /*
        Send Message of end the game at winner and Loser
         */
        winner.sendMessage("§e--------- §6§l> §b§lLake§3§lWin §6§l< §e--------");
        winner.sendMessage("§e-");
        winner.sendMessage("§e- §bWinner: §3§l" + winner.getName());
        winner.sendMessage("§e-");
        winner.sendMessage("§e- §bLoser: §3§l" + loser.getName());
        winner.sendMessage("§e-");
        winner.sendMessage("§e--------- §6§l> §b§lLake§3§lOver §6§l< §e--------");
        scoreboard.updateScore(winner);
    }
}
