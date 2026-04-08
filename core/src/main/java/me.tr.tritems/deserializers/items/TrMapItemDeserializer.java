package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.deserializers.properties.TrColorDeserializer;
import me.tr.tritems.items.TrMapItem;
import org.bukkit.Bukkit;
import org.bukkit.map.MapView;

import java.util.Map;

public class TrMapItemDeserializer {

    private TrMapItemDeserializer() {}

    public static TrMapItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrMapItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrMapItem item = new TrMapItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object colorRaw = map.get("color");
        if (colorRaw != null) item.setColor(TrColorDeserializer.deserialize(colorRaw));

        if (map.get("scaling") instanceof Boolean b) item.setScaling(b);
        if (map.get("centerX") instanceof Number n) item.setCenterX(n.intValue());
        if (map.get("centerZ") instanceof Number n) item.setCenterZ(n.intValue());
        if (map.get("locked") instanceof Boolean b) item.setLocked(b);
        if (map.get("trackingPosition") instanceof Boolean b) item.setTrackingPosition(b);
        if (map.get("unlimitedTracking") instanceof Boolean b) item.setUnlimitedTracking(b);

        Object scaleRaw = map.get("scale");
        if (scaleRaw instanceof String str) {
            try { item.setScale(MapView.Scale.valueOf(str.toUpperCase())); }
            catch (IllegalArgumentException e) { throw new DeserializationException("unknown MapView.Scale: " + str); }
        }

        Object worldRaw = map.get("world");
        if (worldRaw instanceof String str) item.setWorld(Bukkit.getWorld(str));

        return item;
    }
}
