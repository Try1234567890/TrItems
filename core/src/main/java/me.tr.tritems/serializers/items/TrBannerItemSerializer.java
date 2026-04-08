package me.tr.tritems.serializers.items;

import me.tr.tritems.items.TrBannerItem;
import me.tr.tritems.serializers.SerializationException;
import org.bukkit.block.banner.Pattern;

import java.util.List;
import java.util.Map;

public class TrBannerItemSerializer {

    private TrBannerItemSerializer() {}

    public static Map<String, Object> serialize(TrBannerItem item) throws SerializationException {
        Map<String, Object> map = TrItemSerializer.serialize(item);

        List<Pattern> patterns = item.getPatterns();
        if (patterns != null && !patterns.isEmpty()) {
            map.put("patterns", patterns.stream().map(p -> Map.of(
                    "color", p.getColor().name(),
                    "pattern", p.getPattern().getKey().asString()
            )).toList());
        }

        return map;
    }
}
