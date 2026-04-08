package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.deserializers.properties.TrSuspiciousEffectEntryDeserializer;
import me.tr.tritems.items.TrSuspiciousStewItem;

import java.util.List;
import java.util.Map;

public class TrSuspiciousStewItemDeserializer {

    private TrSuspiciousStewItemDeserializer() {}

    public static TrSuspiciousStewItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrSuspiciousStewItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrSuspiciousStewItem item = new TrSuspiciousStewItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object effectsRaw = map.get("effects");
        if (effectsRaw instanceof List<?> list)
            item.setEffects(TrItemDeserializer.deserializeList(list, TrSuspiciousEffectEntryDeserializer::deserialize));

        return item;
    }
}
