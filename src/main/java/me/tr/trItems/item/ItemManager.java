package me.tr.trItems.item;

import me.tr.configuration.Section;
import me.tr.trItems.item.helper.ItemType;
import me.tr.trItems.item.items.BaseItem;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private final List<BaseItem> cachedItems = new ArrayList<>();

    public List<BaseItem> getCachedItems() {
        return cachedItems;
    }

    public ItemType getItemType(Section itemSection) {
        String material = itemSection.getString("Material");
        if (material == null)
            return null;
        material = material.toUpperCase();
        if (material.contains("HELMET") || material.contains("CHESTPLATE") || material.contains("LEGGINGS") || material.contains("BOOTS"))
            if (!material.contains("LEATHER")) return ItemType.ARMOR;
            else return ItemType.LEATHER_ARMOR;
        else if (material.equals("ARMOR_STAND")) return ItemType.ARMOR_STAND;
        else if (material.equals("AXOLOTL_BUCKET")) return ItemType.AXOLOTL_BUCKET;
        else if (material.contains("BANNER")) return ItemType.BANNER;
        else if (material.equals("BOOK")) return ItemType.BOOK;
        else if (material.equals("BUNDLE")) return ItemType.BUNDLE;
        else if (material.contains("COMPASS")) return ItemType.COMPASS;
        else if (material.equals("CROSSBOW")) return ItemType.CROSSBOW;
        else if (material.contains("FIREWORK")) return ItemType.FIREWORK;
        else if (material.equals("KNOWLEDGE_BOOK")) return ItemType.KNOWLEDGE_BOOK;
        else if (material.equals("FILLED_MAP")) return ItemType.MAP;
        else if (material.contains("GOAT_CORN")) return ItemType.MUSIC_INSTRUMENT;
        else if (material.equals("OMINOUS_BOTTLE")) return ItemType.OMINOUS_BOTTLE;
        else if (material.contains("POTION")) return ItemType.POTION;
        else if (material.equals("SHIELD")) return ItemType.SHIELD;
        else if (material.contains("HEAD") || material.contains("SKULL")) return ItemType.SKULL;
        else if (material.contains("SPAWN_EGG")) return ItemType.SPAWN_EGG;
        else if (material.equals("SUSPICIOUS_STEW")) return ItemType.SUSPICIOUS_STEW;
        else if (material.equals("TROPICAL_FISH_BUCKET")) return ItemType.TROPICAL_FISH_BUCKET;
        else if (itemSection.contains("MMOCore")) return ItemType.MMOITEM;
        else if (itemSection.contains("MythicMobs")) return ItemType.MYTHIC_MOBS;
        else if (itemSection.contains("ExecutableItems")) return ItemType.EXECUTABLE_ITEMS;
        else if (itemSection.contains("Slot")) return ItemType.INVENTORY_ITEM;
        else return ItemType.BASE;
    }


    public @Nullable BaseItem getItem(String id) {
        for (BaseItem item : getCachedItems()) {
            if (item.getId().equals(id))
                return item;
        }
        return null;
    }


    public NamespacedKey getNamespacedKey(String keyStr) {
        String keyStrLowerCase = keyStr.toLowerCase();
        NamespacedKey key = new NamespacedKey("minecraft", keyStrLowerCase);
        if (keyStrLowerCase.contains(":")) {
            String[] splitEnchantName = keyStrLowerCase.split(":");
            if (splitEnchantName.length == 2) {
                key = new NamespacedKey(splitEnchantName[0], splitEnchantName[1]);
            }
        }
        return key;
    }


}
