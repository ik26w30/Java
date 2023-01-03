package org.ik26w30.practicecore.utils.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;
import org.ik26w30.practicecore.PracticeCore;
import org.ik26w30.practicecore.utils.PlayerWorldSpecific;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreBoardUtils extends PlayerWorldSpecific {
    private final ScoreboardManager manager = Bukkit.getScoreboardManager();
    public final Scoreboard board = manager.getNewScoreboard();
    private final Date now = new Date();
    private final SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    private final List<Player> players = new ArrayList<>(Bukkit.getServer().getOnlinePlayers());

    public void setScoreBoard(Player p) throws IllegalArgumentException, ClassCastException{
        Objective obj = board.registerNewObjective("ScoreBoard", "LakeMC");
        obj.setDisplayName("§9§lLake§f§lMC §8« §71vs1");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score lineone = obj.getScore("§9LakeMC.com");
        Score linetwo = obj.getScore("§8§m-------------");
        Score linethree = obj.getScore("§4⭐ Shards §8« §fsoon");
        Score linefour = obj.getScore("  ");
        Score linefive = obj.getScore("§7IN-Lobby §8« §f" + getSizeForOnlinePlayer());
        Score linesix = obj.getScore("§7IN-Game §8« §f");
        Score lineseven = obj.getScore("   ");
        Score lineeight = obj.getScore("§6Winstreak §8« §f0");
        Score linenine = obj.getScore("§7Loses §8« §f" + statLoser(p));
        Score lineten = obj.getScore("§7Wins §8« §f" + statisticsWin(p));
        Score lineleven = obj.getScore("    ");
        Score linetwelve = obj.getScore("§7Unlimited");
        Score linethirteen = obj.getScore("§8« §cRanked Matches");
        Score linefourteen = obj.getScore("     ");
        Score linefifteen = obj.getScore("§8" + date.format(now));
        linefifteen.setScore(15);
        linefourteen.setScore(14);
        linethirteen.setScore(13);
        linetwelve.setScore(12);
        lineleven.setScore(11);
        lineten.setScore(10);
        linenine.setScore(9);
        lineeight.setScore(8);
        lineseven.setScore(7);
        linesix.setScore(6);
        linefive.setScore(5);
        linefour.setScore(4);
        linethree.setScore(3);
        linetwo.setScore(2);
        lineone.setScore(1);
        p.setScoreboard(board);

    }

    private int getSizeForOnlinePlayer(){
        return Bukkit.getOnlinePlayers().size();
    }
    
    public void updateScore(Player p) throws IllegalArgumentException{
        new BukkitRunnable(){
            @Override
            public void run(){
                if(p == null){
                    cancel();
                }else {
                    setScoreBoard(p);
                }

            }
        }.runTaskTimer(PracticeCore.getInstance(), 0, 5);
    }

    private int statisticsWin(Player player){
        return player.getStatistic(Statistic.PLAYER_KILLS);
    }

    private int statLoser(Player player){
        return player.getStatistic(Statistic.DEATHS);
    }

    @Override
    public String getWorldsName(World world) {
        return world.getName();
    }

    @Override
    public int getPlayerInTheWorld() {
        return Bukkit.getOnlinePlayers().size();
    }

}
