package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrSkullItem;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.OfflinePlayer;

import java.util.Map;

public class TrSkullItemSerializer {

    private TrSkullItemSerializer() {}

    public static Map<String, Object> serialize(TrSkullItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        if (item.getSound() != null)
            map.put("sound", item.getSound().asString());

        OfflinePlayer owner = item.getSkullOwner();
        if (owner != null && owner.getUniqueId() != null)
            map.put("skullOwner", owner.getUniqueId().toString());

        return map;
    }
}
