package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrSkullItem;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;

import java.util.Map;
import java.util.UUID;

public class TrSkullItemDeserializer {

    private TrSkullItemDeserializer() {}

    public static TrSkullItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrSkullItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrSkullItem item = new TrSkullItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object soundRaw = map.get("sound");
        if (soundRaw instanceof String str) {
            NamespacedKey key = NamespacedKey.fromString(str);
            if (key == null) throw new DeserializationException("invalid NamespacedKey for sound: " + str);
            item.setSound(key);
        }

        Object ownerRaw = map.get("skullOwner");
        if (ownerRaw instanceof String str) {
            try { item.setSkullOwner(Bukkit.getOfflinePlayer(UUID.fromString(str))); }
            catch (IllegalArgumentException e) { item.setSkullOwner(Bukkit.getOfflinePlayer(str)); }
        }

        return item;
    }
}
