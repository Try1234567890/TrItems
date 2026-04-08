package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrBundleItem;

import java.util.List;
import java.util.Map;

public class TrBundleItemDeserializer {

    private TrBundleItemDeserializer() {}

    public static TrBundleItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrBundleItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrBundleItem item = new TrBundleItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object itemsRaw = map.get("items");
        if (itemsRaw instanceof List<?> list)
            item.setItems(TrItemDeserializer.deserializeList(list, TrItemBaseDeserializer::deserialize));

        return item;
    }
}
