package org.ik26w30.practicecore.config.kiteditorconfig;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.ik26w30.practicecore.PracticeCore;

import java.io.File;
import java.io.IOException;

public class KitEditorConfig {
    private static File file = new File(PracticeCore.getInstance().getDataFolder(), "kiteditor.yml");
    public static FileConfiguration customFile = (FileConfiguration) YamlConfiguration.loadConfiguration(file);

    public static void setupConfig(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                //
            }
        }
    }

    public static FileConfiguration getYaml(){
        return customFile;
    }

    public static void saveFile(){
        try {
            customFile.save(file);
        } catch (IOException e) {
            //
        }
    }

    public static void reloadFile(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
