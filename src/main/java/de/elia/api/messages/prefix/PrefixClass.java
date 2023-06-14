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

    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description a prefix for the in game chat
     * @return {@link Component}
     */
    @NotNull
    public Component prefix(){
        return miniMessage.deserialize("<dark_gray>[</dark_gray><dark_purple>SoulSMP</dark_purple><dark_gray>]</dark_gray> ");
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description a prefix for error messages in the console
     * @return {@link Component}
     */
    @NotNull
    public String errorPrefix(){
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
    public String warningPrefix(){
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
    public String infoPrefix(){
        return "[SoulSMP] ";
    }
}
