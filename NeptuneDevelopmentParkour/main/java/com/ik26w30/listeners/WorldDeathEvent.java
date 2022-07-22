package com.ik26w30.listeners;

import com.ik26w30.file.YamlSpawn;
import com.ik26w30.utils.items.Items;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class WorldDeathEvent implements Listener {

    @EventHandler
    public void onFallWorld(PlayerDeathEvent e){
        World world = e.getEntity().getWorld();
        double x = YamlSpawn.getSpawnConfig().getDouble("Spawn.X");
        double y = YamlSpawn.getSpawnConfig().getDouble("Spawn.Y");
        double z = YamlSpawn.getSpawnConfig().getDouble("Spawn.Z");
        Location loc = new Location(world, x, y ,z);
        e.getEntity().teleport(loc);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Items.setItems(e.getPlayer());
    }

}
