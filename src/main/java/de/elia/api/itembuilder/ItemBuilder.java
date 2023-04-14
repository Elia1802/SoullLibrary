package de.elia.api.itembuilder;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * @author Elia
 * @since V. 1.0
 * @version V. 1.0
 * @description Create a new Item
 */
public class ItemBuilder {

    private final ItemStack itemStack;

    private final ItemMeta itemMeta;

    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create a new Item
     */
    public ItemBuilder(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Give the Item a Name
     * @param name Requires the Name
     * @return {@link ItemBuilder}
     */
    @NotNull
    public ItemBuilder displayName(Component name){
        itemMeta.displayName(name);
        return this;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Give the Item a lore
     * @param lore Requires the lore
     * @return {@link ItemBuilder}
     */
    @NotNull
    public ItemBuilder lore(List<Component> lore){
        itemMeta.lore(lore);
        return this;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Give the Item a lore
     * @param lore Requires the lore
     * @return {@link ItemBuilder}
     */
    @NotNull
    public ItemBuilder lore(Component... lore){
        itemMeta.lore(Arrays.asList(lore));
        return this;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set the Amount of Items
     * @param amount Requires the amount of Itemms
     * @return {@link ItemBuilder}
     */
    @NotNull
    public ItemBuilder amount(int amount){
        itemStack.setAmount(amount);
        return this;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Enchanted the Item
     * @param enchantment Requires the Enchantment
     * @param level Requires the Level
     * @return {@link ItemBuilder}
     */
    public ItemBuilder enchant(Enchantment enchantment , int level){
        itemStack.addEnchantment(enchantment , level);
        return this;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Set the Item unbreakable
     * @param value Requires a true or false
     * @return {@link ItemBuilder}
     */
    @NotNull
    public ItemBuilder unbreakable(boolean value){
        itemMeta.setUnbreakable(value);
        return this;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description set the Item flags
     * @param itemFlags Requires ItemFlags
     * @return {@link ItemBuilder}
     */
    @NotNull
    public ItemBuilder itemFlag(ItemFlag... itemFlags){
        itemMeta.addItemFlags(itemFlags);
        return this;
    }

    /**
     * @author Elia
     * @since V. 1.0
     * @version V. 1.0
     * @description Create the Item
     * @return {@link ItemStack}
     */
    @NotNull
    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
