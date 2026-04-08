package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrAnimalArmorItem;
import me.tr.tritems.serializers.SerializationException;
import me.tr.tritems.serializers.properties.TrColorSerializer;

import java.util.Map;

public class TrAnimalArmorItemSerializer {

    private TrAnimalArmorItemSerializer() {}

    public static Map<String, Object> serialize(TrAnimalArmorItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getColor() != null)
            map.put("color", TrColorSerializer.serialize(item.getColor()));

        return map;
    }
}
