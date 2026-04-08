package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.flags.TrFlag;
import me.tr.tritems.properties.identification.TrIdentifier;

public class TrFlagDeserializer {

    private TrFlagDeserializer() {}

    public static TrFlag deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof String str))
            throw new DeserializationException("expected String for TrFlag, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrIdentifier id = TrIdentifier.from(str);
        TrFlag flag = id != null ? TrFlag.getFlag(id) : null;
        if (flag == null) flag = TrFlag.getFlag(str);
        if (flag == null) throw new DeserializationException("unknown flag: " + str);
        return flag;
    }
}
