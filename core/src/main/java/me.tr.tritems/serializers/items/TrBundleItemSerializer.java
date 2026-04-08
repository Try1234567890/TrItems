package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrBundleItem;
import me.tr.tritems.serializers.SerializationException;

import java.util.Map;

public class TrBundleItemSerializer {

    private TrBundleItemSerializer() {}

    public static Map<String, Object> serialize(TrBundleItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getItems() != null && !item.getItems().isEmpty()) {
            map.put("items", item.getItems().stream().map(i -> {
                try { return TrItemSerializer.serialize(i); }
                catch (SerializationException e) { throw new RuntimeException(e); }
            }).toList());
        }

        return map;
    }
}
