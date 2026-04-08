package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrTropicalFishBucketItem;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.DyeColor;
import org.bukkit.entity.TropicalFish;

import java.util.Map;

public class TrTropicalFishBucketItemSerializer {

    private TrTropicalFishBucketItemSerializer() {}

    public static Map<String, Object> serialize(TrTropicalFishBucketItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        DyeColor bodyColor = item.getBodyColor();
        if (bodyColor != null)
            map.put("bodyColor", bodyColor.name());

        DyeColor patternColor = item.getPatternColor();
        if (patternColor != null)
            map.put("patternColor", patternColor.name());

        TropicalFish.Pattern pattern = item.getPattern();
        if (pattern != null)
            map.put("pattern", pattern.name());

        return map;
    }
}
