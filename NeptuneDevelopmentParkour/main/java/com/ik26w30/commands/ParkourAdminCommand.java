package com.ik26w30.commands;

import com.ik26w30.file.YamlParkour;
import com.ik26w30.file.YamlSpeedRun;
import com.ik26w30.utils.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ParkourAdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if(sender.hasPermission("admin.parkour")){
                if(args.length == 3){
                    if(args[0].equalsIgnoreCase("setmap")){
                        if(args[1].equalsIgnoreCase("parkour")){
                            if(args[2].equalsIgnoreCase("facile")){
                                if (YamlParkour.getParkourConfig().getString("Parkour.Facile.WorldName").equals("insert")) {
                                    YamlParkour.getParkourConfig().set("Parkour.Facile.WorldName", ((Player) sender).getLocation().getWorld().getName());
                                    YamlParkour.getParkourConfig().set("Parkour.Facile.X", ((Player) sender).getLocation().getX());
                                    YamlParkour.getParkourConfig().set("Parkour.Facile.Y", ((Player) sender).getLocation().getY());
                                    YamlParkour.getParkourConfig().set("Parkour.Facile.Z", ((Player) sender).getLocation().getZ());

                                    try {
                                        YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    sender.sendMessage(ColorUtil.chat("&cMap setted!"));

                                } else {
                                    sender.sendMessage(ColorUtil.chat("&cMap already set, please delete the map using /delmap"));
                                    return true;
                                }
                            }else if(args[2].equalsIgnoreCase("medio")){
                                if (YamlParkour.getParkourConfig().getString("Parkour.Medio.WorldName").equals("insert")) {
                                    YamlParkour.getParkourConfig().set("Parkour.Medio.WorldName", ((Player) sender).getLocation().getWorld().getName());
                                    YamlParkour.getParkourConfig().set("Parkour.Medio.X", ((Player) sender).getLocation().getX());
                                    YamlParkour.getParkourConfig().set("Parkour.Medio.Y", ((Player) sender).getLocation().getY());
                                    YamlParkour.getParkourConfig().set("Parkour.Medio.Z", ((Player) sender).getLocation().getZ());

                                    try {
                                        YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    sender.sendMessage(ColorUtil.chat("&cMap setted!"));

                                } else {
                                    sender.sendMessage(ColorUtil.chat("&cMap already set, please delete the map using /delmap"));
                                    return true;
                                }
                            }else if(args[2].equalsIgnoreCase("difficile")){
                                if (YamlParkour.getParkourConfig().getString("Parkour.Difficile.WorldName").equals("insert")) {
                                    YamlParkour.getParkourConfig().set("Parkour.Difficile.WorldName", ((Player) sender).getLocation().getWorld().getName());
                                    YamlParkour.getParkourConfig().set("Parkour.Difficile.X", ((Player) sender).getLocation().getX());
                                    YamlParkour.getParkourConfig().set("Parkour.Difficile.Y", ((Player) sender).getLocation().getY());
                                    YamlParkour.getParkourConfig().set("Parkour.Difficile.Z", ((Player) sender).getLocation().getZ());

                                    try {
                                        YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    sender.sendMessage(ColorUtil.chat("&cMap setted!"));

                                } else {
                                    sender.sendMessage(ColorUtil.chat("&cMap already set, please delete the map using /delmap"));
                                    return true;
                                }
                            }else {
                                sender.sendMessage(ColorUtil.chat("&cYou have to choose btw facile/medio/difficile"));
                                return true;
                            }
                        }else if(args[1].equalsIgnoreCase("speedrun")){
                            if(args[2].equalsIgnoreCase("1")){
                                if (YamlSpeedRun.getSpeedRunConfig().getString("Parkour.Primo.WorldName").equals("insert")) {
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.WorldName", ((Player) sender).getLocation().getWorld().getName());
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.X", ((Player) sender).getLocation().getX());
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.Y", ((Player) sender).getLocation().getY());
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.Z", ((Player) sender).getLocation().getZ());

                                    try {
                                        YamlSpeedRun.getSpeedRunConfig().save(YamlSpeedRun.getSpeedRunFile());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    sender.sendMessage(ColorUtil.chat("&cMap setted!"));
                                } else {
                                    sender.sendMessage(ColorUtil.chat("&cMap already set, please delete it using /delmap"));
                                    return true;
                                }
                            }else if(args[2].equalsIgnoreCase("2")){
                                if (YamlSpeedRun.getSpeedRunConfig().getString("Parkour.Secondo.WorldName").equals("insert")) {
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.WorldName", ((Player) sender).getLocation().getWorld().getName());
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.X", ((Player) sender).getLocation().getX());
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.Y", ((Player) sender).getLocation().getY());
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.Z", ((Player) sender).getLocation().getZ());

                                    try {
                                        YamlSpeedRun.getSpeedRunConfig().save(YamlSpeedRun.getSpeedRunFile());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    sender.sendMessage(ColorUtil.chat("&cMap setted!"));
                                } else {
                                    sender.sendMessage(ColorUtil.chat("&cMap already set, please delete it using /delmap"));
                                    return true;
                                }
                            }else {
                                sender.sendMessage(ColorUtil.chat("&cYou have to choose btw 1 or 2"));
                                return true;
                            }
                        }else {
                            sender.sendMessage(ColorUtil.chat("&cYou have to choose between parkour and speedrun"));
                            return true;
                        }
                    }else if(args[0].equalsIgnoreCase("delmap")){
                        if(args[1].equalsIgnoreCase("parkour")){
                            if(args[2].equalsIgnoreCase("facile")){
                                if (!YamlParkour.getParkourConfig().getString("Parkour.Facile.WorldName").equals("insert")) {
                                    YamlParkour.getParkourConfig().set("Parkour.Facile.WorldName", "insert");
                                    YamlParkour.getParkourConfig().set("Parkour.Facile.X", "insert");
                                    YamlParkour.getParkourConfig().set("Parkour.Facile.Y", "insert");
                                    YamlParkour.getParkourConfig().set("Parkour.Facile.Z", "insert");

                                    try {
                                        YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    sender.sendMessage(ColorUtil.chat("&cMap succesfully deleted!"));

                                } else {
                                    sender.sendMessage(ColorUtil.chat("&cThis map is not set"));
                                    return true;
                                }
                            }else if(args[2].equalsIgnoreCase("medio")){
                                if (!YamlParkour.getParkourConfig().getString("Parkour.Medio.WorldName").equals("insert")) {
                                    YamlParkour.getParkourConfig().set("Parkour.Medio.WorldName", "insert");
                                    YamlParkour.getParkourConfig().set("Parkour.Medio.X", "insert");
                                    YamlParkour.getParkourConfig().set("Parkour.Medio.Y", "insert");
                                    YamlParkour.getParkourConfig().set("Parkour.Medio.Z", "insert");

                                    try {
                                        YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    sender.sendMessage(ColorUtil.chat("&cMap succesfully deleted!"));

                                } else {
                                    sender.sendMessage(ColorUtil.chat("&cThis map is not set"));
                                    return true;
                                }
                            }else if(args[2].equalsIgnoreCase("difficile")){
                                if (!YamlParkour.getParkourConfig().getString("Parkour.Difficile.WorldName").equals("insert")) {
                                    YamlParkour.getParkourConfig().set("Parkour.Difficile.WorldName", "insert");
                                    YamlParkour.getParkourConfig().set("Parkour.Difficile.X", "insert");
                                    YamlParkour.getParkourConfig().set("Parkour.Difficile.Y", "insert");
                                    YamlParkour.getParkourConfig().set("Parkour.Difficile.Z", "insert");

                                    try {
                                        YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    sender.sendMessage(ColorUtil.chat("&cMap succesfully deleted!"));

                                } else {
                                    sender.sendMessage(ColorUtil.chat("&cThis map is not set"));
                                    return true;
                                }
                            }else {
                                sender.sendMessage(ColorUtil.chat("&cYou have to choose btw facile/medio/difficile"));
                                return true;
                            }
                        }else if(args[1].equalsIgnoreCase("speedrun")){
                            if(args[2].equalsIgnoreCase("1")){
                                if (!YamlSpeedRun.getSpeedRunConfig().getString("Parkour.Primo.WorldName").equals("insert")) {
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.WorldName", "insert");
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.X", "insert");
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.Y", "insert");
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.Z", "insert");

                                    try {
                                        YamlSpeedRun.getSpeedRunConfig().save(YamlSpeedRun.getSpeedRunFile());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    sender.sendMessage(ColorUtil.chat("&cMap succesfully deleted!"));
                                } else {
                                    sender.sendMessage(ColorUtil.chat("&cThis map is not set"));
                                    return true;
                                }
                            }else if(args[2].equalsIgnoreCase("2")){
                                if (!YamlSpeedRun.getSpeedRunConfig().getString("Parkour.Secondo.WorldName").equals("insert")) {
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.WorldName", "insert");
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.Difficile.X", "insert");
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.Difficile.Y", "insert");
                                    YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.Difficile.Z", "insert");

                                    try {
                                        YamlSpeedRun.getSpeedRunConfig().save(YamlSpeedRun.getSpeedRunFile());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    sender.sendMessage(ColorUtil.chat("&cMap succesfully deleted!"));
                                } else {
                                    sender.sendMessage(ColorUtil.chat("&cThis map is not set"));
                                    return true;
                                }
                            }else {
                                sender.sendMessage(ColorUtil.chat("&cYou have to choose btw 1 and 2"));
                                return true;
                            }
                        }else {
                            sender.sendMessage(ColorUtil.chat("&cYou have to choose btw speedrun and parkour"));
                            return true;
                        }
                    }else {
                        sender.sendMessage("\n");
                        sender.sendMessage(ColorUtil.chat("&c-------------------------------"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap parkour (facile/medio/difficile)"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap speedrun (1/2)"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap parkour (facile/medio/difficile)"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap speedrun (1/2)"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload parkour"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload speedrun"));
                        sender.sendMessage(ColorUtil.chat("&c-------------------------------"));
                        sender.sendMessage("\n");
                        return true;
                    }
                }else if(args.length == 2){
                    if(args[0].equalsIgnoreCase("reload")){
                        if (args[1].equalsIgnoreCase("parkour")) {
                            YamlParkour.reloadConfig();
                            sender.sendMessage(ColorUtil.chat("&cParkour reloaded"));
                        } else if (args[1].equalsIgnoreCase("speedrun")) {
                            YamlSpeedRun.reloadConfig();
                            sender.sendMessage(ColorUtil.chat("&cSpeedrun reloaded"));
                        } else {
                            sender.sendMessage(ColorUtil.chat("&cYou have to choose between parkour and speedrun!"));
                            return true;
                        }
                    }else {
                        sender.sendMessage("\n");
                        sender.sendMessage(ColorUtil.chat("&c-------------------------------"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap parkour (facile/medio/difficile)"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap speedrun (1/2)"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap parkour (facile/medio/difficile)"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap speedrun (1/2)"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload parkour"));
                        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload speedrun"));
                        sender.sendMessage(ColorUtil.chat("&c-------------------------------"));
                        sender.sendMessage("\n");
                        return true;
                    }
                }else {
                    sender.sendMessage("\n");
                    sender.sendMessage(ColorUtil.chat("&c-------------------------------"));
                    sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap parkour (facile/medio/difficile)"));
                    sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap speedrun (1/2)"));
                    sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap parkour (facile/medio/difficile)"));
                    sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap speedrun (1/2)"));
                    sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload parkour"));
                    sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload speedrun"));
                    sender.sendMessage(ColorUtil.chat("&c-------------------------------"));
                    sender.sendMessage("\n");
                    return true;
                }
            }else {
                sender.sendMessage(ColorUtil.chat("&cYou don't have permissions to execute this command"));
                return true;
            }
        }else {
            sender.sendMessage(ColorUtil.chat("&cPlease don't execute this command by console"));
            return true;
        }

        return false;
    }
}




 /*


* } else if (args.length == 2) {

                        /*      RELOAD

                        if (args[0].equalsIgnoreCase("reload")) {
        if (args[1].equalsIgnoreCase("parkour")) {
            YamlParkour.reloadConfig();
            sender.sendMessage(ColorUtil.chat("&cParkour reloaded"));
        } else if (args[1].equalsIgnoreCase("speedrun")) {
            YamlSpeedRun.reloadConfig();
            sender.sendMessage(ColorUtil.chat("&cSpeedrun reloaded"));
        } else {
            sender.sendMessage(ColorUtil.chat("&cYou have to choose between parkour and speedrun!"));
            return true;
        }
    } else {
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap parkour (facile/medio/difficile)"));
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap speedrun (1/2)"));
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap parkour (facile/medio/difficile)"));
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap speedrun (1/2)"));
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload parkour"));
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload speedrun"));
        return true;
    }

} else {
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap parkour (facile/medio/difficile)"));
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap speedrun (1/2)"));
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap parkour (facile/medio/difficile)"));
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap speedrun (1/2)"));
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload parkour"));
        sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload speedrun"));
        return true;
        }

        } else {
        sender.sendMessage(ColorUtil.chat("&cYou don't have permission to execute this command!"));
        return true;
        }
        }
        * */
/*
if (args.length == 3) {

                    /*      SETMAP

                if (args[0].equalsIgnoreCase("setmap")) {

                /* PARKOUR

                if (args[1].equalsIgnoreCase("parkour")) {

                //facile

                if (args[2].equalsIgnoreCase("Facile")) {
                if (YamlParkour.getParkourConfig().getString("Parkour.Facile.WorldName").equals("insert")) {
                YamlParkour.getParkourConfig().set("Parkour.Facile.WorldName", ((Player) sender).getLocation().getWorld().toString());
                YamlParkour.getParkourConfig().set("Parkour.Facile.X", ((Player) sender).getLocation().getX());
                YamlParkour.getParkourConfig().set("Parkour.Facile.Y", ((Player) sender).getLocation().getY());
                YamlParkour.getParkourConfig().set("Parkour.Facile.Z", ((Player) sender).getLocation().getZ());

                try {
                YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                } catch (IOException e) {
                e.printStackTrace();
                }

                sender.sendMessage(ColorUtil.chat("&cMap setted!"));

                } else {
                sender.sendMessage(ColorUtil.chat("&cMap already set, please delete the map using /delmap"));
                return true;
                }


                //medio
                } else if (args[2].equalsIgnoreCase("medio")) {
                if (YamlParkour.getParkourConfig().getString("Parkour.Medio.WorldName").equals("insert")) {
                YamlParkour.getParkourConfig().set("Parkour.Medio.WorldName", ((Player) sender).getLocation().getWorld().toString());
                YamlParkour.getParkourConfig().set("Parkour.Medio.X", ((Player) sender).getLocation().getX());
                YamlParkour.getParkourConfig().set("Parkour.Medio.Y", ((Player) sender).getLocation().getY());
                YamlParkour.getParkourConfig().set("Parkour.Medio.Z", ((Player) sender).getLocation().getZ());

                try {
                YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                } catch (IOException e) {
                e.printStackTrace();
                }

                sender.sendMessage(ColorUtil.chat("&cMap setted!"));

                } else {
                sender.sendMessage(ColorUtil.chat("&cMap already set, please delete the map using /delmap"));
                return true;
                }


                //difficile
                } else if (args[2].equalsIgnoreCase("difficile")) {
                if (YamlParkour.getParkourConfig().getString("Parkour.Difficile.WorldName").equals("insert")) {
                YamlParkour.getParkourConfig().set("Parkour.Difficile.WorldName", ((Player) sender).getLocation().getWorld().toString());
                YamlParkour.getParkourConfig().set("Parkour.Difficile.X", ((Player) sender).getLocation().getX());
                YamlParkour.getParkourConfig().set("Parkour.Difficile.Y", ((Player) sender).getLocation().getY());
                YamlParkour.getParkourConfig().set("Parkour.Difficile.Z", ((Player) sender).getLocation().getZ());

                try {
                YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                } catch (IOException e) {
                e.printStackTrace();
                }

                sender.sendMessage(ColorUtil.chat("&cMap setted!"));

                } else {
                sender.sendMessage(ColorUtil.chat("&cMap already set, please delete the map using /delmap"));
                return true;
                }


                } else {
                sender.sendMessage(ColorUtil.chat("&cYou have to choose between 'facile/medio/difficile'"));
                return true;
                }

                /* SPEED RUN

                } else if (args[1].equalsIgnoreCase("speedrun")) {
                if (args[2].equalsIgnoreCase("1")) {
                if (YamlSpeedRun.getSpeedRunConfig().getString("Parkour.Primo.WorldName").equals("insert")) {
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.WorldName", ((Player) sender).getLocation().getWorld().toString());
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.X", ((Player) sender).getLocation().getX());
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.Y", ((Player) sender).getLocation().getY());
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.Z", ((Player) sender).getLocation().getZ());

                try {
                YamlSpeedRun.getSpeedRunConfig().save(YamlSpeedRun.getSpeedRunFile());
                } catch (IOException e) {
                e.printStackTrace();
                }

                sender.sendMessage(ColorUtil.chat("&cMap setted!"));
                } else {
                sender.sendMessage(ColorUtil.chat("&cMap already set, please delete it using /delmap"));
                return true;
                }
                } else if (args[2].equalsIgnoreCase("2")) {
                if (YamlSpeedRun.getSpeedRunConfig().getString("Parkour.Secondo.WorldName").equals("insert")) {
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.WorldName", ((Player) sender).getLocation().getWorld().toString());
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.X", ((Player) sender).getLocation().getX());
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.Y", ((Player) sender).getLocation().getY());
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.Z", ((Player) sender).getLocation().getZ());

                try {
                YamlSpeedRun.getSpeedRunConfig().save(YamlSpeedRun.getSpeedRunFile());
                } catch (IOException e) {
                e.printStackTrace();
                }

                sender.sendMessage(ColorUtil.chat("&cMap setted!"));
                } else {
                sender.sendMessage(ColorUtil.chat("&cMap already set, please delete it using /delmap"));
                return true;
                }
                } else {
                sender.sendMessage(ColorUtil.chat("&cYou have to choose between '1/2'"));
                return true;
                }
                } else {
                sender.sendMessage(ColorUtil.chat("&cYou have to choose between parkour and speedrun"));
                return true;
                }

                /*          DELMAP

                } else if (args[0].equalsIgnoreCase("delmap")) {
                if (args[1].equalsIgnoreCase("parkour")) {
                if (args[2].equalsIgnoreCase("facile")) {
                if (!YamlParkour.getParkourConfig().getString("Parkour.Facile.WorldName").equals("insert")) {
                YamlParkour.getParkourConfig().set("Parkour.Facile.WorldName", "insert");
                YamlParkour.getParkourConfig().set("Parkour.Facile.X", "insert");
                YamlParkour.getParkourConfig().set("Parkour.Facile.Y", "insert");
                YamlParkour.getParkourConfig().set("Parkour.Facile.Z", "insert");

                try {
                YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                } catch (IOException e) {
                e.printStackTrace();
                }

                sender.sendMessage(ColorUtil.chat("&cMap succesfully deleted!"));

                } else {
                sender.sendMessage(ColorUtil.chat("&cThis map is not set"));
                return true;
                }
                } else if (args[2].equalsIgnoreCase("medio")) {
                if (!YamlParkour.getParkourConfig().getString("Parkour.Medio.WorldName").equals("insert")) {
                YamlParkour.getParkourConfig().set("Parkour.Medio.WorldName", "insert");
                YamlParkour.getParkourConfig().set("Parkour.Medio.X", "insert");
                YamlParkour.getParkourConfig().set("Parkour.Medio.Y", "insert");
                YamlParkour.getParkourConfig().set("Parkour.Medio.Z", "insert");

                try {
                YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                } catch (IOException e) {
                e.printStackTrace();
                }

                sender.sendMessage(ColorUtil.chat("&cMap succesfully deleted!"));

                } else {
                sender.sendMessage(ColorUtil.chat("&cThis map is not set"));
                return true;
                }
                } else if (args[2].equalsIgnoreCase("difficile")) {
                if (!YamlParkour.getParkourConfig().getString("Parkour.Difficile.WorldName").equals("insert")) {
                YamlParkour.getParkourConfig().set("Parkour.Difficile.WorldName", "insert");
                YamlParkour.getParkourConfig().set("Parkour.Difficile.X", "insert");
                YamlParkour.getParkourConfig().set("Parkour.Difficile.Y", "insert");
                YamlParkour.getParkourConfig().set("Parkour.Difficile.Z", "insert");

                try {
                YamlParkour.getParkourConfig().save(YamlParkour.getParkourFile());
                } catch (IOException e) {
                e.printStackTrace();
                }

                sender.sendMessage(ColorUtil.chat("&cMap succesfully deleted!"));

                } else {
                sender.sendMessage(ColorUtil.chat("&cThis map is not set"));
                return true;
                }
                } else {
                sender.sendMessage(ColorUtil.chat("&cYou have to choose between facile/medio/difficile"));
                return true;
                }
                } else if (args[1].equalsIgnoreCase("speedrun")) {
                if (args[2].equalsIgnoreCase("1")) {
                if (!YamlSpeedRun.getSpeedRunConfig().getString("Parkour.Primo.WorldName").equals("insert")) {
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.WorldName", "insert");
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.Difficile.X", "insert");
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.Difficile.Y", "insert");
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Primo.Difficile.Z", "insert");

                try {
                YamlSpeedRun.getSpeedRunConfig().save(YamlSpeedRun.getSpeedRunFile());
                } catch (IOException e) {
                e.printStackTrace();
                }

                sender.sendMessage(ColorUtil.chat("&cMap succesfully deleted!"));
                } else {
                sender.sendMessage(ColorUtil.chat("&cThis map is not set"));
                return true;
                }
                } else if (args[2].equalsIgnoreCase("2")) {
                if (!YamlSpeedRun.getSpeedRunConfig().getString("Parkour.Secondo.WorldName").equals("insert")) {
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.WorldName", "insert");
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.Difficile.X", "insert");
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.Difficile.Y", "insert");
                YamlSpeedRun.getSpeedRunConfig().set("Parkour.Secondo.Difficile.Z", "insert");

                try {
                YamlSpeedRun.getSpeedRunConfig().save(YamlSpeedRun.getSpeedRunFile());
                } catch (IOException e) {
                e.printStackTrace();
                }

                sender.sendMessage(ColorUtil.chat("&cMap succesfully deleted!"));
                } else {
                sender.sendMessage(ColorUtil.chat("&cYou have to choose between 1 and 2"));
                return true;
                }
                } else {
                sender.sendMessage(ColorUtil.chat("&cYou have to choose between parkour and speedrun!"));
                return true;
                }
                } else {
                sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap parkour (facile/medio/difficile)"));
                sender.sendMessage(ColorUtil.chat("&cUsage: /parkour setmap speedrun (1/2)"));
                sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap parkour (facile/medio/difficile)"));
                sender.sendMessage(ColorUtil.chat("&cUsage: /parkour delmap speedrun (1/2)"));
                sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload parkour"));
                sender.sendMessage(ColorUtil.chat("&cUsage: /parkour reload speedrun"));
                return true;
                }
 */
