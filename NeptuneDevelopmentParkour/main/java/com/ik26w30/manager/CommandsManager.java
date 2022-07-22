package com.ik26w30.manager;

import com.ik26w30.Main;
import com.ik26w30.commands.DelSpawnCommand;
import com.ik26w30.commands.ParkourAdminCommand;
import com.ik26w30.commands.SetSpawnCommand;

public class CommandsManager {

    /*
    * COMANDI DA METTERE:
    *
    * !!SOLO PER AMMINISTRATORI!!
    *
    *
    * /parkour setmap (PARKOUR/SPEEDRUN)
    * /parkour reload
    * /parkour deletemap /parkour/speedrun)
    *
    * */

    public static void regCommand(){
        Main.getInstance().getCommand("parkour").setExecutor(new ParkourAdminCommand());
        Main.getInstance().getCommand("setpspawn").setExecutor(new SetSpawnCommand());
        Main.getInstance().getCommand("delpspawn").setExecutor(new DelSpawnCommand());
    }

}
