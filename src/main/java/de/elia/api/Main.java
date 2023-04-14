package de.elia.api;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Main extends JavaPlugin {

   private static Main soulMain;

   @Override
   public void onEnable(){
      soulMain = this;
   }

   @Override
   public void onDisable(){

   }

   /**
    * @author Elia
    * @since V. 1.0
    * @version V. 1.0
    * @description the instance of this plugin
    */
   @NotNull
   public static Main soulMain() {
      return soulMain;
   }
}