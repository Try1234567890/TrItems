package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrWritableBookItem;
import me.tr.tritems.serializers.SerializationException;

import java.util.Map;

public class TrWritableBookItemSerializer {

    private TrWritableBookItemSerializer() {}

    public static Map<String, Object> serialize(TrWritableBookItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getPages() != null && !item.getPages().isEmpty())
            map.put("pages", item.getPages());

        return map;
    }
}
