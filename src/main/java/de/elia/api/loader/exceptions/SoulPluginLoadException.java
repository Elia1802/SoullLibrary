package de.elia.api.loader.exceptions;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SoulPluginLoadException extends Exception {

    public SoulPluginLoadException(String message) {
        super(message);
    }

    public SoulPluginLoadException(String message, JavaPlugin plugin, boolean shouldDisablePlugin){
        super(message);
        if (shouldDisablePlugin){
            Bukkit.getPluginManager().disablePlugin(plugin);
        }
    }

}
