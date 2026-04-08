package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrTropicalFishBucketItem;
import org.bukkit.DyeColor;
import org.bukkit.entity.TropicalFish;

import java.util.Map;

public class TrTropicalFishBucketItemDeserializer {

    private TrTropicalFishBucketItemDeserializer() {}

    public static TrTropicalFishBucketItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrTropicalFishBucketItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrTropicalFishBucketItem item = new TrTropicalFishBucketItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object bodyRaw = map.get("bodyColor");
        if (bodyRaw instanceof String str) {
            try { item.setBodyColor(DyeColor.valueOf(str.toUpperCase())); }
            catch (IllegalArgumentException e) { throw new DeserializationException("unknown DyeColor for bodyColor: " + str); }
        }

        Object patternColorRaw = map.get("patternColor");
        if (patternColorRaw instanceof String str) {
            try { item.setPatternColor(DyeColor.valueOf(str.toUpperCase())); }
            catch (IllegalArgumentException e) { throw new DeserializationException("unknown DyeColor for patternColor: " + str); }
        }

        Object patternRaw = map.get("pattern");
        if (patternRaw instanceof String str) {
            try { item.setPattern(TropicalFish.Pattern.valueOf(str.toUpperCase())); }
            catch (IllegalArgumentException e) { throw new DeserializationException("unknown TropicalFish.Pattern: " + str); }
        }

        return item;
    }
}
