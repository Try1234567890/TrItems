package me.tr.tritems.handlers;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.serializer.handlers.TypeHandler;
import me.tr.serializer.types.GenericType;
import org.bukkit.MusicInstrument;
import org.bukkit.NamespacedKey;

public class MusicInstrumentHandler implements TypeHandler {
    public static final MusicInstrumentHandler INSTANCE = new MusicInstrumentHandler();

    @Override
    public Object deserialize(Object o, GenericType<?> type) {
        if (o instanceof String str) {
            NamespacedKey key = NamespacedKey.fromString(str);
            if (key == null)
                return null;
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.INSTRUMENT).get(key);
        }

        if (o instanceof NamespacedKey key) {
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.INSTRUMENT).get(key);
        }

        return null;
    }


    @SuppressWarnings("DataFlowIssue")
    @Override
    public Object serialize(Object o, GenericType<?> type) {
        if (o instanceof MusicInstrument instrument)
            return RegistryAccess.registryAccess().getRegistry(RegistryKey.INSTRUMENT).getKey(instrument).asString();
        return null;
    }
}
