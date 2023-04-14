package de.elia.api.configuration;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;
import java.io.File;
import java.lang.Boolean;
import java.lang.Byte;
import java.lang.Character;
import java.lang.Class;
import java.lang.Double;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Short;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author - Elia
 * @since - V. 1.0
 * @version - V. 1.0
 * @description - This class is a huge collection of all configuration file functions. Here are methods to
 *                create and store and read values.
 */
public class SoulConfiguration {

    public File file;
    private File filepath;
    private String pathName;
    private YamlConfiguration configuration;
    private boolean useCustomPath = false;
    private final Plugin plugin;
    private final String fileName;

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a configuration file.
     * @param plugin Requires the instance of the Main class.
     * @param name Requires a name for the file.
     */
    public SoulConfiguration(Plugin plugin , String name){
        this(plugin , name , plugin.getDataFolder());
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a configuration file.
     * @param plugin Requires the instance of the Main class.
     * @param name Requires a name for the file.
     * @param copyDefaults Requires true or false if the default values should be loaded into the target configuration.
     */
    public SoulConfiguration(Plugin plugin , String name , boolean copyDefaults){
        this(plugin , name , plugin.getDataFolder() , copyDefaults);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a configuration file.
     * @param plugin Requires the instance of the Main class.
     * @param name Requires a name for the file.
     * @param copyDefaults Requires true or false if the default values should be loaded into the target configuration.
     * @param replace Requires true or false to query whether to replace the file if it exists.
     */
    public SoulConfiguration(Plugin plugin , String name , boolean copyDefaults , boolean replace){
        this(plugin , name , plugin.getDataFolder() , copyDefaults , replace);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a configuration file.
     * @param plugin Requires the instance of the Main class.
     * @param name Requires a name for the file.
     * @param parent Requires a file path.
     */
    public SoulConfiguration(Plugin plugin , String name , File parent){
        this.plugin = plugin;
        this.fileName = name;
        filepath = parent;
        file = new File(filepath , name);

        if (!filepath.exists()) {
            filepath.mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        configuration = YamlConfiguration.loadConfiguration(file);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a configuration file.
     * @param plugin Requires the instance of the Main class.
     * @param name Requires a name for the file.
     * @param parent Requires a file path.
     * @param copyDefaults Requires true or false if the default values should be loaded into the target configuration.
     */
    public SoulConfiguration(Plugin plugin , String name , File parent , boolean copyDefaults){
        this(plugin , name , parent , copyDefaults , false);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a configuration file.
     * @param plugin Requires the instance of the Main class.
     * @param name Requires a name for the file.
     * @param parent Requires a file path.
     * @param copyDefaults Requires true or false if the default values should be loaded into the target configuration.
     * @param replace Requires true or false to query whether to replace the file if it exists.
     */
    public SoulConfiguration(Plugin plugin , String name , File parent , boolean copyDefaults , boolean replace){
        this.plugin = plugin;
        this.fileName = name;
        filepath = parent;
        file = new File(filepath , name);

        if (!filepath.exists()) {
            filepath.mkdirs();
        }

        if (copyDefaults) {
            if (!file.exists()) {
                this.plugin.saveResource(name , false);
            }else if (replace) {
                this.plugin.saveResource(name , true);
            }else {
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    }catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }

        configuration = YamlConfiguration.loadConfiguration(file);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a configuration file.
     * @param plugin Requires the instance of the Main class.
     * @param pathName Requires a file path.
     * @param name Requires a name for the file.
     */
    public SoulConfiguration(@NotNull Plugin plugin , String pathName , String name) {
        this.plugin = plugin;
        this.pathName = pathName;
        this.fileName = name;
        filepath = new File(plugin.getDataFolder() , pathName);
        useCustomPath = true;
        file = new File(filepath , name);

        if (!filepath.exists()) {
            filepath.mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        configuration = YamlConfiguration.loadConfiguration(file);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a configuration file.
     * @param plugin Requires the instance of the Main class.
     * @param pathName Requires a file path.
     * @param name Requires a name for the file.
     * @param copyDefaults Requires true or false if the default values should be loaded into the target configuration.
     */
    public SoulConfiguration(Plugin plugin , String pathName , String name , boolean copyDefaults){
        this(plugin , pathName , name , copyDefaults , false);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a configuration file.
     * @param plugin Requires the instance of the Main class.
     * @param pathName Requires a file path.
     * @param name Requires a name for the file.
     * @param copyDefaults Requires true or false if the default values should be loaded into the target configuration.
     * @param replace Requires true or false to query whether to replace the file if it exists.
     */
    public SoulConfiguration(@NotNull Plugin plugin , String pathName , String name , boolean copyDefaults , boolean replace){
        this.plugin = plugin;
        this.pathName = pathName;
        this.fileName = name;
        filepath = new File(plugin.getDataFolder() , pathName);
        useCustomPath = true;
        file = new File(filepath , name);

        if (!filepath.exists()) {
            filepath.mkdirs();
        }

        if (copyDefaults) {
            if (!file.exists()) {
                this.plugin.saveResource(pathName + name , false);
            }else if (replace) {
                this.plugin.saveResource(pathName + name , true);
            }else {
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    }catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }

        configuration = YamlConfiguration.loadConfiguration(file);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Reloads the configuration.
     * @return {@link YamlConfiguration}
     */
    @NotNull
    public YamlConfiguration reload() {
        if (filepath == null && useCustomPath) {
            filepath = new File(plugin.getDataFolder() , pathName);
        }else if (filepath == null) {
            filepath = new File(plugin.getDataFolder() , plugin.getDataFolder().getName());
        }

        if (file == null) {
            file = new File(filepath , fileName);
            configuration = YamlConfiguration.loadConfiguration(file);
            save();
        }
        return configuration;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Loads the file.
     * @param file Requires the file.
     */
    public void load(File file){
        try {
            configuration.load(file);
            save();
        }catch (InvalidConfigurationException | IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Loads the file.
     * @param file Requires the file.
     */
    public void load(String file){
        try {
            configuration.load(file);
            save();
        }catch (InvalidConfigurationException | IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Loads the reader.
     * @param reader Requires the reader.
     */
    public void load(Reader reader){
        try {
            configuration.load(reader);
            save();
        }catch (InvalidConfigurationException | IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Loads the configuration.
     * @param file Requires the file.
     * @return {@link YamlConfiguration}
     */
    @NotNull
    public YamlConfiguration loadConfiguration(File file){
        configuration = YamlConfiguration.loadConfiguration(file);
        save();
        return configuration;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Loads the configuration.
     * @param reader Requires the reader.
     * @return {@link YamlConfiguration}
     */
    @NotNull
    public YamlConfiguration loadConfiguration(Reader reader){
        configuration = YamlConfiguration.loadConfiguration(reader);
        save();
        return configuration;
    }
    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Loads the configuration from a string.
     * @param content Requires the String.
     */
    public void loadFromString(String content){
        try {
            configuration.loadFromString(content);
            save();
        }catch (InvalidConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Save the configuration from a String.
     * @return {@link String}
     */
    @NotNull
    public String saveToString(){
        String string = configuration.saveToString();
        save();
        return string;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Save the Configuration.
     */
    public void save(){
        try {
            configuration.save(file);
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Save the Configuration.
     * @param file Requires the file.
     */
    public void save(File file){
        try {
            configuration.save(file);
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Save the Configuration.
     * @param file Requires the file.
     */
    public void save(String file){
        try {
            configuration.save(file);
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Sets the defaults to false.
     */
    public void setDefaults(){
        setDefaults(false);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description - Sets the defaults settings.
     * @param replace Requires true or false.
     */
    public void setDefaults(boolean replace){
        if (!filepath.exists()) {
            filepath.mkdirs();
        }

        if (pathName != null) {
            if (!file.exists()) {
                this.plugin.saveResource(pathName + fileName , false);
            }else if (replace) {
                this.plugin.saveResource(pathName + fileName , true);
            }else {
                if (!file.exists()) {
                    this.plugin.saveResource(fileName , false);
                }else if (replace) {
                    this.plugin.saveResource(fileName , true);
                }
            }
        }

        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Sets the default settings.
     * @param defaults Requires the default settings.
     */
    public void setDefaults(Configuration defaults){
        configuration.setDefaults(defaults);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Adds the default settings.
     * @param path Requires the path where to save it.
     * @param value Requires the {@link Object} to be stored.
     */
    public void addDefault(String path , Object value){
        configuration.addDefault(path , value);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Adds the default settings.
     * @param defaults Requires the path and the {@link Object} in a {@link Map}.
     *                 The map looks like this: {@link Map<String, Object>}
     */
    public void addDefaults(Map<String , Object> defaults){
        configuration.addDefaults(defaults);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Adds the default settings.
     * @param defaults Requires the default settings.
     */
    public void addDefaults(Configuration defaults){
        configuration.addDefaults(defaults);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the default settings.
     * @return {@link Configuration}
     */
    @NotNull
    public Configuration getDefaults(){
        return configuration.getDefaults();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description If the value is true, the default values are loaded into the target configuration.
     * @param value Requires true or false.
     */
    public void copyDefaults(boolean value){
        YamlConfigurationOptions options = configuration.options().copyDefaults(value);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the copy default settings.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean getCopyDefaults(){
        return copyDefaults();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Get the copy default value.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean copyDefaults(){
        return configuration.options().copyDefaults();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set a Header.
     * @param value Requires a List of Strings.
     * @return {@link YamlConfigurationOptions}
     */
    @NotNull
    public YamlConfigurationOptions setHeader(List<String> value){
        YamlConfigurationOptions options = configuration.options().setHeader(value);
        save();
        return options;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set a Header.
     * @param values Requires multiple String.
     * @return {@link YamlConfigurationOptions}
     */
    @NotNull
    public YamlConfigurationOptions setHeader(String... values){
        List<String> headerValues = new ArrayList<>();
        Collections.addAll(headerValues , values);
        YamlConfigurationOptions options = configuration.options().setHeader(headerValues);
        save();
        return options;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the Header.
     * @return {@link List<String>}
     */
    @NotNull
    public List<String> header(){
        return configuration.options().getHeader();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Sets a Footer.
     * @param value Requires a List of Strings.
     * @return {@link YamlConfigurationOptions}
     */
    @NotNull
    public YamlConfigurationOptions setFooter(List<String> value){
        YamlConfigurationOptions options = configuration.options().setFooter(value);
        save();
        return options;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Sets a Footer.
     * @param values Requires multiple Strings.
     * @return {@link YamlConfigurationOptions}
     */
    @NotNull
    public YamlConfigurationOptions setFooter(String... values){
        List<String> footerValues = new ArrayList<>();
        Collections.addAll(footerValues , values);
        YamlConfigurationOptions options = configuration.options().setFooter(footerValues);
        save();
        return options;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a Footer.
     * @return {@link List<String>}
     */
    @NotNull
    public List<String> getFooter(){
        return configuration.options().getFooter();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set comments in the path.
     * @param path Requires the path.
     * @param comments Requires the comments in a {@link String} {@link List}.
     */
    public void setComments(String path , List<String> comments) {
        configuration.setComments(path, comments);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set comments in the path.
     * @param path Requires the path.
     * @param comments Requires the comments in multiple {@link String}s.
     */
    public void setComments(String path , String... comments){
        List<String> commentList = new ArrayList<>();
        Collections.addAll(commentList , comments);
        configuration.setComments(path , commentList);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the comments in a specific path.
     * @param path Requires the path
     * @return {@link List<String>}
     */
    @NotNull
    public List<String> getComments(String path){
        return !contains(path) ? null : configuration.getComments(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set inline comments in the path.
     * @param path Requires the path.
     * @param comments Requires the inline comments in a {@link String} {@link List}.
     */
    public void setInlineComments(String path , List<String> comments){
        configuration.setInlineComments(path , comments);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set inline comments in the path.
     * @param path Requires the path.
     * @param comments Requires the inline comments in multiple {@link String}s.
     */
    public void setInlineComments(String path , String... comments) {
        List<String> commentList = new ArrayList<>();
        Collections.addAll(commentList, comments);
        configuration.setInlineComments(path, commentList);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the comments in a specific path.
     * @param path Requires the path.
     * @return {@link List<String>}
     */
    @NotNull
    public List<String> getInlineComments(String path){
        return !contains(path) ? null : configuration.getInlineComments(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set parse comments.
     * @param value Requires true or false.
     * @return {@link YamlConfiguration}
     */
    @NotNull
    public YamlConfigurationOptions setParseComments(boolean value){
        return parseComments(value);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set parse comments.
     * @param value Requires true or false.#
     * @return {@link YamlConfigurationOptions}
     */
    @NotNull
    public YamlConfigurationOptions parseComments(boolean value){
        YamlConfigurationOptions options = configuration.options().parseComments(value);
        save();
        return options;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Get parse comments.
     * @return {@link SoulConfiguration#parseComments()}
     */
    @NotNull
    public Boolean getParseComments(){
        return parseComments();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Get parse comments.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean parseComments(){
        return configuration.options().parseComments();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Save an indent in the configuration.
     * @param indent Requires the indent.
     * @return {@link YamlConfigurationOptions}
     */
    @NotNull
    public YamlConfigurationOptions indent(int indent){
        YamlConfigurationOptions options = configuration.options().indent(indent);
        save();
        return options;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the indent.
     * @return {@link Integer}
     */
    public Integer getIndent(){
        return configuration.options().indent();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Save a width in the configuration.
     * @param width Requires the width.
     * @return {@link YamlConfigurationOptions}
     */
    @NotNull
    public YamlConfigurationOptions setWidth(int width){
        YamlConfigurationOptions options = configuration.options().width(width);
        save();
        return options;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the width.
     * @return {@link Integer}
     */
    public Integer getWidth(){
        return configuration.options().width();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set a path separator.
     * @param separator Requires a separator
     * @return {@link YamlConfigurationOptions}
     */
    @NotNull
    public YamlConfigurationOptions setPathSeparator(char separator){
        YamlConfigurationOptions options = configuration.options().pathSeparator(separator);
        save();
        return options;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the path separator.
     * @return {@link YamlConfigurationOptions#pathSeparator()}
     */
    public char getPathSeparator(){
        return configuration.options().pathSeparator();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Clear all {@link Map}s in the section.
     */
    public void clear(){
        clear(true);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Clear a Map.
     * @param deep Requires a {@link Boolean}
     */
    public void clear(Boolean deep){
        Map<String , Object> configValues = configuration.getValues(deep);
        for (Map.Entry<String , Object> entry : configValues.entrySet()) {
            configuration.set(entry.getKey() , null);
        }
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Clear a specify path.
     * @param path Requires the path.
     */
    public void clearPath(String path){
        configuration.set(path , null);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a path.
     * @param section Requires a {@link ConfigurationSection}
     * @param pathName Requires the path name.
     * @return {@link String}
     */
    @NotNull
    public String createPath(ConfigurationSection section , String pathName){
        String string = MemorySection.createPath(section , pathName);
        save();
        return string;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a path.
     * @param section Requires a {@link ConfigurationSection}
     * @param pathName Requires the path name.
     * @param relativeTo
     * @return {@link String}
     */
    @NotNull
    public String createPath(ConfigurationSection section , String pathName , ConfigurationSection relativeTo){
        String string = MemorySection.createPath(section , pathName , relativeTo);
        save();
        return string;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the current path
     * @return {@link String}
     */
    @NotNull
    public String getCurrentPath(){
        return configuration.getCurrentPath();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Queries what was set in the path
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isSet(String path){
        return configuration.isSet(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Queries a {@link String} has been set.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isString(String path){
        return configuration.isString(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify path.
     * @param path Requires the path.
     * @return {@link SoulConfiguration#getString(String)}
     */
    @NotNull
    public String getPath(String path){
        return getString(path);
    }
    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link String} from a specify path.
     * @param path Requires the path.
     * @return {@link String}
     */
    @NotNull
    public String getString(String path){
        return !contains(path) ? null : configuration.getString(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify {@link String} from a specify path.
     * @param path Requires the path.
     * @param string Requires the string.
     * @return {@link String}
     */
    @NotNull
    public String getString(String path , String string){
        return !contains(path) ? null : configuration.getString(path , string);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a section in a specify path.
     * @param path Requires the path.
     * @return {@link ConfigurationSection}
     */
    @NotNull
    public ConfigurationSection createSection(String path){
        ConfigurationSection section = configuration.createSection(path);
        save();
        return section;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Creates a section as a {@link Map} with two objects in a specified path.
     * @param path Requires the path.
     * @param values Requires the values of your Map.
     * @return {@link ConfigurationSection}
     */
    @NotNull
    public ConfigurationSection createSection(String path , Map<? , ?> values){
        ConfigurationSection section = configuration.createSection(path , values);
        save();
        return section;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Queries a configuration section is set in a specify path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isConfigurationSection(String path){
        return configuration.isConfigurationSection(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the configuration section on a specify path.
     * @param path Requires the path.
     * @return {@link ConfigurationSection}
     */
    @NotNull
    public ConfigurationSection getConfigurationSection(String path){
        return !contains(path) ? null : configuration.getConfigurationSection(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the default section.
     * @return {@link ConfigurationSection}
     */
    @NotNull
    public ConfigurationSection getDefaultSection(){
        return configuration.getDefaultSection();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the parents
     * @return {@link ConfigurationSection}
     */
    @NotNull
    public ConfigurationSection getParent(){
        return configuration.getParent();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set a {@link Object} in the configuration.
     * @param path Requires the path.
     * @param value Requires the {@link Object}.
     */
    public void set(String path , Object value){
        configuration.set(path , value);
        save();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Asks if there is anything in the path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean contains(String path){
        return configuration.contains(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify path.
     * @param path Requires the path.
     * @return {@link Object}
     */
    @NotNull
    public Object get(String path){
        return !contains(path) ? null : configuration.get(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Object} on a specify path.
     * @param path Requires the path.
     * @param value Requires the {@link Object}.
     * @return {@link Object}
     */
    @NotNull
    public Object get(String path , Object value){
        return !contains(path) ? null : configuration.get(path , value);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Boolean} in specify path.
     * @param path Requires the path.
     * @param value Requires true or false.
     * @return {@link Boolean}
     */
    public Boolean get(String path , boolean value){
        return configuration.contains(path , value);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Object} on a specify path.
     * @param path Requires the path.
     * @param value Requires the {@link Object}.
     * @return {@link Object}
     */
    @NotNull
    public Object getObject(String path , Class<Object> value){
        return !contains(path) ? null : configuration.getObject(path , value);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets all keys on the section.
     * @return {@link Set<String>}
     */
    @NotNull
    public Set<String> getKeys(){
        return configuration.getKeys(true);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets all keys on the section if {@link boolean} true.
     * @param deep Requires true or false.
     * @return {@link Set<String>}
     */
    @NotNull
    public Set<String> getKeys(boolean deep){
        return configuration.getKeys(deep);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets all Values.
     * @return {@link SoulConfiguration#getValues(Boolean)}
     */
    @NotNull
    public Map<String , Object> getValues(){
        return getValues(true);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets all values if {@link boolean} true.
     * @param deep Requires true or false.
     * @return {@link SoulConfiguration#getValues(Boolean)}
     */
    @NotNull
    public Map<String , Object> getValues(Boolean deep){
        return getValues(deep);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Asks if a boolean was stored in the path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    public Boolean isBoolean(String path){
        return !contains(path) ? null : configuration.isBoolean(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify {@link boolean} on a specify path.
     * @param path Requires the path.
     * @param value Requires true or false.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean getBoolean(String path , boolean value){
        return !contains(path) ? null : configuration.getBoolean(path , value);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a boolean list from a specify path.
     * @param path Requires the path.
     * @return {@link List<Boolean>}
     */
    @NotNull
    public List<Boolean> getBooleanList(String path) {
        return configuration.getBooleanList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Asks if an {@link int} was stored in the path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isInt(String path) {
        return configuration.isInt(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets all {@link int} in a specify Path
     * @param path Requires the path.
     * @return {@link Integer}
     */
    @NotNull
    public Integer getInt(String path) {
        return !contains(path) ? null : configuration.getInt(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify {@link int} in specify path.
     * @param path Requires the path.
     * @param value Requires a {@link int}.
     * @return {@link Integer}
     */
    @NotNull
    public Integer getInt(String path, int value) {
        return !contains(path) ? null : configuration.getInt(path, value);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Integer} {@link List} from a specify path.
     * @param path Requires the path.
     * @return {@link List<Integer>}
     */
    @NotNull
    public List<Integer> getIntegerList(String path) {
        return !contains(path) ? null : configuration.getIntegerList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Asks if a {@link long} was stored in the path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isLong(String path) {
        return configuration.isLong(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Long} on a specify path
     * @param path Requires the path.
     * @return {@link Long}
     */
    @NotNull
    public Long getLong(String path) {
        return !contains(path) ? null : configuration.getLong(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify {@link long} in a specify path.
     * @param path Requires the path.
     * @param value Requires a {@link long}.
     * @return {@link Long}
     */
    @NotNull
    public Long getLong(String path, long value) {
        return !contains(path) ? null : configuration.getLong(path, value);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Long} {@link List} from a specify path.
     * @param path Requires the path.
     * @return {@link List<Long>}
     */
    @NotNull
    public List<Long> getLongList(String path) {
        return !contains(path) ? null : configuration.getLongList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Asks if a {@link Double} was stored in the path.
     * @param path Requires the path.
     * @return {@link Double}
     */
    @NotNull
    public Boolean isDouble(String path) {
        return configuration.isDouble(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Double} from a specify path.
     * @param path Requires the path.
     * @return {@link Double}
     */
    @NotNull
    public Double getDouble(String path) {
        return !contains(path) ? null : configuration.getDouble(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify {@link Double} from a specify path.
     * @param path Requires the path.
     * @param value Requires a {@link Double}.
     * @return {@link Double}
     */
    @NotNull
    public Double getDouble(String path, double value) {
        return !contains(path) ? null : configuration.getDouble(path, value);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Double} {@link List}.
     * @param path Requires the path.
     * @return {@link List<Double>}
     */
    @NotNull
    public List<Double> getDoubleList(String path) {
        return !contains(path) ? null : configuration.getDoubleList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Float} {@link List}.
     * @param path Requires the path.
     * @return {@link List<Float>}
     */
    @NotNull
    public List<Float> getFloatList(String path) {
        return !contains(path) ? null : configuration.getFloatList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Short} {@link List}.
     * @param path Requires the path.
     * @return {@link List<Short>}
     */
    @NotNull
    public List<Short> getShortList(String path) {
        return !contains(path) ? null : configuration.getShortList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Byte} {@link List}.
     * @param path Requires the path.
     * @return {@link List<Byte>}
     */
    @NotNull
    public List<Byte> getByteList(String path) {
        return configuration.getByteList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Character} {@link List}.
     * @param path Requires the path.
     * @return {@link List<Character>}
     */
    @NotNull
    public List<Character> getCharacterList(String path) {
        return configuration.getCharacterList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description  Asks if a {@link List<?>} was stored in the path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isList(String path) {
        return configuration.isList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link List<?>} from a specify path.
     * @param path Requires the path.
     * @return {@link List<?>}
     */
    @NotNull
    public List<?> getList(String path) {
        return !contains(path) ? null : configuration.getList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify {@link List<?>} from a specify path.
     * @param path Requires the path.
     * @param value Requires the {@link List<?>}.
     * @return {@link List<?>}
     */
    @NotNull
    public List<?> getList(String path, List<?> value) {
        return !contains(path) ? null : (configuration.getList(path, value));
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link List} of {@link Map<?, ?>}s from a specify path.
     * @param path Requires the path.
     * @return {@link Map<?, ?>}
     */
    @NotNull
    public List<Map<?, ?>> getMapList(String path) {
        return !contains(path) ? null : configuration.getMapList(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Asks if a {@link OfflinePlayer} was stored in the path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isOfflinePlayer(String path) {
        return configuration.isOfflinePlayer(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link OfflinePlayer}.
     * @param path Requires the path.
     * @return {@link OfflinePlayer}
     */
    @NotNull
    public OfflinePlayer getOfflinePlayer(String path) {
        return !contains(path) ? null : configuration.getOfflinePlayer(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify {@link OfflinePlayer} in a specify path.
     * @param path Requires the path.
     * @param def Requires the {@link OfflinePlayer}
     * @return {@link OfflinePlayer}
     */
    @NotNull
    public OfflinePlayer getOfflinePlayer(String path, OfflinePlayer def) {
        return !contains(path) ? null : configuration.getOfflinePlayer(path, def);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Asks if a {@link ItemStack} was stored in the path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isItemStack(String path) {
        return configuration.isItemStack(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link ItemStack} on a specify path.
     * @param path Requires the path.
     * @return {@link ItemStack}
     */
    @NotNull
    public ItemStack getItemStack(String path) {
        return !contains(path) ? null : configuration.getItemStack(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify {@link ItemStack} on a specify path.
     * @param path Requires the path.
     * @param value Requires the {@link ItemStack}.
     * @return {@link ItemStack}
     */
    @NotNull
    public ItemStack getItemStack(String path, ItemStack value) {
        return !contains(path) ? null : (configuration.getItemStack(path, value));
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Asks if a {@link Location} was stored in the path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isLocation(String path) {
        return configuration.isLocation(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Location} from a specify path.
     * @param path Requires the path.
     * @return {@link Location}
     */
    @NotNull
    public Location getLocation(String path) {
        return !contains(path) ? null : configuration.getLocation(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify {@link Location} from a specify path.
     * @param path Requires the path.
     * @param location Requires the {@link Location}.
     * @return {@link Location}
     */
    @NotNull
    public Location getLocation(String path, Location location) {
        return !contains(path) ? null : configuration.getLocation(path, location);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Asks if a {@link Vector} was stored in the path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isVector(String path) {
        return configuration.isVector(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a {@link Vector} from a specify path.
     * @param path Requires the path.
     * @return {@link Vector}
     */
    @NotNull
    public Vector getVector(String path) {
        return !contains(path) ? null : configuration.getVector(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a specify {@link Vector} from a specify path.
     * @param path Requires the path.
     * @param value Requires the {@link Vector}
     * @return {@link Vector}
     */
    @NotNull
    public Vector getVector(String path, Vector value) {
        return !contains(path) ? null : configuration.getVector(path, value);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Queries if a color is stored in the path.
     * @param path Requires the path.
     * @return {@link Boolean}
     */
    @NotNull
    public Boolean isColor(String path) {
        return configuration.isColor(path);
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the colors in a specify path.
     * @param path Requires the path.
     * @param value Requires the color.
     * @return {@link Color}
     */
    @NotNull
    public Color getColor(String path, Color value) {
        return !contains(path) ? null : (configuration.getColor(path, value));
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the configuration name.
     * @return {@link SoulConfiguration#getConfigurationName()}
     */
    @NotNull
    public String getName() {
        return getConfigurationName();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description - Gets the configuration name.
     * @return {@link YamlConfiguration#getName()}
     */
    @NotNull
    public String getConfigurationName() {
        return configuration.getName();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the options from the configuration.
     * @return {@link SoulConfiguration#getOptions()}
     */
    @NotNull
    public FileConfigurationOptions options() {
        return getOptions();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the options from the configuration.
     * @return {@link YamlConfiguration#options()}
     */
    @NotNull
    public YamlConfigurationOptions getOptions() {
        return configuration.options();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the file.
     * @return {@link File}
     */
    @NotNull
    public File getFile() {
        return file;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the file path.
     * @return {@link String}
     */
    @NotNull
    public File getFilepath() {
        return filepath;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the file name.
     * @return {@link String}
     */
    @NotNull
    public String getFileName() {
        return fileName;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets the path name.
     * @return {@link String}
     */
    @NotNull
    public String getPathName() {
        return pathName;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Gets a configuration.
     * @return {@link YamlConfiguration}
     */
    @NotNull
    public YamlConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Sets a configuration.
     * @param configuration Requires the configuration
     */
    public void setConfiguration(YamlConfiguration configuration) {
        this.configuration = configuration;
    }
}
