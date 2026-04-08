package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrWrittenBookItem;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Map;

public class TrWrittenBookItemSerializer {

    private TrWrittenBookItemSerializer() {}

    public static Map<String, Object> serialize(TrWrittenBookItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getPages() != null && !item.getPages().isEmpty())
            map.put("pages", item.getPages());

        if (item.getAuthor() != null)
            map.put("author", item.getAuthor());

        if (item.getTitle() != null)
            map.put("title", item.getTitle());

        BookMeta.Generation generation = item.getGeneration();
        if (generation != null)
            map.put("generation", generation.name());

        return map;
    }
}
