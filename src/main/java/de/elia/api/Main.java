package de.elia.api;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
   private static final Logger logger = Logger.getLogger("Soul-Library");

   @Override
   public void onEnable(){
      logger.info("Please initialize this library in the other plugin");
=======
=======
>>>>>>> Stashed changes
   private static final PluginLogger LOG = BootsTrapper.PLUGIN_LOGGER;
   private static Main soulLibrary;

   @Override
   public void onEnable(){
      soulLibrary = this;
      LOG.logWarning("Please initialize this library in the other plugin");
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
   }

   @Override
   public void onDisable(){

   }

   @NotNull
<<<<<<< Updated upstream
<<<<<<< Updated upstream
   public static Logger logger(){
      return logger;
=======
   public static PluginLogger logger() {
      return LOG;
>>>>>>> Stashed changes
=======
   public static PluginLogger logger() {
      return LOG;
>>>>>>> Stashed changes
   }

}