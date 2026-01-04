package me.tr.tritems.handlers;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;

public class AttributeHandler implements TypeHandler {
    public static final AttributeHandler INSTANCE = new AttributeHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {
        if (o instanceof String str) {
            NamespacedKey key = NamespacedKey.fromString(str);
            if (key == null)
                return null;
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.ATTRIBUTE).get(key);
        }

        if (o instanceof NamespacedKey key) {
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.ATTRIBUTE).get(key);
        }

        return null;
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof Attribute attribute)
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.ATTRIBUTE).getKey(attribute).asString();
        return null;
    }
}
