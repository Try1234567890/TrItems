package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.deserializers.properties.TrEnchantDeserializer;
import me.tr.tritems.items.TrEnchantedBookItem;

import java.util.List;
import java.util.Map;

public class TrEnchantedBookItemDeserializer {

    private TrEnchantedBookItemDeserializer() {}

    public static TrEnchantedBookItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrEnchantedBookItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrEnchantedBookItem item = new TrEnchantedBookItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object enchantsRaw = map.get("storedEnchants");
        if (enchantsRaw instanceof List<?> list)
            item.setStoredEnchants(TrItemDeserializer.deserializeList(list, TrEnchantDeserializer::deserialize));

        return item;
    }
}
