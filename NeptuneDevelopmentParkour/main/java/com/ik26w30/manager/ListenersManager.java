package com.ik26w30.manager;

import com.ik26w30.Main;
import com.ik26w30.listeners.*;

public class ListenersManager {

    public static void regEvents(){
        Main.getInstance().getServer().getPluginManager().registerEvents(new ItemJoin(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new ItemLaunch(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new VisibilityPlayerInteract(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new ItemInteract(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new FoodEvent(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new BlocksEvent(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new WorldDeathEvent(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new CompassEvent(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new SpawnEvent(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new BedEvent(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new ShopEvent(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new CountJumpEvent(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new WeatherEvent(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new WorldEvent(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new PlayerJoin(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new InfParkourEvent(), Main.getInstance());
        //Main.getInstance().getServer().getPluginManager().registerEvents(new BlockInteract(), Main.getInstance());
    }

}
