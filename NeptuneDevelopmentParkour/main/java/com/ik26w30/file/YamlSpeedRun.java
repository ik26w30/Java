package com.ik26w30.file;

import com.ik26w30.Main;
import com.ik26w30.utils.exception.FolderCreateException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlSpeedRun {
    private static final File speedRunFile = new File(Main.getInstance().getDataFolder(), "speedrun.yml");
    private static FileConfiguration speedRunConfig = YamlConfiguration.loadConfiguration(speedRunFile);


    private void createFolder(){
        try {
            speedRunFile.mkdir();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] Folder created!");
        }catch (FolderCreateException e){
            e.printStackTrace();
        }
    }

    private void createFile(){
        try {
            speedRunFile.createNewFile();

            //PRIMO

            speedRunConfig.set("Parkour.Primo.WorldName", "insert");
            speedRunConfig.set("Parkour.Primo.X", "insert");
            speedRunConfig.set("Parkour.Primo.Y", "insert");
            speedRunConfig.set("Parkour.Primo.Z", "insert");


            //SECONDO

            speedRunConfig.set("Parkour.Secondo.WorldName", "insert");
            speedRunConfig.set("Parkour.Secondo.X", "insert");
            speedRunConfig.set("Parkour.Secondo.Y", "insert");
            speedRunConfig.set("Parkour.Secondo.Z", "insert");
            speedRunConfig.save(speedRunFile);

        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[NeptuneParkour] It's impossible to create file speedrun.yml");
            e.printStackTrace();
        }
    }

    public static void reloadConfig(){
        speedRunConfig = YamlConfiguration.loadConfiguration(speedRunFile);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] file speedrun.yml succesfully reloaded!");
    }

    public void createData() {
        if(Main.getInstance().getDataFolder().exists()) {
            if (speedRunFile.exists()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] Esiste sia la cartella che il file speedrun.yml");
            } else {
                createFile();
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] file speedrun.yml succesfully created!");
            }
        }else {
            createFolder();
            createFile();
        }
    }


    public static FileConfiguration getSpeedRunConfig(){
        return speedRunConfig;
    }

    public static File getSpeedRunFile(){
        return speedRunFile;
    }


}
