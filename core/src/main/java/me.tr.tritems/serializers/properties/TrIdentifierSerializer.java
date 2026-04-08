package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.serializers.SerializationException;

public class TrIdentifierSerializer {

    private TrIdentifierSerializer() {}

    public static String serialize(TrIdentifier object) throws SerializationException {
        if (object.getIdentifier() == null) throw new SerializationException("identifier is null");
        return object.toString();
    }
}
