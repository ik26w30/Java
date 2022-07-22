package com.ik26w30.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherEvent implements Listener {

    @EventHandler
    public void onWeather(WeatherChangeEvent e){
        e.getWorld().setFullTime(0);
        e.setCancelled(true);
    }

}
