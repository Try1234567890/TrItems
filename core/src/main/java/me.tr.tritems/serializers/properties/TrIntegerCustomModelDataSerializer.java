package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.custommodeldata.TrIntegerCustomModelData;
import me.tr.tritems.serializers.SerializationException;

public class TrIntegerCustomModelDataSerializer {

    private TrIntegerCustomModelDataSerializer() {}

    public static int serialize(TrIntegerCustomModelData object) throws SerializationException {
        return object.getValue();
    }
}
