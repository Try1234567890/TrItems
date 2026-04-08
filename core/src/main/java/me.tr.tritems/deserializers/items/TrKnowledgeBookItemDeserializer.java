package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrKnowledgeBookItem;
import org.bukkit.NamespacedKey;

import java.util.List;
import java.util.Map;

public class TrKnowledgeBookItemDeserializer {

    private TrKnowledgeBookItemDeserializer() {}

    public static TrKnowledgeBookItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrKnowledgeBookItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrKnowledgeBookItem item = new TrKnowledgeBookItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object recipesRaw = map.get("recipes");
        if (recipesRaw instanceof List<?> list)
            item.setBookRecipes(TrItemDeserializer.deserializeList(list, TrKnowledgeBookItemDeserializer::namespacedKey));

        return item;
    }

    private static NamespacedKey namespacedKey(Object raw) throws DeserializationException {
        if (!(raw instanceof String str)) throw new DeserializationException("expected String for NamespacedKey");
        NamespacedKey key = NamespacedKey.fromString(str);
        if (key == null) throw new DeserializationException("invalid NamespacedKey: " + str);
        return key;
    }
}
