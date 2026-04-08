package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrCompassItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Map;

public class TrCompassItemDeserializer {

    private TrCompassItemDeserializer() {}

    public static TrCompassItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrCompassItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrCompassItem item = new TrCompassItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object trackedRaw = map.get("lodestoneTracked");
        if (trackedRaw instanceof Boolean b) item.setLodestoneTracked(b);

        Object locRaw = map.get("lodestone");
        if (locRaw instanceof Map<?, ?> locMap) item.setLodestone(location(locMap));

        return item;
    }

    private static Location location(Map<?, ?> map) throws DeserializationException {
        Object worldRaw = map.get("world");
        Object xRaw = map.get("x");
        Object yRaw = map.get("y");
        Object zRaw = map.get("z");

        if (!(xRaw instanceof Number x)) throw new DeserializationException("missing 'x' in lodestone");
        if (!(yRaw instanceof Number y)) throw new DeserializationException("missing 'y' in lodestone");
        if (!(zRaw instanceof Number z)) throw new DeserializationException("missing 'z' in lodestone");

        World world = worldRaw instanceof String s ? Bukkit.getWorld(s) : null;
        return new Location(world, x.doubleValue(), y.doubleValue(), z.doubleValue());
    }
}
