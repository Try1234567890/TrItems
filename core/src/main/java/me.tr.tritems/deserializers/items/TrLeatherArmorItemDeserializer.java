package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.deserializers.properties.TrColorDeserializer;
import me.tr.tritems.items.TrLeatherArmorItem;

import java.util.Map;

public class TrLeatherArmorItemDeserializer {

    private TrLeatherArmorItemDeserializer() {}

    public static TrLeatherArmorItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrLeatherArmorItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrLeatherArmorItem item = new TrLeatherArmorItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object colorRaw = map.get("color");
        if (colorRaw != null) item.setColor(TrColorDeserializer.deserialize(colorRaw));

        Object trimRaw = map.get("trim");
        if (trimRaw instanceof Map<?, ?> trimMap) item.setTrim(TrArmorItemDeserializer.trim(trimMap));

        return item;
    }
}
