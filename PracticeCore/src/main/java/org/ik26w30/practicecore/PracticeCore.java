package org.ik26w30.practicecore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.ik26w30.practicecore.commands.*;
import org.ik26w30.practicecore.commands.kits.CreateKitCommand;
import org.ik26w30.practicecore.commands.kits.KitEditorCommand;
import org.ik26w30.practicecore.config.arenaconfig.ArenaConfig;
import org.ik26w30.practicecore.config.kiteditorconfig.KitEditorConfig;
import org.ik26w30.practicecore.config.SetupConfig;
import org.ik26w30.practicecore.listeners.*;

public final class PracticeCore extends JavaPlugin {
    private static PracticeCore instance;

    @Override
    public void onLoad() {
        instance = this;
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        registerKitCommands();
        registerArenaCommands();
        registerStatsCommands();
        registerScoreBoardCommands();
        registerConfigCustom();
        registerArenaFile();
        registerKitEditorFile();
        registerKitEditorCommands();
        registerEvents();
        startup();
    }

    private void registerKitEditorFile() {
        KitEditorConfig.setupConfig();
        KitEditorConfig.customFile.addDefault("KitEditor", "");
        KitEditorConfig.customFile.options().copyDefaults(true);
        KitEditorConfig.saveFile();
    }

    private void registerArenaFile() {
        ArenaConfig.setupConfig();
        ArenaConfig.customFile.addDefault("Arena", "");
        ArenaConfig.customFile.options().copyDefaults(true);
        ArenaConfig.saveFile();
    }

    private void registerConfigCustom() {
        SetupConfig.setupConfig();
        SetupConfig.customFile.addDefault("Kits", "");
        SetupConfig.customFile.options().copyDefaults(true);
        SetupConfig.saveFile();
    }

    private void registerArenaCommands() {
        this.getCommand("createarena").setExecutor(new ArenaCreateCommand());
    }

    private void registerKitEditorCommands() {
        this.getCommand("kiteditor").setExecutor(new KitEditorCommand());
    }

    private void registerScoreBoardCommands() {
        this.getCommand("scoreboard").setExecutor(new ScoreBoardCommand());
    }

    private void registerStatsCommands() {
        this.getCommand("stats").setExecutor(new StatsCommand());
    }

    private void startup() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Plugin developed by @ik26w30");
    }

    private void registerKitCommands() {
        this.getCommand("createkit").setExecutor(new CreateKitCommand());
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        this.getServer().getPluginManager().registerEvents(new GameListener(), this);
        this.getServer().getPluginManager().registerEvents(new InteractListener(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        this.getServer().getPluginManager().registerEvents(new DropItemListener(), this);
        this.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
    }

    public static PracticeCore getInstance(){
        return instance;
    }
}
