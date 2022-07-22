package com.ik26w30.utils.mysql;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.*;

public class SQLTable implements MySQLData {
    public static void createTable(String pName){
        try {
            Statement stat = null;
            stat = SQLConnect.getConnection().createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS " + pName.toLowerCase() + " (hoursplaying INT, jumps INT)";
            stat.execute(sql);
            stat.close();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneMC] Table created!");
        }catch (SQLException | NullPointerException ex){
            ex.printStackTrace();
        }
    }

    public static void insertTable(String contest, String pName, int value){
        try {
            final String SELECT_QUERY = "SELECT " + contest + " FROM " + pName.toLowerCase();
            final String INSERT_QUERY = "INSERT INTO " + pName.toLowerCase() + "(" + contest+ ") " + "VALUES('" + value + "')";

            try (Connection con = SQLConnect.getConnection()) {
                PreparedStatement ps = null;
                PreparedStatement ps1 = null;
                ResultSet rs = null;
                int dataLevel = 0;
                ps = con.prepareStatement(SELECT_QUERY);
                ps.setString(1, pName);
                rs = ps.executeQuery();
                while (rs.next()) {
                    dataLevel = rs.getInt(contest);
                }
                if (dataLevel > 0) {
                    ps1 = con.prepareStatement(INSERT_QUERY);
                    ps1.setInt(1, dataLevel);
                    ps1.setString(2, pName);
                    ps1.execute();
                }
            } catch (SQLException ex) {
                Bukkit.getConsoleSender().sendMessage("Error");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getInfo(String contest, String pName){
        try {
            Statement statement = null;
            statement = SQLConnect.getConnection().createStatement();
            String sql = "SELECT " + contest + " FROM " + pName.toLowerCase();
            statement.execute(sql);
            statement.close();
        }catch (SQLException | NullPointerException ex){
            ex.printStackTrace();
        }
        return "SELECT " + contest + " FROM " + pName.toLowerCase();
    }

}













  /*
        String sql = "INSERT INTO " + pName.toLowerCase() + "(" + contest+ ") " + "VALUES('" + value + "')";
            stat.execute(sql);
            stat.close();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneMC] Date saved");
        }catch (SQLException | NullPointerException ex){
            ex.printStackTrace();
        }
        */