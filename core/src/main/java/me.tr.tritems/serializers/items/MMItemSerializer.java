package me.tr.tritems.serializers.items;

import me.tr.tritems.items.MMItem;
import me.tr.tritems.serializers.SerializationException;

import java.util.Map;

public class MMItemSerializer {

    private MMItemSerializer() {}

    public static Map<String, Object> serialize(MMItem item) throws SerializationException {
        return TrItemSerializer.serialize(item);
    }
}
