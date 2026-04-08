package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.identification.TrIdentifier;

public class TrIdentifierDeserializer {

    private TrIdentifierDeserializer() {}

    public static TrIdentifier deserialize(Object raw) throws DeserializationException {
        if (raw instanceof String str) {
            TrIdentifier id = TrIdentifier.from(str);
            if (id == null) throw new DeserializationException("invalid identifier: " + str);
            return id;
        }
        throw new DeserializationException("expected String for TrIdentifier, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));
    }
}
