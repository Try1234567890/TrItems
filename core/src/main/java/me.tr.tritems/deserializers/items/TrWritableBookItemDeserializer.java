package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrWritableBookItem;

import java.util.List;
import java.util.Map;

public class TrWritableBookItemDeserializer {

    private TrWritableBookItemDeserializer() {}

    public static TrWritableBookItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrWritableBookItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrWritableBookItem item = new TrWritableBookItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object pagesRaw = map.get("pages");
        if (pagesRaw instanceof List<?> list)
            item.setPages(list.stream().filter(o -> o instanceof String).map(o -> (String) o).toList());

        return item;
    }
}
