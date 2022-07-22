package com.ik26w30.file;

import com.ik26w30.Main;
import com.ik26w30.utils.exception.FolderCreateException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;


public class YamlParkour {
    private static final File parkurFile = new File(Main.getInstance().getDataFolder(), "parkour.yml");
    private static FileConfiguration parkourConfig = YamlConfiguration.loadConfiguration(parkurFile);


    private void createFolder(){
        try {
            parkurFile.mkdir();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] Folder created!");
        }catch (FolderCreateException e){
            e.printStackTrace();
        }
    }

    private void createFile(){
        try {
            parkurFile.createNewFile();

            //FACILE

            parkourConfig.set("Parkour.Facile.WorldName", "insert");
            parkourConfig.set("Parkour.Facile.X", "insert");
            parkourConfig.set("Parkour.Facile.Y", "insert");
            parkourConfig.set("Parkour.Facile.Z", "insert");

            // MEDIO

            parkourConfig.set("Parkour.Medio.WorldName", "insert");
            parkourConfig.set("Parkour.Medio.X", "insert");
            parkourConfig.set("Parkour.Medio.Y", "insert");
            parkourConfig.set("Parkour.Medio.Z", "insert");

            // DIFFICILE

            parkourConfig.set("Parkour.Difficile.WorldName", "insert");
            parkourConfig.set("Parkour.Difficile.X", "insert");
            parkourConfig.set("Parkour.Difficile.Y", "insert");
            parkourConfig.set("Parkour.Difficile.Z", "insert");

            parkourConfig.save(parkurFile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[NeptuneParkour] It's impossible to create file parkour.yml");
            e.printStackTrace();
        }
    }

    public static void reloadConfig(){
        parkourConfig = YamlConfiguration.loadConfiguration(parkurFile);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] file parkour.yml succesfully reloaded!");
    }

    public void createData() {
        if(Main.getInstance().getDataFolder().exists()) {
            if (parkurFile.exists()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] Esiste sia la cartella che il file parkour.yml");
            } else {
                createFile();
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] file parkour.yml succesfully created!");
            }
        }else {
            createFolder();
            createFile();
        }
    }

    public static FileConfiguration getParkourConfig(){
        return parkourConfig;
    }

    public static File getParkourFile(){
        return parkurFile;
    }


}