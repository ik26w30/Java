package com.ik26w30.utils.internet;

import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class Ping {

    public int getPing(Player p) {
        int ping = 0;

        try {
            Object entityPlayer = p.getClass().getMethod("getHandle").invoke(p);
            ping = entityPlayer.getClass().getField("ping").getInt(entityPlayer);
        } catch (NoSuchFieldException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return ping;
    }
}
