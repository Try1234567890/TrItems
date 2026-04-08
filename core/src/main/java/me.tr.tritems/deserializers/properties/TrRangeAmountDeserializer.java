package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.amount.TrRangeAmount;

import java.util.Map;

public class TrRangeAmountDeserializer {

    private TrRangeAmountDeserializer() {}

    public static TrRangeAmount deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrRangeAmount, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        int max = getInt(map, "maxAmount", "Max");
        int min = getInt(map, "minAmount", "Min");
        boolean ender = getBoolean(map, "ender", false);
        boolean shulker = getBoolean(map, "shulker", true);

        return new TrRangeAmount(max, min, ender, shulker);
    }

    private static int getInt(Map<?, ?> map, String key, String alias) throws DeserializationException {
        Object val = map.containsKey(key) ? map.get(key) : map.get(alias);
        if (val == null) throw new DeserializationException("missing required field: " + key);
        if (val instanceof Number n) return n.intValue();
        throw new DeserializationException("expected Number for " + key + ", got: " + val.getClass().getSimpleName());
    }

    private static boolean getBoolean(Map<?, ?> map, String key, boolean defaultValue) {
        Object val = map.get(key);
        if (val instanceof Boolean b) return b;
        return defaultValue;
    }
}
