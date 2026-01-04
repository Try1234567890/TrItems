package me.tr.tritems.handlers;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import org.bukkit.NamespacedKey;
import org.bukkit.block.banner.PatternType;

public class PatternTypeHandler implements TypeHandler {
    public static final PatternTypeHandler INSTANCE = new PatternTypeHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {
        if (o instanceof String str) {
            NamespacedKey key = NamespacedKey.fromString(str);
            if (key == null)
                return null;
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.BANNER_PATTERN).get(key);
        }

        if (o instanceof NamespacedKey key) {
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.BANNER_PATTERN).get(key);
        }

        return null;
    }


    @SuppressWarnings("DataFlowIssue")
    @Override
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof PatternType pattern)
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.BANNER_PATTERN).getKey(pattern).asString();
        return null;
    }
}
