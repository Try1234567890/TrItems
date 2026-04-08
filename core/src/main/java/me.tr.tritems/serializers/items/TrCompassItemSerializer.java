package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrCompassItem;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class TrCompassItemSerializer {

    private TrCompassItemSerializer() {}

    public static Map<String, Object> serialize(TrCompassItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        map.put("lodestoneTracked", item.isLodestoneTracked());

        Location loc = item.getLodestone();
        if (loc != null) {
            Map<String, Object> locMap = new HashMap<>();
            if (loc.getWorld() != null) locMap.put("world", loc.getWorld().getName());
            locMap.put("x", loc.getX());
            locMap.put("y", loc.getY());
            locMap.put("z", loc.getZ());
            map.put("lodestone", locMap);
        }

        return map;
    }
}
