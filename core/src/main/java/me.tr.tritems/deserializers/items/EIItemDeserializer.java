package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.EIItem;

import java.util.Map;

public class EIItemDeserializer {

    private EIItemDeserializer() {}

    public static EIItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for EIItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        EIItem item = new EIItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);
        return item;
    }
}
