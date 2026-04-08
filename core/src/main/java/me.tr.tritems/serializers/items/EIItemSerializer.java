package me.tr.tritems.serializers.items;

import me.tr.tritems.items.EIItem;
import me.tr.tritems.serializers.SerializationException;

import java.util.Map;

public class EIItemSerializer {

    private EIItemSerializer() {}

    public static Map<String, Object> serialize(EIItem item) throws SerializationException {
        return TrItemSerializer.serialize(item);
    }
}
