package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrItem;

import java.util.Map;

public class TrItemBaseDeserializer {

    private TrItemBaseDeserializer() {}

    public static TrItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrItem item = new TrItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);
        return item;
    }
}
