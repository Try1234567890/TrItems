package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrCrossbowItem;

import java.util.List;
import java.util.Map;

public class TrCrossbowItemDeserializer {

    private TrCrossbowItemDeserializer() {}

    public static TrCrossbowItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrCrossbowItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrCrossbowItem item = new TrCrossbowItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object projectilesRaw = map.get("chargedProjectiles");
        if (projectilesRaw instanceof List<?> list)
            item.setChargedProjectiles(TrItemDeserializer.deserializeList(list, TrItemBaseDeserializer::deserialize));

        return item;
    }
}
