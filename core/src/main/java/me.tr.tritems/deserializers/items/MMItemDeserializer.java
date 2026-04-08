package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.MMItem;

import java.util.Map;

public class MMItemDeserializer {

    private MMItemDeserializer() {}

    public static MMItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for MMItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        MMItem item = new MMItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);
        return item;
    }
}
