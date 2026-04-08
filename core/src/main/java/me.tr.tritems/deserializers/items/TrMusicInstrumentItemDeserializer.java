package me.tr.tritems.deserializers.items;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrMusicInstrumentItem;
import org.bukkit.MusicInstrument;
import org.bukkit.NamespacedKey;

import java.util.Map;

public class TrMusicInstrumentItemDeserializer {

    private TrMusicInstrumentItemDeserializer() {}

    public static TrMusicInstrumentItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrMusicInstrumentItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrMusicInstrumentItem item = new TrMusicInstrumentItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object instrRaw = map.get("instrument");
        if (instrRaw instanceof String str) {
            NamespacedKey key = NamespacedKey.fromString(str);
            if (key == null) throw new DeserializationException("invalid NamespacedKey for instrument: " + str);
            MusicInstrument instrument = RegistryAccess.registryAccess().getRegistry(RegistryKey.INSTRUMENT).get(key);
            if (instrument == null) throw new DeserializationException("unknown MusicInstrument: " + str);
            item.setInstrument(instrument);
        }

        return item;
    }
}
