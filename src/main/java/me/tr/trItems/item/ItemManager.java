package me.tr.trItems.item;

import me.tr.trItems.item.items.TrBaseItem;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemManager {
    private static ItemManager instance;
    private final Map<String, TrBaseItem> cache = new HashMap<>();

    private ItemManager() {
    }

    public static ItemManager getInstance() {
        if (instance == null) {
            instance = new ItemManager();
        }
        return instance;
    }

    public Map<String, TrBaseItem> getCache() {
        return cache;
    }

    public @Nullable TrBaseItem getItem(String id) {
        if (getCache().containsKey(id)) {
            return getCache().get(id);
        }
        return null;
    }

    public @Nullable List<TrBaseItem> getItems(String... ids) {
        final List<TrBaseItem> items = new ArrayList<>();
        for (String id : ids) {
            TrBaseItem item = getItem(id);
            if (item != null)
                items.add(item);
        }
        return items;
    }

    public NamespacedKey parseNamespacedKey(String keyStr) {
        String keyStrLowerCase = keyStr.toLowerCase();
        NamespacedKey namespacedKey = new NamespacedKey("minecraft", keyStrLowerCase); // Case: 'example'
        int colonIndex = keyStrLowerCase.indexOf(':');
        if (colonIndex != -1) {
            String namespace = keyStrLowerCase.substring(0, colonIndex);
            if (colonIndex >= (keyStrLowerCase.length() - 1)) { // Case: 'example:'
                return new NamespacedKey(namespace, keyStrLowerCase.substring(0, keyStrLowerCase.length() - 1));
            }
            String key = keyStr.substring(colonIndex + 1); // Case: 'minecraft:example'
            return new NamespacedKey(namespace, key);
        }
        return namespacedKey;
    }


}
