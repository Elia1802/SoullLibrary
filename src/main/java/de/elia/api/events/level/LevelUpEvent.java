package de.elia.api.events.level;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LevelUpEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final Player player;
    private final int oldLevel;
    private final int newLevel;

    public LevelUpEvent(@NotNull Player player, int oldLevel, int newLevel){
        this.player = player;
        this.oldLevel = oldLevel;
        this.newLevel = newLevel;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    public int getNewLevel() {
        return newLevel;
    }

    public int getOldLevel() {
        return oldLevel;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
