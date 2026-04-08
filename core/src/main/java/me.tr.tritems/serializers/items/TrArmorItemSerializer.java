package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrArmorItem;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.inventory.meta.trim.ArmorTrim;

import java.util.Map;

public class TrArmorItemSerializer {

    private TrArmorItemSerializer() {}

    public static Map<String, Object> serialize(TrArmorItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        ArmorTrim trim = item.getTrim();
        if (trim != null) {
            map.put("trim", Map.of(
                    "material", trim.getMaterial().getKey().asString(),
                    "pattern", trim.getPattern().getKey().asString()
            ));
        }

        return map;
    }
}
