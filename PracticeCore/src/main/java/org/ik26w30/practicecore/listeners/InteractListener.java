package org.ik26w30.practicecore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.ik26w30.practicecore.PracticeCore;
import org.ik26w30.practicecore.config.arenaconfig.ArenaConfig;
import org.ik26w30.practicecore.utils.gui.KitGui;
import org.ik26w30.practicecore.utils.scoreboard.ScoreBoardUtils;

public class InteractListener implements Listener {
    public final ItemStack ranked = new ItemStack(Material.DIAMOND_SWORD);

    public final ItemStack unranked = new ItemStack(Material.STONE_SWORD);
    private final ItemMeta unrankedMeta = unranked.getItemMeta();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        ItemStack rose = new ItemStack(Material.RED_ROSE);
        ItemMeta meta = rose.getItemMeta();
        meta.setDisplayName("§cLeft");
        rose.setItemMeta(meta);
        ItemStack left = new ItemStack(new ItemStack(Material.RED_ROSE));
        left.setTypeId(1);
        ItemMeta leftMeta = left.getItemMeta();
        leftMeta.setDisplayName("§cLeft");
        left.setItemMeta(leftMeta);

        meta.setDisplayName("§bRanked");
        ranked.setItemMeta(meta);
        /*
        _____
         */

        unrankedMeta.setDisplayName("§7Unranked");
        unranked.setItemMeta(unrankedMeta);

        if (e.getPlayer().getWorld().getName().equalsIgnoreCase("world")) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                if (e.getMaterial() == Material.STONE_SWORD) {
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            Player player2 = e.getPlayer();
                            Location loc2 = new Location(player2.getWorld(), ArenaConfig.getYaml().getDouble("arena-1.get2X"), ArenaConfig.getYaml().getDouble("arena-1.get2Y"), ArenaConfig.getYaml().getDouble("arena-1.get2Z"));
                            Location location = new Location(player2.getWorld(), ArenaConfig.getYaml().getDouble("arena-1.getX"), ArenaConfig.getYaml().getDouble("arena-1.getY"), ArenaConfig.getYaml().getDouble("arena-1.getZ"));
                            e.getPlayer().getInventory().clear();
                            e.getPlayer().getInventory().setItem(4, rose);
                            KitGui ranked = new KitGui(e.getPlayer());
                            ranked.openUnranked();
                            // tpPlayerPosition(e.getPlayer(), ArenaConfig.getYaml().getDouble("arena-1.getX"), ArenaConfig.getYaml().getDouble("arena-1.getY"), ArenaConfig.getYaml().getDouble("arena-1.getZ"), location, player2, ArenaConfig.getYaml().getDouble("arena-1.get2X"), ArenaConfig.getYaml().getDouble("arena-1.get2Y"), ArenaConfig.getYaml().getDouble("arena-1.get2Z"), loc2);
                        }
                    }.runTaskLater(PracticeCore.getInstance(), 20);
                } else if (e.getMaterial() == Material.DIAMOND_SWORD) {
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            Location location = e.getPlayer().getLocation();
                            Player player2 = e.getPlayer();
                            Location loc2 = new Location(player2.getWorld(), ArenaConfig.getYaml().getDouble("arena-1.get2X"), ArenaConfig.getYaml().getDouble("arena-1.get2Y"), ArenaConfig.getYaml().getDouble("arena-1.get2Z"));
                            e.getPlayer().getInventory().clear();
                            e.getPlayer().getInventory().setItem(4, rose);
                            KitGui ranked = new KitGui(e.getPlayer());
                            ranked.openRanked();
                            //tpPlayerPosition(e.getPlayer(), ArenaConfig.getYaml().getDouble("arena-1.getX"), ArenaConfig.getYaml().getDouble("arena-1.getY"), ArenaConfig.getYaml().getDouble("arena-1.getZ"), location, player2, ArenaConfig.getYaml().getDouble("arena-1.get2X"), ArenaConfig.getYaml().getDouble("arena-1.get2Y"), ArenaConfig.getYaml().getDouble("arena-1.get2Z"), loc2);
                        }
                    }.runTaskLater(PracticeCore.getInstance(), 20);
                } else if (e.getMaterial() == Material.RED_ROSE) {
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            e.getPlayer().getInventory().clear();
                            e.getPlayer().getInventory().setItem(3, unranked);
                            e.getPlayer().getInventory().setItem(5, ranked);
                        }
                    }.runTaskLater(PracticeCore.getInstance(), 20);

                } else if (e.getMaterial() == null) {
                    e.setCancelled(true);
                } else {
                    ScoreBoardUtils update = new ScoreBoardUtils();
                    update.updateScore(e.getPlayer());
                }
            }
        }
    }

    private void tpPlayerPosition(Player player, double x1, double y1, double z1, Location location1, Player player2, double x2, double y2, double z2, Location loc2) {
        if (Bukkit.getOnlinePlayers().size() >= 2) {
            if (player.getInventory().getItem(4).getType().equals(Material.RED_ROSE) && ArenaConfig.getYaml().getString("arena-1") != null) {


                World world = player.getWorld();

                x1 = ArenaConfig.getYaml().getDouble("arena-1.getX");
                y1 = ArenaConfig.getYaml().getDouble("arena-1.getY");
                z1 = ArenaConfig.getYaml().getDouble("arena-1.getZ");

                location1 = new Location(world, x1, y1, z1);

                World world1 = player2.getWorld();

                x2 = ArenaConfig.getYaml().getDouble("arena-1.get2X");
                y2 = ArenaConfig.getYaml().getDouble("arena-1.get2Y");
                z2 = ArenaConfig.getYaml().getDouble("arena-1.get2Z");

                loc2 = new Location(world1, x2, y2, z2);

                player.teleport(location1);
                player2.teleport(loc2);
            }
        }else {
            player.sendMessage("§cSorry but onlineplayer equals two");
            return;
        }
    }
}
