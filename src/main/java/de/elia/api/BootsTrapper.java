package de.elia.api;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import static de.elia.api.PluginInfo.API_NAME;
import static de.elia.api.PluginInfo.API_VERSION;
import static de.elia.api.PluginInfo.AUTHOR;
import static de.elia.api.PluginInfo.NAME;
import static de.elia.api.PluginInfo.VERSION;

public class BootsTrapper implements PluginBootstrap {

    private final Main main = new Main();

    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        main.logger().logInfo("Boot " + NAME + "...");
        main.logger().logInfo("This is an build of " + NAME + "!");
    }

    @Override
    public @NotNull JavaPlugin createPlugin(@NotNull PluginProviderContext context) {
        main.logger().logInfo("Information about this Plugin");
        main.logger().logInfo("Name: " + NAME);
        main.logger().logInfo("API-Name: " + API_NAME);
        main.logger().logInfo("API-Version: " + API_VERSION);
        main.logger().logInfo("Version: " + VERSION);
        main.logger().logInfo("Authors: " + AUTHOR);
        main.logger().logInfo("Booting finished!");
        main.logger().logInfo("Load Main!");
        return this.main;
    }
}
