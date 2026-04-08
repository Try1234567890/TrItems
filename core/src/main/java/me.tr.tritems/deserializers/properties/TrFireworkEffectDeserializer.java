package me.tr.tritems.deserializers.properties;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.TrFireworkEffect;
import me.tr.tritems.properties.color.TrColor;
import org.bukkit.FireworkEffect;

import java.util.List;
import java.util.Map;

public class TrFireworkEffectDeserializer {

    private TrFireworkEffectDeserializer() {}

    public static TrFireworkEffect deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrFireworkEffect, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        FireworkEffect.Type type = type(map);
        List<TrColor> colors = colorList(map, "colors");
        List<TrColor> fadeColors = colorList(map, "fadeColors");
        boolean flicker = map.get("flicker") instanceof Boolean b && b;
        boolean trail = map.get("trail") instanceof Boolean b && b;

        return new TrFireworkEffect(colors, fadeColors, type, flicker, trail);
    }

    private static FireworkEffect.Type type(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("type");
        if (!(raw instanceof String str)) throw new DeserializationException("missing or invalid 'type' field");
        try {
            return FireworkEffect.Type.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DeserializationException("unknown FireworkEffect.Type: " + str);
        }
    }

    private static List<TrColor> colorList(Map<?, ?> map, String key) throws DeserializationException {
        Object raw = map.get(key);
        if (raw == null) return List.of();
        if (!(raw instanceof List<?> list))
            throw new DeserializationException("expected List for " + key + ", got: " + raw.getClass().getSimpleName());
        try {
            return list.stream().map(o -> new TrColor((String) o)).toList();
        } catch (ClassCastException e) {
            throw new DeserializationException("invalid element type in " + key);
        }
    }
}
