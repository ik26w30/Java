package com.ik26w30;

import com.ik26w30.file.*;
import com.ik26w30.manager.CommandsManager;
import com.ik26w30.manager.ListenersManager;
import com.ik26w30.utils.mysql.SQLConnect;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        CommandsManager.regCommand();
        ListenersManager.regEvents();

        loadYaml();

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        SQLConnect sql = new SQLConnect();
        sql.createConnection();
    }

    private void loadYaml(){
        //locations parkour

        YamlParkour parkour = new YamlParkour();
        parkour.createData();

        //SPAWN LOCATIONS

        YamlSpawn spawn = new YamlSpawn();
        spawn.createData();

        //locations speedrun

        YamlSpeedRun speedRun = new YamlSpeedRun();
        speedRun.createData();

        //messages
/*
        YamlMessages mes = new YamlMessages();
        mes.createData();
*/

        YamlSql sql = new YamlSql();
        sql.createData();

    }

    public static Main getInstance()
    {
        return instance;
    }

}
