package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.TrSuspiciousEffectEntry;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class TrSuspiciousEffectEntrySerializer {

    private TrSuspiciousEffectEntrySerializer() {}

    public static Map<String, Object> serialize(TrSuspiciousEffectEntry object) throws SerializationException {
        Map<String, Object> map = new HashMap<>();
        map.put("effect", effect(object));
        map.put("duration", object.getDuration());
        map.put("overwrite", object.isOverwrite());
        return map;
    }

    private static String effect(TrSuspiciousEffectEntry object) throws SerializationException {
        PotionEffectType effect = object.getEffect();
        if (effect == null) throw new SerializationException("effect is null");
        return effect.getKey().asString();
    }
}
