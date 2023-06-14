package de.elia.api.thezepserapi.components;

import de.elia.api.Main;
import de.elia.api.thezepserapi.Complex;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ComplexItemKeyConstructer {
  public String getKey(ItemStack itemStack) {
    ItemMeta meta = itemStack.getItemMeta();
    return meta.getPersistentDataContainer().getKeys().toString();
  }
  public boolean hasKey(ItemStack itemStack, String key) {
    ItemMeta meta = itemStack.getItemMeta();
    if (meta != null) {
      if (meta.getPersistentDataContainer().has(new NamespacedKey(Main.soulMain(), key))) {
        return true;
      }
      else {
        return false;
      }
    }
    return false;
  }
  public String createKey(Complex item) {
    return String.valueOf(item);
  }
}
