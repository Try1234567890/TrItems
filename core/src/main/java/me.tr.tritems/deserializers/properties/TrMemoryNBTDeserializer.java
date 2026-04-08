package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.nbts.TrMemoryNBT;

import java.util.Map;

public class TrMemoryNBTDeserializer {

    private TrMemoryNBTDeserializer() {}

    @SuppressWarnings("unchecked")
    public static <T> TrMemoryNBT<T> deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrMemoryNBT, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        Object compound = map.get("compound");
        if (!(compound instanceof String compoundStr))
            throw new DeserializationException("missing or invalid 'compound' field");

        Object value = map.get("value");
        if (value == null)
            throw new DeserializationException("missing 'value' field");

        return new TrMemoryNBT<>(compoundStr, (T) value);
    }
}
