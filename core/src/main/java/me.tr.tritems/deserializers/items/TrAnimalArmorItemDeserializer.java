package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.deserializers.properties.TrColorDeserializer;
import me.tr.tritems.items.TrAnimalArmorItem;

import java.util.Map;

public class TrAnimalArmorItemDeserializer {

    private TrAnimalArmorItemDeserializer() {}

    public static TrAnimalArmorItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrAnimalArmorItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrAnimalArmorItem item = new TrAnimalArmorItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object colorRaw = map.get("color");
        if (colorRaw != null) item.setColor(TrColorDeserializer.deserialize(colorRaw));

        return item;
    }
}
