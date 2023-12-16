package de.elia.api;

import de.elia.api.logging.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Main extends JavaPlugin {

   private final PluginLogger pluginLogger = new PluginLogger("Soul-Library");
   private static Main soulLibrary;

   @Override
   public void onEnable(){
      soulLibrary = this;
      pluginLogger.logWarning("Please initialize this library in the other plugin");
   }

   @Override
   public void onDisable(){}

   public static Main getSoulLibrary() {
      return soulLibrary;
   }

   @NotNull
   public PluginLogger logger() {
      return pluginLogger;
   }

}