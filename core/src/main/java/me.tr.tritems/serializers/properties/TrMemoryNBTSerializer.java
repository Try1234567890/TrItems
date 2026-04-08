package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.nbts.TrMemoryNBT;
import me.tr.tritems.serializers.SerializationException;

import java.util.HashMap;
import java.util.Map;

public class TrMemoryNBTSerializer {

    private TrMemoryNBTSerializer() {}

    public static Map<String, Object> serialize(TrMemoryNBT<?> object) throws SerializationException {
        String compound = object.getCompound();
        if (compound == null) throw new SerializationException("compound is null");

        Object value = object.getValue();
        if (value == null) throw new SerializationException("value is null");

        Map<String, Object> map = new HashMap<>();
        map.put("compound", compound);
        map.put("value", value);
        return map;
    }
}
