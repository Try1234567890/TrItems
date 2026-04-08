package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.deserializers.properties.TrColorDeserializer;
import me.tr.tritems.deserializers.properties.TrPotionEffectDeserializer;
import me.tr.tritems.items.TrPotionItem;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionType;

import java.util.List;
import java.util.Map;

public class TrPotionItemDeserializer {

    private TrPotionItemDeserializer() {}

    public static TrPotionItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrPotionItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrPotionItem item = new TrPotionItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object colorRaw = map.get("color");
        if (colorRaw != null) item.setColor(TrColorDeserializer.deserialize(colorRaw));

        Object nameRaw = map.get("customName");
        if (nameRaw instanceof String s) item.setCustomName(s);

        Object baseRaw = map.get("basePotionType");
        if (baseRaw instanceof String str) {
            NamespacedKey key = NamespacedKey.fromString(str);
            if (key == null) throw new DeserializationException("invalid NamespacedKey for basePotionType: " + str);
            PotionType type = org.bukkit.Registry.POTION.get(key);
            if (type == null) throw new DeserializationException("unknown PotionType: " + str);
            item.setBasePotionType(type);
        }

        Object effectsRaw = map.get("effects");
        if (effectsRaw instanceof List<?> list)
            item.setEffects(TrItemDeserializer.deserializeList(list, TrPotionEffectDeserializer::deserialize));

        return item;
    }
}
