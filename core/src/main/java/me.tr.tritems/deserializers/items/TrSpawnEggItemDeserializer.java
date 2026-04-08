package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrSpawnEggItem;
import org.bukkit.entity.EntityType;

import java.util.Map;

public class TrSpawnEggItemDeserializer {

    private TrSpawnEggItemDeserializer() {}

    public static TrSpawnEggItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrSpawnEggItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrSpawnEggItem item = new TrSpawnEggItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object typeRaw = map.get("entityType");
        if (typeRaw instanceof String str) {
            org.bukkit.NamespacedKey key = org.bukkit.NamespacedKey.fromString(str);
            EntityType type = key != null
                    ? io.papermc.paper.registry.RegistryAccess.registryAccess()
                        .getRegistry(io.papermc.paper.registry.RegistryKey.ENTITY_TYPE).get(key)
                    : null;
            if (type == null) throw new DeserializationException("unknown EntityType: " + str);
            item.setEntityType(type);
        }

        return item;
    }
}
