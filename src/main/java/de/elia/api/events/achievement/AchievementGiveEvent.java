package de.elia.api.events.achievement;

import de.elia.api.achievements.Achievements;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AchievementGiveEvent extends Event implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Player player;
    private final Achievements achievement;

    public AchievementGiveEvent(@NotNull Player player, @NotNull Achievements achievement){
        this.player = player;
        this.achievement = achievement;
    }

    @NotNull
    public Player getPlayer(){
        return this.player;
    }

    @NotNull
    public Achievements getAchievement(){
        return this.achievement;
    }

    public static HandlerList getHandlerList(){
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancel) {

    }
}
