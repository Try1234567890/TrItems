package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrShieldItem;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.DyeColor;

import java.util.Map;

public class TrShieldItemSerializer {

    private TrShieldItemSerializer() {}

    public static Map<String, Object> serialize(TrShieldItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        DyeColor color = item.getColor();
        if (color != null)
            map.put("color", color.name());

        return map;
    }
}
