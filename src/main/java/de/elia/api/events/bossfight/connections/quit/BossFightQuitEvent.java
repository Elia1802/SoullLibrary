package de.elia.api.events.bossfight.connections.quit;

import de.elia.api.messages.builder.MessageBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static de.elia.api.messages.builder.MessageBuilder.message;

public class BossFightQuitEvent extends Event {

  private final MessageBuilder messageBuilder = new MessageBuilder();
  private static final HandlerList HANDLER_LIST = new HandlerList();
  private Set<Player> players = new HashSet<>();
  private final Player quitedPlayer;

  public BossFightQuitEvent(@NotNull Set<Player> players, @NotNull Player quitedPlayer){
    this.players = players;
    this.quitedPlayer = quitedPlayer;
  }

  public void sendQuitMessage(Component message) {
    this.players.forEach(player -> message(player, message));
  }

  @Nullable
  public Player getQuitedPlayer() {
    return quitedPlayer;
  }

  @Nullable
  public Player getPlayer(String name){
    if (this.players.contains(Bukkit.getPlayer(name))) {
      return Bukkit.getPlayer(name);
    }else return null;
  }

  @Nullable
  public Player getPlayer(UUID uuid){
    if (this.players.contains(Bukkit.getPlayer(uuid))) {
      return Bukkit.getPlayer(uuid);
    }else return null;
  }

  @NotNull
  public Set<Player> getPlayers() {
    return players;
  }

  @NotNull
  public static HandlerList getHandlerList() {
    return HANDLER_LIST;
  }

  @Override
  public @NotNull HandlerList getHandlers() {
    return HANDLER_LIST;
  }
}
