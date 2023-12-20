package de.elia.api.game;

import java.util.ArrayList;
import java.util.UUID;

//This interface marked a class to this class is a game
public interface Game {

  ArrayList<UUID> OLD_GAME_PLAYERS = new ArrayList<>();
  ArrayList<Game> ALL_ACTIVE_GAMES = new ArrayList<>();

  void kill(String reason, boolean isRestart);

}
