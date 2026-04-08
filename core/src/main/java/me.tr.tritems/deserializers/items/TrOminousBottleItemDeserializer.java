package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrOminousBottleItem;

import java.util.Map;

public class TrOminousBottleItemDeserializer {

    private TrOminousBottleItemDeserializer() {}

    public static TrOminousBottleItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrOminousBottleItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrOminousBottleItem item = new TrOminousBottleItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object ampRaw = map.get("amplifier");
        if (ampRaw instanceof Number n) item.setAmplifier(n.intValue());

        return item;
    }
}
