package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrKnowledgeBookItem;
import me.tr.tritems.serializers.SerializationException;

import java.util.Map;

public class TrKnowledgeBookItemSerializer {

    private TrKnowledgeBookItemSerializer() {}

    public static Map<String, Object> serialize(TrKnowledgeBookItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getBookRecipes() != null && !item.getBookRecipes().isEmpty())
            map.put("recipes", item.getBookRecipes().stream().map(k -> k.asString()).toList());

        return map;
    }
}
