package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.TrFireworkEffect;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.FireworkEffect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrFireworkEffectSerializer {

    private TrFireworkEffectSerializer() {}

    public static Map<String, Object> serialize(TrFireworkEffect object) throws SerializationException {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type(object));
        map.put("colors", colors(object));
        map.put("fadeColors", fadeColors(object));
        map.put("flicker", object.isFlicker());
        map.put("trail", object.isTrail());
        return map;
    }

    private static String type(TrFireworkEffect object) throws SerializationException {
        FireworkEffect.Type type = object.getType();
        if (type == null) throw new SerializationException("type is null");
        return type.name();
    }

    private static List<String> colors(TrFireworkEffect object) throws SerializationException {
        if (object.getColors() == null) throw new SerializationException("colors is null");
        return object.getColors().stream().map(c -> c.getHex()).toList();
    }

    private static List<String> fadeColors(TrFireworkEffect object) throws SerializationException {
        if (object.getFadeColors() == null) throw new SerializationException("fadeColors is null");
        return object.getFadeColors().stream().map(c -> c.getHex()).toList();
    }
}
