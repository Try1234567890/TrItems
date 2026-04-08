package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrCrossbowItem;
import me.tr.tritems.serializers.SerializationException;

import java.util.Map;

public class TrCrossbowItemSerializer {

    private TrCrossbowItemSerializer() {}

    public static Map<String, Object> serialize(TrCrossbowItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getChargedProjectiles() != null && !item.getChargedProjectiles().isEmpty()) {
            map.put("chargedProjectiles", item.getChargedProjectiles().stream().map(i -> {
                try { return TrItemSerializer.serialize(i); }
                catch (SerializationException e) { throw new RuntimeException(e); }
            }).toList());
        }

        return map;
    }
}
