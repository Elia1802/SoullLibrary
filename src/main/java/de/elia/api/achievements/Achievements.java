package de.elia.api.achievements;

import org.jetbrains.annotations.NotNull;

public enum Achievements {

  BOSSFIGHT("Bossfight", "904980", "Schlage das erste mal ein Boss!", 20),
  BOSSFIGHT_ZOMBIE("Erstes Zombie?", "443548", "Das erste Zombie als Boss!", 15),
  BOSSFIGHT_ZOMBIE_END("Zombieboss Hunter", "265969", "Du hast den Zombieboss das erste mal getötet!", 50),
  BOSSFIGHT_CREEPER("Erster Creeper?", "357357", "Der erste Creeper als Boss!", 15),
  BOSSFIGHT_CREEPER_END("Creeperboss Hunter", "589437", "Du hast den Creeperboss das erste mal getötet!", 50),
  BOSSFIGHT_CREEPER_MINI("Vorsicht! Dein Creeper bekommt Unterstützung!", "549935", "Töte Die Unterstützung von deinen Boss!", 20);

  private final String name;
  private final String dataID;
  private final String target;
  private final int xp;

  Achievements(String name, String dataID, String target, int xp) {
    this.name = name;
    this.dataID = dataID;
    this.target = target;
    this.xp = xp;
  }

  @NotNull
  public String getName() {
    return this.name;
  }

  @NotNull
  public String dataID() {
    return this.dataID;
  }

  @NotNull
  public String target() {
    return this.target;
  }

  public int xp() {
    return this.xp;
  }
}
