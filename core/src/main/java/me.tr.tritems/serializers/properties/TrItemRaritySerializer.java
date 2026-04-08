package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.rarity.TrItemRarity;
import me.tr.tritems.serializers.SerializationException;

import java.util.HashMap;
import java.util.Map;

public class TrItemRaritySerializer {

    private TrItemRaritySerializer() {}

    public static Map<String, Object> serialize(TrItemRarity object) throws SerializationException {
        Map<String, Object> map = new HashMap<>();
        if (object.identifier() == null) throw new SerializationException("identifier is null");
        map.put("identifier", object.identifier().toString());
        if (object.getColor() != null)
            map.put("color", object.getColor().getHex());
        return map;
    }
}
