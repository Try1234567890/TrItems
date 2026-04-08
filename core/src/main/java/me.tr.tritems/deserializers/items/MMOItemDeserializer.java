package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.MMOItem;

import java.util.Map;

public class MMOItemDeserializer {

    private MMOItemDeserializer() {}

    public static MMOItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for MMOItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        MMOItem item = new MMOItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);
        return item;
    }
}
