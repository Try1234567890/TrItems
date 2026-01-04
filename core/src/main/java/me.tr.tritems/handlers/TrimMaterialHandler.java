package me.tr.tritems.handlers;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.trim.TrimMaterial;

public class TrimMaterialHandler implements TypeHandler {
    public static final TrimMaterialHandler INSTANCE = new TrimMaterialHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {
        if (o instanceof String str) {
            NamespacedKey key = NamespacedKey.fromString(str);
            if (key == null)
                return null;
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.TRIM_MATERIAL).get(key);
        }

        if (o instanceof NamespacedKey key) {
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.TRIM_MATERIAL).get(key);
        }

        return null;
    }

    @SuppressWarnings("DataFlowIssue")
    @Override
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof TrimMaterial mat)
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.TRIM_MATERIAL).getKey(mat).asString();
        return null;
    }
}
