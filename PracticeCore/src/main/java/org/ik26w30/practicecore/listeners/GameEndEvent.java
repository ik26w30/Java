package org.ik26w30.practicecore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameEndEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private final Player winner;
    private final Player loser;
    private final int final_score;

    public GameEndEvent(Player winner, Player loser, int final_score) {
        this.winner = winner;
        this.loser = loser;
        this.final_score = final_score;
    }

    public Player getWinner(){
        return winner;
    }

    public int getFinal_score(){
        return final_score;
    }

    public Player getLoser(){
        return loser;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancel) {

    }
}
