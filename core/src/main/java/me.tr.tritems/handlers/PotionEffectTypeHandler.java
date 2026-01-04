package me.tr.tritems.handlers;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionEffectType;

public class PotionEffectTypeHandler implements TypeHandler {
    public static final PotionEffectTypeHandler INSTANCE = new PotionEffectTypeHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {
        if (o instanceof String str) {
            NamespacedKey key = NamespacedKey.fromString(str);
            if (key == null)
                return null;
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.MOB_EFFECT).get(key);
        }

        if (o instanceof NamespacedKey key) {
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.MOB_EFFECT).get(key);
        }

        return null;
    }


    @SuppressWarnings("DataFlowIssue")
    @Override
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof PotionEffectType potion)
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.MOB_EFFECT).getKey(potion).asString();
        return null;
    }
}
