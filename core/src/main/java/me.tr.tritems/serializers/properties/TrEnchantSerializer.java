package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.enchants.TrEnchant;
import me.tr.tritems.properties.enchants.TrEnchantEntry;
import me.tr.tritems.serializers.SerializationException;

import java.util.HashMap;
import java.util.Map;

public class TrEnchantSerializer {

    private TrEnchantSerializer() {}

    public static Map<String, Object> serialize(TrEnchant object) throws SerializationException {
        Map<String, Object> map = new HashMap<>();
        map.put("enchant", enchant(object));
        map.put("level", object.level());
        return map;
    }

    private static String enchant(TrEnchant object) throws SerializationException {
        TrEnchantEntry entry = object.enchant();
        if (entry == null) throw new SerializationException("enchant is null");
        return entry.identifier().toString();
    }
}
