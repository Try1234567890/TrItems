package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.color.TrColor;

public class TrColorDeserializer {

    private TrColorDeserializer() {}

    public static TrColor deserialize(Object raw) throws DeserializationException {
        if (raw instanceof String str) {
            if (str.isBlank()) throw new DeserializationException("hex color is blank");
            return new TrColor(str);
        }
        throw new DeserializationException("expected String for TrColor, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));
    }
}
