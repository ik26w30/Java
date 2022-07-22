package com.ik26w30.utils.mysql;

import com.ik26w30.file.YamlSql;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnect implements MySQLData {
    private static Connection connection = null;

    public void createConnection() {

        String url = "jdbc:mysql://" + YamlSql.getSqlConf().get("IP") + "/" + YamlSql.getSqlConf().get("DBName");
        String user = "" + YamlSql.getSqlConf().get("User");
        String password = "" + YamlSql.getSqlConf().get("Pssw");

        try {
            connection = DriverManager.getConnection(url, user, password);
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[NeptuneMC] MySQL Connected");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        return connection;
    }
}