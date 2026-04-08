package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.deserializers.properties.TrFireworkEffectDeserializer;
import me.tr.tritems.items.TrFireworkStarItem;

import java.util.Map;

public class TrFireworkStarItemDeserializer {

    private TrFireworkStarItemDeserializer() {}

    public static TrFireworkStarItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrFireworkStarItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrFireworkStarItem item = new TrFireworkStarItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object effectRaw = map.get("effect");
        if (effectRaw != null) item.setEffect(TrFireworkEffectDeserializer.deserialize(effectRaw));

        return item;
    }
}
