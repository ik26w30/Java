package com.ik26w30.file;

import com.ik26w30.Main;
import com.ik26w30.utils.exception.FolderCreateException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlSql {

    private static final File sql = new File(Main.getInstance().getDataFolder(), "mysql.yml");
    private static FileConfiguration sqlConf = YamlConfiguration.loadConfiguration(sql);


    private void createFolder(){
        try {
            sql.mkdir();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] Folder created!");
        }catch (FolderCreateException e){
            e.printStackTrace();
        }
    }

    private void createFile(){
        try {
            sql.createNewFile();

            //PRIMO

            sqlConf.set("IP", "insert");
            sqlConf.set("User", "insert");
            sqlConf.set("DBName", "insert");
            sqlConf.set("Pssw","insert");
            sqlConf.save(sql);

        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[NeptuneParkour] It's impossible to create file mysql.yml");
            e.printStackTrace();
        }
    }

    public static void reloadConfig(){
        sqlConf = YamlConfiguration.loadConfiguration(sql);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] file mysql.yml succesfully reloaded!");
    }

    public void createData() {
        if(Main.getInstance().getDataFolder().exists()) {
            if (sql.exists()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] Esiste sia la cartella che il file mysql.yml");
            } else {
                createFile();
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneParkour] file mysql.yml succesfully created!");
            }
        }else {
            createFolder();
            createFile();
        }
    }


    public static FileConfiguration getSqlConf(){
        return sqlConf;
    }

    public static File getSql(){
        return sql;
    }

}
