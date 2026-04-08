package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.custommodeldata.TrComponentCustomModelData;
import me.tr.tritems.serializers.SerializationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrComponentCustomModelDataSerializer {

    private TrComponentCustomModelDataSerializer() {}

    public static Map<String, Object> serialize(TrComponentCustomModelData object) throws SerializationException {
        Map<String, Object> map = new HashMap<>();
        map.put("floats", floats(object));
        map.put("flags", object.getFlags());
        map.put("strings", object.getStrings());
        map.put("colors", colors(object));
        return map;
    }

    private static List<Float> floats(TrComponentCustomModelData object) throws SerializationException {
        List<Float> floats = object.getFloats();
        if (floats == null) throw new SerializationException("floats is null");
        return floats;
    }

    private static List<String> colors(TrComponentCustomModelData object) throws SerializationException {
        List<?> colors = object.getColors();
        if (colors == null) throw new SerializationException("colors is null");
        return object.getColors().stream().map(c -> c.getHex()).toList();
    }
}
