package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrWrittenBookItem;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;
import java.util.Map;

public class TrWrittenBookItemDeserializer {

    private TrWrittenBookItemDeserializer() {}

    public static TrWrittenBookItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrWrittenBookItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrWrittenBookItem item = new TrWrittenBookItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object pagesRaw = map.get("pages");
        if (pagesRaw instanceof List<?> list)
            item.setPages(list.stream().filter(o -> o instanceof String).map(o -> (String) o).toList());

        Object authorRaw = map.get("author");
        if (authorRaw instanceof String s) item.setAuthor(s);

        Object titleRaw = map.get("title");
        if (titleRaw instanceof String s) item.setTitle(s);

        Object genRaw = map.get("generation");
        if (genRaw instanceof String str) {
            try { item.setGeneration(BookMeta.Generation.valueOf(str.toUpperCase())); }
            catch (IllegalArgumentException e) { throw new DeserializationException("unknown BookMeta.Generation: " + str); }
        }

        return item;
    }
}
