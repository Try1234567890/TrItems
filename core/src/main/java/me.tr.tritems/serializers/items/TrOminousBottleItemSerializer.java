package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrOminousBottleItem;
import me.tr.tritems.serializers.SerializationException;

import java.util.Map;

public class TrOminousBottleItemSerializer {

    private TrOminousBottleItemSerializer() {}

    public static Map<String, Object> serialize(TrOminousBottleItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);
        map.put("amplifier", item.getAmplifier());
        return map;
    }
}
