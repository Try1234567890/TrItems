package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrFireworkRocketItem;
import me.tr.tritems.serializers.SerializationException;
import me.tr.tritems.serializers.properties.TrFireworkEffectSerializer;

import java.util.Map;

public class TrFireworkRocketItemSerializer {

    private TrFireworkRocketItemSerializer() {}

    public static Map<String, Object> serialize(TrFireworkRocketItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        map.put("power", item.getPower());

        if (item.getEffects() != null && !item.getEffects().isEmpty()) {
            map.put("effects", item.getEffects().stream().map(e -> {
                try { return TrFireworkEffectSerializer.serialize(e); }
                catch (SerializationException ex) { throw new RuntimeException(ex); }
            }).toList());
        }

        return map;
    }
}
