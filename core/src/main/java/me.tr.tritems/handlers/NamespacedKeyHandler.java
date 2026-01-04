package me.tr.tritems.handlers;

import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.NamespacedKey;

import java.util.Map;

public class NamespacedKeyHandler implements TypeHandler {
    public static final NamespacedKeyHandler INSTANCE = new NamespacedKeyHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {
        if (o instanceof String str) {
            return NamespacedKey.fromString(str);
        }

        if (o instanceof Map<?, ?> map) {
            String ID = (String) map.get(TrIdentifier.getKey());
            String namespace = (String) map.get("Namespace");

            if (ID == null)
                return null;

            return new NamespacedKey(namespace == null ? "tr_items" : namespace, ID);
        }

        return null;
    }

    @Override
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof NamespacedKey key)
            return key.toString();
        return null;
    }
}
