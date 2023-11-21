package de.elia.api.messages.builder;

import de.elia.api.messages.prefix.PrefixClass;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerKickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Elia
 * @since V.1.0.0
 * @version V.1.0.0
 * @description This class simplifies the principle of the {@link MiniMessage}. If used correctly,
 *               you can save a lot of space. You don't need color codes of the {@link MiniMessage}.
 */
public class MessageBuilder {

    private final Logger logger = Bukkit.getLogger();
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();
    private static final PrefixClass prefix = new PrefixClass();

    public MessageBuilder(){
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Make a new line between each {@link Component}
     * @param lines Requires the Components
     * @return {@link Component}
     */
    @NotNull
    public static Component newLines(@NotNull List<Component> lines){
        Component result = Component.empty();

        for (Component component : lines) {
            result = result.append(component);
        }

        return result;
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Make a new line between each {@link Component}
     * @param lines Requires the Components
     * @return {@link Component}
     */
    @NotNull
    public static Component newLines(Component @NotNull ... lines){
        Component result = Component.empty();

        for (Component component : lines) {
            result = result.append(component);
        }

        return result;
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message
     * @param message Requires a message as {@link Component}
     */
    public static void broadcast(Component message){
        Bukkit.broadcast(message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message with Prefix
     * @param message Requires a message as {@link Component}
     */
    public static void broadcastWithPrefix(Component message){
        Bukkit.broadcast(prefix.prefix().append(message));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message
     * @param message Requires a message as {@link String}
     */
    public static void broadcast(String message){
        Bukkit.broadcast(miniMessage.deserialize(message));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message with Prefix
     * @param message Requires a message as {@link Component}
     */
    public static void broadcastWithPrefix(String message){
        Bukkit.broadcast(miniMessage.deserialize(prefix.prefix() + message));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message to {@link Player} with a specify permission
     * @param player Requires a {@link Player}
     * @param permission Requires a permission
     * @param message Requires a message as {@link Component}
     */
    public static void broadcast(@NotNull Player player , String permission , Component message){
        if (player.hasPermission(permission)) {
            Bukkit.broadcast(message);
        }
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message to {@link Player} with a specify permission with prefix
     * @param player Requires a {@link Player}
     * @param permission Requires a permission
     * @param message Requires a message as {@link Component}
     */
    public static void broadcastWithPrefix(@NotNull Player player , String permission , Component message){
        if (player.hasPermission(permission)) {
            Bukkit.broadcast(prefix.prefix().append(message));
        }
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message to {@link Player} with a specify permission
     * @param player Requires a {@link Player}
     * @param permission Requires a permission
     * @param message Requires a message as {@link String}
     */
    public static void broadcast(@NotNull Player player , String permission , String message){
        if (player.hasPermission(permission)) {
            Bukkit.broadcast(miniMessage.deserialize(message));
        }
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message to {@link Player} with a specify permission with prefix
     * @param player Requires a {@link Player}
     * @param permission Requires a permission
     * @param message Requires a message as {@link String}
     */
    public static void broadcastWithPrefix(@NotNull Player player , String permission , String message){
        if (player.hasPermission(permission)) {
            Bukkit.broadcast(miniMessage.deserialize(prefix.prefix() + message));
        }
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message to {@link Player} with a specify permission
     * @param permission Requires a permission
     * @param message Requires a message as {@link Component}
     */
    public static void broadcast(Component message , String permission){
        Bukkit.broadcast(message , permission);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message to {@link Player} with a specify permission with Prefix
     * @param permission Requires a permission
     * @param message Requires a message as {@link Component}
     */
    public static void broadcastWithPrefix(Component message , String permission){
        Bukkit.broadcast(prefix.prefix().append(message) , permission);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message to {@link Player} with a specify permission
     * @param permission Requires a permission
     * @param message Requires a message as {@link String}
     */
    public static void broadcast(String message , String permission){
        Bukkit.broadcast(miniMessage.deserialize(message) , permission);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a broadcast message to {@link Player} with a specify permission with prefix
     * @param permission Requires a permission
     * @param message Requires a message as {@link String}
     */
    public static void broadcastWithPrefix(String message , String permission){
        Bukkit.broadcast(miniMessage.deserialize(prefix.prefix() + message) , permission);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description kick a player with a message
     * @param player Requires a {@link Player}
     * @param message Requires a message as {@link Component}
     */
    public static void kickMessage(@NotNull Player player , Component message){
        player.kick(message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description kick a player with a message and a cause
     * @param player Requires a {@link Player}
     * @param message Requires a message as {@link Component}
     * @param cause Requires a cause for the kick ({@link PlayerKickEvent.Cause})
     */
    public static void kickMessage(@NotNull Player player , Component message , PlayerKickEvent.Cause cause) {
        player.kick(message , cause);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description kick a player with a message and in a new line a cause
     * @param player Requires a {@link Player}
     * @param message Requires a message as {@link Component}
     * @param cause Requires a cause for the kick ({@link Component})
     */
    public static void kickMessage(@NotNull Player player , Component message , Component cause){
        player.kick(newLines(message , cause));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description kick a player with a message
     * @param player Requires a {@link Player}
     * @param message Requires a message as {@link String}
     */
    public static void kickMessage(@NotNull Player player , String message){
        player.kick(miniMessage.deserialize(message));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description kick a player with a message and a cause
     * @param player Requires a {@link Player}
     * @param message Requires a message as {@link Component}
     * @param cause Requires a cause for the kick ({@link PlayerKickEvent.Cause})
     */
    public static void kickMessage(@NotNull Player player , String message , PlayerKickEvent.Cause cause) {
        player.kick(miniMessage.deserialize(message) , cause);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description kick a player with a message and in a new line a cause
     * @param player Requires a {@link Player}
     * @param message Requires a message as {@link Component}
     * @param cause Requires a cause for the kick ({@link Component})
     */
    public static void kickMessage(@NotNull Player player, String message , Component cause){
        player.kick(newLines(miniMessage.deserialize(message) , cause));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Set a command permission message
     * @param command Requires the Command
     * @param message Requires the Message
     */
    public static void permissionMessage(String command , String message){
        Component component = miniMessage.deserialize(prefix.errorPrefix() + message);
        Bukkit.getPluginCommand(command).permissionMessage(component);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a message to a {@link Player}
     * @param message Requires a message as {@link Component}
     */
    public static void message(@NotNull Player player , Component message){
        player.sendMessage(message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a message to a {@link Player} with prefix
     * @param message Requires a message as {@link Component}
     */
    public static void messageWithPrefix(@NotNull Player player , Component message){
        player.sendMessage(prefix.prefix().append(message));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a message to a {@link Player}
     * @param message Requires a message as {@link String}
     */
    public static void message(@NotNull Player player , String message){
        player.sendMessage(miniMessage.deserialize(message));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a message to a {@link Player} with prefix
     * @param message Requires a message as {@link String}
     */
    public static void messageWithPrefix(@NotNull Player player , String message){
        player.sendMessage(miniMessage.deserialize(prefix.prefix() + message));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a message to a {@link CommandSender}
     * @param message Requires a message as {@link Component}
     */
    public static void message(@NotNull CommandSender sender , Component message){
        sender.sendMessage(message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a message to a {@link CommandSender} with Prefix
     * @param message Requires a message as {@link Component}
     */
    public static void messageWithPrefix(@NotNull CommandSender sender , Component message){
        sender.sendMessage(prefix.prefix().append(message));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a message to a {@link CommandSender}
     * @param message Requires a message as {@link String}
     */
    public static void message(@NotNull CommandSender sender , String message){
        sender.sendMessage(miniMessage.deserialize(message));
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description Send a message to a {@link CommandSender} with Prefix
     * @param message Requires a message as {@link String}
     */
    public static void messageWithPrefix(@NotNull CommandSender sender , String message){
        sender.sendMessage(miniMessage.deserialize(prefix.prefix() + message));
    }

    //FOR THIS CLASS
    @NotNull
    private static Component color(String color , String message){
        return miniMessage.deserialize("<" + color + ">" + message + "</" + color + ">");
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a message gradient
     * @param ofColor Requires the Color 1
     * @param toColor Requires the Color 2
     * @param message Requires the Message
     * @return {@link Component}
     */
    @NotNull
    public static Component gradient(String ofColor , String toColor , String message){
        return miniMessage.deserialize("<gradient:" + ofColor + ":" + toColor + ">" + message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description create a hover text
     * @param textToShow the message to show if the player hover
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component hover(String textToShow , String message){
        return miniMessage.deserialize("<hover:show_text'" + textToShow + "'>" + message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a black message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component black(String message){
        return color("black" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a dark blue message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component darkBlue(String message){
        return color("dark_blue" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a dark green message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component darkGreen(String message){
        return color("dark_green" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a dark aqua message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component darkAqua(String message){
        return color("dark_aqua" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a dark red message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component darkRed(String message){
        return color("dark_red" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a dark purple message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component darkPurple(String message){
        return color("dark_purple" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a dark gray message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component darkGray(String message){
        return color("dark_gray" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a gold message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component gold(String message){
        return color("gold" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a gray message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component gray(String message){
        return color("gray" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a blue message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component blue(String message){
        return color("blue" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a green message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component green(String message){
        return color("green" , message);
    }
    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a blue message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component aqua(String message){
        return color("aqua" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a red message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component red(String message){
        return color("red" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a light purple message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component lightPurple(String message){
        return color("light_purple" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a yellow message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component yellow(String message){
        return color("yellow" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a white message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component white(String message){
        return color("white" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a bold message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component bold(String message){
        return color("bold" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write an italic message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component italic(String message){
        return color("italic" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a underlined message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component underlined(String message){
        return color("underlined" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write a strikethrough message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component strikethrough(String message){
        return color("strikethrough" , message);
    }

    /**
     * @author Elia
     * @since V.1.0.0
     * @version V.1.0.0
     * @description write an obfuscated message
     * @param message Requires a message
     * @return {@link Component}
     */
    @NotNull
    public static Component obfuscated(String message){
        return color("obfuscated" , message);
    }

}
