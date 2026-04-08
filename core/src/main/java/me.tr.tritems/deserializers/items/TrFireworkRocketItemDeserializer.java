package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.deserializers.properties.TrFireworkEffectDeserializer;
import me.tr.tritems.items.TrFireworkRocketItem;

import java.util.List;
import java.util.Map;

public class TrFireworkRocketItemDeserializer {

    private TrFireworkRocketItemDeserializer() {}

    public static TrFireworkRocketItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrFireworkRocketItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrFireworkRocketItem item = new TrFireworkRocketItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object powerRaw = map.get("power");
        if (powerRaw instanceof Number n) item.setPower(n.intValue());

        Object effectsRaw = map.get("effects");
        if (effectsRaw instanceof List<?> list)
            item.setEffects(TrItemDeserializer.deserializeList(list, TrFireworkEffectDeserializer::deserialize));

        return item;
    }
}
