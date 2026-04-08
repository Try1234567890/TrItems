package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.custommodeldata.TrIntegerCustomModelData;

public class TrIntegerCustomModelDataDeserializer {

    private TrIntegerCustomModelDataDeserializer() {}

    public static TrIntegerCustomModelData deserialize(Object raw) throws DeserializationException {
        if (raw instanceof Number n) return new TrIntegerCustomModelData(n.intValue());
        throw new DeserializationException("expected Number for TrIntegerCustomModelData, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));
    }
}
