package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrFireworkStarItem;
import me.tr.tritems.serializers.SerializationException;
import me.tr.tritems.serializers.properties.TrFireworkEffectSerializer;

import java.util.Map;

public class TrFireworkStarItemSerializer {

    private TrFireworkStarItemSerializer() {}

    public static Map<String, Object> serialize(TrFireworkStarItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getEffect() != null)
            map.put("effect", TrFireworkEffectSerializer.serialize(item.getEffect()));

        return map;
    }
}
