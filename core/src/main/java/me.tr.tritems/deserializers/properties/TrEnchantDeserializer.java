package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.enchants.TrEnchant;
import me.tr.tritems.properties.enchants.TrEnchantEntry;
import me.tr.tritems.properties.identification.TrIdentifier;

import java.util.Map;

public class TrEnchantDeserializer {

    private TrEnchantDeserializer() {}

    public static TrEnchant deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrEnchant, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrEnchantEntry entry = enchant(map);
        int level = level(map);
        return new TrEnchant(entry, level);
    }

    private static TrEnchantEntry enchant(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("enchant");
        if (!(raw instanceof String str)) throw new DeserializationException("missing or invalid 'enchant' field");
        TrIdentifier id = TrIdentifier.from(str);
        TrEnchantEntry entry = id != null ? TrEnchantEntry.getEnchantment(id) : null;
        if (entry == null) entry = TrEnchantEntry.getEnchantment(str);
        if (entry == null) throw new DeserializationException("unknown enchant: " + str);
        return entry;
    }

    private static int level(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("level");
        if (raw instanceof Number n) return n.intValue();
        throw new DeserializationException("missing or invalid 'level' field");
    }
}
