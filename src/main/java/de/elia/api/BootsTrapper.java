package de.elia.api;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class BootsTrapper implements PluginBootstrap {

<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream

    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        //...
=======
    public static final PluginLogger PLUGIN_LOGGER = new PluginLogger("Soul-Library");

    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        PLUGIN_LOGGER.logInfo("Boot " + NAME + "...");
        PLUGIN_LOGGER.logInfo("This is an build of " + NAME + "!");
>>>>>>> Stashed changes
=======
    public static final PluginLogger PLUGIN_LOGGER = new PluginLogger("Soul-Library");

    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        PLUGIN_LOGGER.logInfo("Boot " + NAME + "...");
        PLUGIN_LOGGER.logInfo("This is an build of " + NAME + "!");
>>>>>>> Stashed changes
=======
    public static final PluginLogger PLUGIN_LOGGER = new PluginLogger("Soul-Library");

    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        PLUGIN_LOGGER.logInfo("Boot " + NAME + "...");
        PLUGIN_LOGGER.logInfo("This is an build of " + NAME + "!");
>>>>>>> Stashed changes
    }

    @Override
    public @NotNull JavaPlugin createPlugin(@NotNull PluginProviderContext context) {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        PLUGIN_LOGGER.logInfo("Information about this Plugin");
        PLUGIN_LOGGER.logInfo("Name: " + NAME);
        PLUGIN_LOGGER.logInfo("API-Name: " + API_NAME);
        PLUGIN_LOGGER.logInfo("API-Version: " + API_VERSION);
        PLUGIN_LOGGER.logInfo("Version: " + VERSION);
        PLUGIN_LOGGER.logInfo("Authors: " + AUTHOR);
        PLUGIN_LOGGER.logInfo("Booting finished!");
        PLUGIN_LOGGER.logInfo("Load Main!");
<<<<<<< Updated upstream
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        return new Main();
    }
}
