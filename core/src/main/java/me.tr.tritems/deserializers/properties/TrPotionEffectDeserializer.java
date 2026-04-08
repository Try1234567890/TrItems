package me.tr.tritems.deserializers.properties;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.TrPotionEffect;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

public class TrPotionEffectDeserializer {

    private TrPotionEffectDeserializer() {}

    public static TrPotionEffect deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrPotionEffect, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        PotionEffectType type = type(map);
        int duration = getInt(map, "duration");
        int amplifier = getInt(map, "amplifier");
        boolean ambient = map.get("ambient") instanceof Boolean b && b;
        boolean particles = !(map.get("particles") instanceof Boolean b) || b;
        boolean icon = !(map.get("icon") instanceof Boolean b) || b;
        boolean overwrite = map.get("overwrite") instanceof Boolean b && b;

        return new TrPotionEffect(type, duration, amplifier, ambient, particles, icon, overwrite);
    }

    private static PotionEffectType type(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("type");
        if (!(raw instanceof String str)) throw new DeserializationException("missing or invalid 'type' field");
        NamespacedKey key = NamespacedKey.fromString(str);
        if (key == null) throw new DeserializationException("invalid NamespacedKey for type: " + str);
        PotionEffectType type = RegistryAccess.registryAccess().getRegistry(RegistryKey.MOB_EFFECT).get(key);
        if (type == null) throw new DeserializationException("unknown PotionEffectType: " + str);
        return type;
    }

    private static int getInt(Map<?, ?> map, String key) throws DeserializationException {
        Object val = map.get(key);
        if (val instanceof Number n) return n.intValue();
        throw new DeserializationException("missing or invalid '" + key + "' field");
    }
}
