package de.elia.api.logging;

import de.elia.api.configuration.SoulConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Elia
 * @version 1.0.0
 * @since 2.0.0
 * @description A logger for this Plugin
 */
public class PluginLogger {

  private final Logger logger;

  /**
   * @author Elia
   * @version 1.0.0
   * @since 2.0.0
   * @description Create a new Logger
   * @param loggerName Requires a name for the {@link Logger}
   */
  public PluginLogger(@NotNull String loggerName){
    this.logger = (Logger) LogManager.getLogger(loggerName);
  }

  /**
   * @author Elia
   * @version 1.0.0
   * @since 2.0.0
   * @description Save an exception in a file
   */
  public static class SaveError {

    private SoulConfiguration file;//file

    /**
     * @author Elia
     * @version 1.0.0
     * @since 2.0.0
     * @description Create a file
     */
    private void createFile(@NotNull JavaPlugin main, String name){
      file = new SoulConfiguration(main, "errors/", name + ".txt");
    }

    /**
     * @author Elia
     * @version 1.0.0
     * @since 2.0.0
     * @description Save the exception in the file
     */
    public void saveError(@NotNull JavaPlugin main, @NotNull Exception exception, String name){
      createFile(main, name);
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

  /**
   * @author Elia
   * @version 1.0.0
   * @since 2.0.0
   * @description Print a Stacktrace in the console
   * @param exception Requires the exception
   */
  public void stacktrace(Exception exception) {
    logger.error("Error occurred: ", exception);
  }

  /**
   * @author Elia
   * @version 1.0.0
   * @since 2.0.0
   * @description Print a Stacktrace in the console
   * @param message
   * @param exception
   */
  public void stacktrace(String message, Exception exception) {
    logger.error("Error occurred: " + message, exception);
  }

  /**
   * @author Elia
   * @version 1.0.0
   * @since 2.0.0
   * @description log a info message
   * @param message Requires the Message
   */
  public void logInfo(@NotNull String message){
    logger.info("[INFO]" + message);
  }

  /**
   * @author Elia
   * @version 1.0.0
   * @since 2.0.0
   * @description log a warning message
   * @param message Requires the Message
   */
  public void logWarning(@NotNull String message){
    logger.warn("[WARNING]" + message);
  }

  /**
   * @author Elia
   * @version 1.0.0
   * @since 2.0.0
   * @description log a error message
   * @param message Requires the Message
   */
  public void logError(@NotNull String message){
    logger.error("[ERROR]" + message);
  }

  /**
   * @author Elia
   * @version 1.0.0
   * @since 2.0.0
   * @description Gets the Logger
   */
  @NotNull
  public Logger logger() {
    return logger;
  }

}
