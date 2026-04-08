package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrEnchantedBookItem;
import me.tr.tritems.serializers.SerializationException;
import me.tr.tritems.serializers.properties.TrEnchantSerializer;

import java.util.Map;

public class TrEnchantedBookItemSerializer {

    private TrEnchantedBookItemSerializer() {}

    public static Map<String, Object> serialize(TrEnchantedBookItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getStoredEnchants() != null && !item.getStoredEnchants().isEmpty()) {
            map.put("storedEnchants", item.getStoredEnchants().stream().map(e -> {
                try { return TrEnchantSerializer.serialize(e); }
                catch (SerializationException ex) { throw new RuntimeException(ex); }
            }).toList());
        }

        return map;
    }
}
