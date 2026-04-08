package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrShieldItem;
import org.bukkit.DyeColor;

import java.util.Map;

public class TrShieldItemDeserializer {

    private TrShieldItemDeserializer() {}

    public static TrShieldItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrShieldItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrShieldItem item = new TrShieldItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object colorRaw = map.get("color");
        if (colorRaw instanceof String str) {
            try { item.setColor(DyeColor.valueOf(str.toUpperCase())); }
            catch (IllegalArgumentException e) { throw new DeserializationException("unknown DyeColor: " + str); }
        }

        return item;
    }
}
