package de.elia.api.logging.debug;

/**
 * @author Elia
 * @version 1.0.0.pre1
 * @since 1.0.0.pre1
 * @description To Send Debug messages
 */
public class PluginDebuger {

  /**
   * @author Elia
   * @version 1.0.0
   * @since 2.0.0
   * @description Debug a {@link Object} in the console
   * @param debug send a debug message
   */
  public static void debug(Object debug){
    System.out.println("!!!SOUL-DEBUG!!!" + debug);
  }

}
