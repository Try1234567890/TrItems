package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.owner.TrOwner;

import java.util.UUID;

public class TrOwnerDeserializer {

    private TrOwnerDeserializer() {}

    public static TrOwner deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof String str))
            throw new DeserializationException("expected String for TrOwner, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));
        try {
            return new TrOwner(UUID.fromString(str));
        } catch (IllegalArgumentException e) {
            throw new DeserializationException("invalid UUID for TrOwner: " + str);
        }
    }
}
