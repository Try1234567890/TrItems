package me.tr.tritems.serializers.items;

import me.tr.tritems.items.MMOItem;
import me.tr.tritems.serializers.SerializationException;

import java.util.Map;

public class MMOItemSerializer {

    private MMOItemSerializer() {}

    public static Map<String, Object> serialize(MMOItem item) throws SerializationException {
        return TrItemSerializer.serialize(item);
    }
}
