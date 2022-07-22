package com.ik26w30.file;

import com.ik26w30.Main;
import com.ik26w30.utils.exception.FolderCreateException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlSpawn {

    private static final File spawnFile = new File(Main.getInstance().getDataFolder(), "spawn.yml");
    private static FileConfiguration spawnConfig = YamlConfiguration.loadConfiguration(spawnFile);


    private void createFolder(){
        try {
            spawnFile.mkdir();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] Folder created!");
        }catch (FolderCreateException e){
            e.printStackTrace();
        }
    }

    private void createFile(){
        try {
            spawnFile.createNewFile();
            spawnConfig.set("Spawn.WorldName", "insert");
            spawnConfig.set("Spawn.X", "insert");
            spawnConfig.set("Spawn.Y", "insert");
            spawnConfig.set("Spawn.Z", "insert");
            spawnConfig.save(spawnFile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[NeptuneParkour] It's impossible to create file spawn.yml");
            e.printStackTrace();
        }
    }

    public static void reloadConfig(){
        spawnConfig = YamlConfiguration.loadConfiguration(spawnFile);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] file spawn.yml succesfully reloaded!");
    }

    public void createData() {
        if(Main.getInstance().getDataFolder().exists()) {
            if (spawnFile.exists()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] Esiste sia la cartella che il file spawn.yml");
            } else {
                createFile();
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] file spawn.yml succesfully created!");
            }
        }else {
            createFolder();
            createFile();
        }
    }

    public static FileConfiguration getSpawnConfig(){
        return spawnConfig;
    }

    public static File getSpawnFile(){
        return spawnFile;
    }

}
