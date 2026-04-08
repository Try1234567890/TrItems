package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.flags.TrFlag;
import me.tr.tritems.serializers.SerializationException;

public class TrFlagSerializer {

    private TrFlagSerializer() {}

    public static String serialize(TrFlag object) throws SerializationException {
        if (object.identifier() == null) throw new SerializationException("identifier is null");
        return object.identifier().toString();
    }
}
