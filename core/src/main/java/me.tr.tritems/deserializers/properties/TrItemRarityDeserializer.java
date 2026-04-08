package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.properties.rarity.TrItemRarity;

import java.util.Map;

public class TrItemRarityDeserializer {

    private TrItemRarityDeserializer() {}

    public static TrItemRarity deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrItemRarity, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        Object idRaw = map.get("identifier");
        if (!(idRaw instanceof String idStr))
            throw new DeserializationException("missing or invalid 'identifier' field");

        TrIdentifier id = TrIdentifier.from(idStr);
        if (id == null) throw new DeserializationException("invalid identifier: " + idStr);

        Object colorRaw = map.get("color");
        if (colorRaw instanceof String hex) return new TrItemRarity(id, new TrColor(hex));
        return new TrItemRarity(id);
    }
}
