package me.tr.tritems.deserializers.properties;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.TrSuspiciousEffectEntry;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

public class TrSuspiciousEffectEntryDeserializer {

    private TrSuspiciousEffectEntryDeserializer() {}

    public static TrSuspiciousEffectEntry deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrSuspiciousEffectEntry, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        PotionEffectType effect = effect(map);
        int duration = duration(map);
        boolean overwrite = map.get("overwrite") instanceof Boolean b && b;

        return new TrSuspiciousEffectEntry(effect, duration, overwrite);
    }

    private static PotionEffectType effect(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("effect");
        if (!(raw instanceof String str)) throw new DeserializationException("missing or invalid 'effect' field");
        NamespacedKey key = NamespacedKey.fromString(str);
        if (key == null) throw new DeserializationException("invalid NamespacedKey for effect: " + str);
        PotionEffectType type = RegistryAccess.registryAccess().getRegistry(RegistryKey.MOB_EFFECT).get(key);
        if (type == null) throw new DeserializationException("unknown PotionEffectType: " + str);
        return type;
    }

    private static int duration(Map<?, ?> map) throws DeserializationException {
        Object val = map.get("duration");
        if (val instanceof Number n) return n.intValue();
        throw new DeserializationException("missing or invalid 'duration' field");
    }
}
