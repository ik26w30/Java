package com.ik26w30.file;

import com.ik26w30.Main;
import com.ik26w30.utils.exception.FolderCreateException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlMessages {
    private static File file = new File(Main.getInstance().getDataFolder(), "messages.yml");
    private static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    private void createFolder(){
        try {
            file.mkdir();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] Folder created!");
        }catch (FolderCreateException e){
            e.printStackTrace();
        }
    }

    private void createFile(){
        try {
            file.createNewFile();
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[NeptuneParkour] It's impossible to create messages.yml");
            e.printStackTrace();
        }
    }

    public static void reloadConfig(){
        config = YamlConfiguration.loadConfiguration(file);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] messages.yml succesfully reloaded!");
    }

    public void createData() {
        if(Main.getInstance().getDataFolder().exists()) {
            if (file.exists()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] Esiste sia la cartella che il file messages.yml");
            } else {
                createFile();
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] file messages.yml succesfully created!");
            }
        }else {
            createFolder();
            createFile();
        }
    }

    public FileConfiguration getConfig()
    {
        return config;
    }


}