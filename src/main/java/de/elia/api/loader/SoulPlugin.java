package de.elia.api.loader;

import de.elia.api.loader.exceptions.SoulPluginLoadException;
import org.bukkit.plugin.java.JavaPlugin;

import org.jetbrains.annotations.NotNull;

public interface SoulPlugin {

    void enable(@NotNull JavaPlugin main) throws SoulPluginLoadException;

    void disable(@NotNull JavaPlugin main) throws SoulPluginLoadException;

}
