package de.elia.api.timing.timer;

import de.elia.api.timing.utils.TimerUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * @author D1p4k, Elia
 * @version 1.0.0
 * @since 2.0.0
 * @description This is the Start Class for start all thinks if the runnable finished.
 */
public class TimerTasks {

  /**
   * @author D1p4k, Elia
   * @version 1.0.0
   * @since 2.0.0
   * @description Start a Countdown
   * @param time Requires the seconds
   * @param player Requires a {@link Player}
   * @param location Requires a {@link Location}
   */
  public void start(int time, @NotNull Player player, Location location, Plugin plugin){
      new TimerUtils().countdownAndRun(time,
              new Runnable() {
                  @Override
                  public void run() {

                  }
              }, plugin
      );
      new TimerUtils().countdownInterval(time,
              new TimerUtils.TimeRunnable() {
                  @Override
                  public void run(int ticks) {
                      if (ticks % 20 == 0) {
                          int seconds = ticks/20; //Use this to show seconds
                          //run countdown
                      }
                  }
              },
              new Runnable() {
                  @Override
                  public void run() {
                      //if countdown 0 run this
                  }
              }, plugin
      );
  }

}
