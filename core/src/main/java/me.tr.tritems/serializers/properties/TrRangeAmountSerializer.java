package me.tr.tritems.serializers.properties;

import me.tr.tritems.properties.amount.TrRangeAmount;
import me.tr.tritems.serializers.SerializationException;

import java.util.HashMap;
import java.util.Map;

public class TrRangeAmountSerializer {

    private TrRangeAmountSerializer() {}

    public static Map<String, Object> serialize(TrRangeAmount object) throws SerializationException {
        Map<String, Object> map = new HashMap<>();
        map.put("maxAmount", object.getMaxAmount());
        map.put("minAmount", object.getMinAmount());
        map.put("ender", object.isIncludeEnderChest());
        map.put("shulker", object.isIncludeShulkerBoxes());
        return map;
    }
}
