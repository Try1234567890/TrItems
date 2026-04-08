package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.TrAttribute;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;

import java.util.HashMap;
import java.util.Map;

public class TrAttributeSerializer {

    private TrAttributeSerializer() {}

    public static Map<String, Object> serialize(TrAttribute object) throws SerializationException {
        Map<String, Object> map = new HashMap<>();
        map.put("attribute", attribute(object));
        map.put("key", key(object));
        map.put("operation", operation(object));
        map.put("amount", amount(object));
        return map;
    }

    private static String attribute(TrAttribute object) throws SerializationException {
        Attribute attribute = object.getAttribute();
        if (attribute == null) {
            throw new SerializationException("attribute is null");
        }
        return attribute.getKey().asString();
    }

    private static String key(TrAttribute object) throws SerializationException {
        NamespacedKey key = object.getKey();
        if (key == null) {
            throw new SerializationException("key is null");
        }
        return key.asString();
    }

    private static String amount(TrAttribute object) throws SerializationException {
        return String.valueOf(object.getAmount());
    }

    private static String operation(TrAttribute object) throws SerializationException {
        AttributeModifier.Operation operation = object.getOperation();
        if (operation == null) {
            throw new SerializationException("operation is null");
        }
        return operation.name();
    }
}
