package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrSuspiciousStewItem;
import me.tr.tritems.serializers.SerializationException;
import me.tr.tritems.serializers.properties.TrSuspiciousEffectEntrySerializer;

import java.util.Map;

public class TrSuspiciousStewItemSerializer {

    private TrSuspiciousStewItemSerializer() {}

    public static Map<String, Object> serialize(TrSuspiciousStewItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getEffects() != null && !item.getEffects().isEmpty()) {
            map.put("effects", item.getEffects().stream().map(e -> {
                try { return TrSuspiciousEffectEntrySerializer.serialize(e); }
                catch (SerializationException ex) { throw new RuntimeException(ex); }
            }).toList());
        }

        return map;
    }
}
