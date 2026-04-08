package me.tr.tritems.deserializers.items;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrBannerItem;
import org.bukkit.DyeColor;
import org.bukkit.NamespacedKey;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;

import java.util.List;
import java.util.Map;

public class TrBannerItemDeserializer {

    private TrBannerItemDeserializer() {}

    public static TrBannerItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrBannerItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrBannerItem item = new TrBannerItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object patternsRaw = map.get("patterns");
        if (patternsRaw instanceof List<?> list) {
            item.setPatterns(TrItemDeserializer.deserializeList(list, TrBannerItemDeserializer::pattern));
        }

        return item;
    }

    private static Pattern pattern(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> m))
            throw new DeserializationException("expected Map for Pattern");

        Object colorRaw = m.get("color");
        Object patternRaw = m.get("pattern");
        if (!(colorRaw instanceof String colorStr)) throw new DeserializationException("missing 'color' in pattern");
        if (!(patternRaw instanceof String patternStr)) throw new DeserializationException("missing 'pattern' in pattern");

        DyeColor color;
        try { color = DyeColor.valueOf(colorStr.toUpperCase()); }
        catch (IllegalArgumentException e) { throw new DeserializationException("unknown DyeColor: " + colorStr); }

        NamespacedKey key = NamespacedKey.fromString(patternStr);
        if (key == null) throw new DeserializationException("invalid NamespacedKey for pattern: " + patternStr);
        PatternType type = RegistryAccess.registryAccess().getRegistry(RegistryKey.BANNER_PATTERN).get(key);
        if (type == null) throw new DeserializationException("unknown PatternType: " + patternStr);

        return new Pattern(color, type);
    }
}
