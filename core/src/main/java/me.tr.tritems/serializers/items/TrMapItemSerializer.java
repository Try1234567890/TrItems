package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrMapItem;
import me.tr.tritems.serializers.SerializationException;
import me.tr.tritems.serializers.properties.TrColorSerializer;
import org.bukkit.map.MapView;

import java.util.Map;

public class TrMapItemSerializer {

    private TrMapItemSerializer() {}

    public static Map<String, Object> serialize(TrMapItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getColor() != null)
            map.put("color", TrColorSerializer.serialize(item.getColor()));

        map.put("scaling", item.isScaling());
        map.put("centerX", item.getCenterX());
        map.put("centerZ", item.getCenterZ());
        map.put("locked", item.isLocked());
        map.put("trackingPosition", item.isTrackingPosition());
        map.put("unlimitedTracking", item.isUnlimitedTracking());

        MapView.Scale scale = item.getScale();
        if (scale != null)
            map.put("scale", scale.name());

        if (item.getWorld() != null)
            map.put("world", item.getWorld().getName());

        return map;
    }
}
