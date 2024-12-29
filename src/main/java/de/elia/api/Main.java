package de.elia.api;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

   private static final Logger logger = Logger.getLogger("Soul-Library");

   @Override
   public void onEnable(){
      logger.info("Please initialize this library in the other plugin");
   }

   @Override
   public void onDisable(){

   }

   @NotNull
   public static Logger logger(){
      return logger;
   }

}