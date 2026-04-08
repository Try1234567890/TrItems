package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrPotionItem;
import me.tr.tritems.serializers.SerializationException;
import me.tr.tritems.serializers.properties.TrColorSerializer;
import me.tr.tritems.serializers.properties.TrPotionEffectSerializer;
import org.bukkit.potion.PotionType;

import java.util.Map;

public class TrPotionItemSerializer {

    private TrPotionItemSerializer() {}

    public static Map<String, Object> serialize(TrPotionItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getColor() != null)
            map.put("color", TrColorSerializer.serialize(item.getColor()));

        if (item.getCustomName() != null)
            map.put("customName", item.getCustomName());

        PotionType base = item.getBasePotionType();
        if (base != null)
            map.put("basePotionType", base.getKey().asString());

        if (item.getEffects() != null && !item.getEffects().isEmpty()) {
            map.put("effects", item.getEffects().stream().map(e -> {
                try { return TrPotionEffectSerializer.serialize(e); }
                catch (SerializationException ex) { throw new RuntimeException(ex); }
            }).toList());
        }

        return map;
    }
}
