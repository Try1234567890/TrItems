package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.serializers.SerializationException;

public class TrColorSerializer {

    private TrColorSerializer() {}

    public static String serialize(TrColor object) throws SerializationException {
        String hex = object.getHex();
        if (hex == null) throw new SerializationException("hex is null");
        return hex;
    }
}
