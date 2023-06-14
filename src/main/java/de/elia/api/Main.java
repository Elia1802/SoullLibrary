package de.elia.api;

import de.elia.api.logging.PluginLogger;
import de.elia.api.thezepserapi.components.DamageBlocked;
import de.elia.api.thezepserapi.components.FlightBlocked;
import de.elia.api.thezepserapi.spells.spells.gravitation.GRAVITATION_SUPER;
import de.elia.api.thezepserapi.spells.spells.weather.WEATHER_DEFENSE;
import de.elia.api.thezepserapi.spells.spells.weather.WEATHER_SUPER;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Main extends JavaPlugin {

   private static Main soulMain;
   private final PluginLogger logger = new PluginLogger("Soul-Library");

   @Override
   public void onEnable(){
      soulMain = this;
      Bukkit.getPluginManager().registerEvents(new FlightBlocked(), this);
      Bukkit.getPluginManager().registerEvents(new DamageBlocked(), this);
      Bukkit.getPluginManager().registerEvents(new GRAVITATION_SUPER(), this);
      Bukkit.getPluginManager().registerEvents(new WEATHER_SUPER(), this);
      Bukkit.getPluginManager().registerEvents(new WEATHER_DEFENSE(), this);
   }

   @Override
   public void onDisable(){

   }

   /**
    * @author Elia
    * @since V.1.0.0
    * @version V.1.0.0
    * @description the instance of this plugin
    */
   @NotNull
   public static Main soulMain() {
      return soulMain;
   }

   @NotNull
   public PluginLogger logger(){
      return this.logger;
   }

}