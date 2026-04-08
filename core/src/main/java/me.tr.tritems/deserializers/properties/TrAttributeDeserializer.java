package me.tr.tritems.deserializers.properties;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.properties.TrAttribute;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;

import java.util.Map;

public class TrAttributeDeserializer {

    private TrAttributeDeserializer() {}

    public static TrAttribute deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrAttribute, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        Attribute attribute = attribute(map);
        NamespacedKey key = key(map);
        double amount = amount(map);
        AttributeModifier.Operation operation = operation(map);

        return new TrAttribute(attribute, key, amount, operation);
    }

    private static Attribute attribute(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("attribute");
        if (!(raw instanceof String str)) throw new DeserializationException("missing or invalid 'attribute' field");
        NamespacedKey nk = NamespacedKey.fromString(str);
        if (nk == null) throw new DeserializationException("invalid NamespacedKey for attribute: " + str);
        Attribute attr = RegistryAccess.registryAccess().getRegistry(RegistryKey.ATTRIBUTE).get(nk);
        if (attr == null) throw new DeserializationException("unknown Attribute: " + str);
        return attr;
    }

    private static NamespacedKey key(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("key");
        if (!(raw instanceof String str)) throw new DeserializationException("missing or invalid 'key' field");
        NamespacedKey nk = NamespacedKey.fromString(str);
        if (nk == null) throw new DeserializationException("invalid NamespacedKey for key: " + str);
        return nk;
    }

    private static double amount(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("amount");
        if (raw instanceof Number n) return n.doubleValue();
        if (raw instanceof String s) {
            try { return Double.parseDouble(s); }
            catch (NumberFormatException e) { throw new DeserializationException("invalid amount: " + s); }
        }
        throw new DeserializationException("missing or invalid 'amount' field");
    }

    private static AttributeModifier.Operation operation(Map<?, ?> map) throws DeserializationException {
        Object raw = map.get("operation");
        if (!(raw instanceof String str)) throw new DeserializationException("missing or invalid 'operation' field");
        try {
            return AttributeModifier.Operation.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new DeserializationException("unknown Operation: " + str);
        }
    }
}
