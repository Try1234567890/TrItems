package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrLeatherArmorItem;
import me.tr.tritems.serializers.SerializationException;
import me.tr.tritems.serializers.properties.TrColorSerializer;
import org.bukkit.inventory.meta.trim.ArmorTrim;

import java.util.Map;

public class TrLeatherArmorItemSerializer {

    private TrLeatherArmorItemSerializer() {}

    public static Map<String, Object> serialize(TrLeatherArmorItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getColor() != null)
            map.put("color", TrColorSerializer.serialize(item.getColor()));

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
