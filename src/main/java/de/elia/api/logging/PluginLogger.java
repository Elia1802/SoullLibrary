package de.elia.api.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.jetbrains.annotations.NotNull;

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
