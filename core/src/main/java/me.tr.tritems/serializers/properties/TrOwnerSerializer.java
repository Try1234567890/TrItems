package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.owner.TrOwner;
import me.tr.tritems.serializers.SerializationException;

import java.util.UUID;

public class TrOwnerSerializer {

    private TrOwnerSerializer() {}

    public static String serialize(TrOwner object) throws SerializationException {
        UUID uuid = object.getUUID();
        if (uuid == null) throw new SerializationException("uuid is null");
        return uuid.toString();
    }
}
