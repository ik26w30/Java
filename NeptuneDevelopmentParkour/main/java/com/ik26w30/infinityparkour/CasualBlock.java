package com.ik26w30.infinityparkour;

import com.ik26w30.utils.ColorUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class CasualBlock {

    public void firstRandomBlockToPlayer(Player p) {
        for(Material material : Material.values())
        {
            if(material.isBlock()) {
                World world = p.getWorld();
                double x = p.getLocation().getX();
                double y = p.getLocation().getY() + 10;
                double z = p.getLocation().getZ();
                Location location = new Location(world, x, y, z);
                try {
                    if (location.getBlock().isEmpty()) {
                        p.teleport(location);
                        location.getBlock().setType(material);
                    } else {
                        p.sendMessage(ColorUtil.chat("&cPlease change location"));
                    }
                }catch (Exception ignored){

                }
            }
        }
    }
}

