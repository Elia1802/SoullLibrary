package de.elia.api.messages.prefix;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;

import java.lang.String;

/**
 * @author Elia
 * @since V.1.0.0
 * @version V.1.0.0
 * @description Creates all the prefixes you need.
 */
public class PrefixClass {

    public PrefixClass(){

    }

    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description a prefix for the in game chat
     * @return {@link Component}
     */
    @NotNull
    public static Component prefix(){
        return miniMessage.deserialize("<dark_grey>[<#9545a3>SoulSMP</#9545a3>]</dark_grey> ");
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description a prefix for error messages in the console
     * @return {@link Component}
     */
    @NotNull
    public static String errorPrefix(){
        return "[SoulError] ";
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description a prefix for warning messages in the console
     * @return {@link Component}
     */
    @NotNull
    public static String warningPrefix(){
        return "[SoulWarning] ";
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description a prefix for info messages in the console
     * @return {@link Component}
     */
    @NotNull
    public static String infoPrefix(){
        return "[SoulSMP] ";
    }
}
