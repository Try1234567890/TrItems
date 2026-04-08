package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.TrPotionEffect;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class TrPotionEffectSerializer {

    private TrPotionEffectSerializer() {}

    public static Map<String, Object> serialize(TrPotionEffect object) throws SerializationException {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type(object));
        map.put("duration", object.getDuration());
        map.put("amplifier", object.getAmplifier());
        map.put("ambient", object.isAmbient());
        map.put("particles", object.isParticles());
        map.put("icon", object.isIcon());
        map.put("overwrite", object.isOverwrite());
        return map;
    }

    private static String type(TrPotionEffect object) throws SerializationException {
        PotionEffectType type = object.getType();
        if (type == null) throw new SerializationException("type is null");
        return type.getKey().asString();
    }
}
