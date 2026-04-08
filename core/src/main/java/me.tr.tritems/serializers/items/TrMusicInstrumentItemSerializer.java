package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrMusicInstrumentItem;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.MusicInstrument;

import java.util.Map;

public class TrMusicInstrumentItemSerializer {

    private TrMusicInstrumentItemSerializer() {}

    @SuppressWarnings("DataFlowIssue")
    public static Map<String, Object> serialize(TrMusicInstrumentItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        MusicInstrument instrument = item.getInstrument();
        if (instrument != null)
            map.put("instrument", instrument.getKey().asString());

        return map;
    }
}
