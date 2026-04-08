package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrSpawnEggItem;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.entity.EntityType;

import java.util.Map;

public class TrSpawnEggItemSerializer {

    private TrSpawnEggItemSerializer() {}

    public static Map<String, Object> serialize(TrSpawnEggItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        EntityType entityType = item.getEntityType();
        if (entityType != null)
            map.put("entityType", entityType.getKey().asString());

        return map;
    }
}
