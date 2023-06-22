package de.elia.api.logging;

import de.elia.api.configuration.SoulConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Elia
 * @version 1.0.0
 * @since 2.0.0
 * @description Save an exception in a file
 */
public class SaveError {

    /**
     * @author Elia
     * @version 1.0.0
     * @since 2.0.0
     * @description Save the exception in the file
     */
    public void saveError(@NotNull JavaPlugin main, @NotNull Exception exception, String name){
        SoulConfiguration file = new SoulConfiguration(main, "errors/", name + ".txt");
        try {
            PrintWriter writer = new PrintWriter(file.getFile());
            exception.printStackTrace(writer);
            file.save();
            writer.close();
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
