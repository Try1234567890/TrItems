package me.tr.tritems.deserializers.items;

import me.tr.tritems.deserializers.DeserializationException;
import me.tr.tritems.items.TrArmorItem;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;

import java.util.Map;

public class TrArmorItemDeserializer {

    private TrArmorItemDeserializer() {}

    public static TrArmorItem deserialize(Object raw) throws DeserializationException {
        if (!(raw instanceof Map<?, ?> map))
            throw new DeserializationException("expected Map for TrArmorItem, got: " + (raw == null ? "null" : raw.getClass().getSimpleName()));

        TrArmorItem item = new TrArmorItem(TrItemDeserializer.identifier(map), TrItemDeserializer.material(map));
        TrItemDeserializer.applyBase(item, map);

        Object trimRaw = map.get("trim");
        if (trimRaw instanceof Map<?, ?> trimMap)
            item.setTrim(trim(trimMap));

        return item;
    }

    static ArmorTrim trim(Map<?, ?> trimMap) throws DeserializationException {
        Object matRaw = trimMap.get("material");
        Object patRaw = trimMap.get("pattern");
        if (!(matRaw instanceof String matStr)) throw new DeserializationException("missing 'material' in trim");
        if (!(patRaw instanceof String patStr)) throw new DeserializationException("missing 'pattern' in trim");

        TrimMaterial material = io.papermc.paper.registry.RegistryAccess.registryAccess()
                .getRegistry(io.papermc.paper.registry.RegistryKey.TRIM_MATERIAL)
                .get(org.bukkit.NamespacedKey.fromString(matStr));
        TrimPattern pattern = io.papermc.paper.registry.RegistryAccess.registryAccess()
                .getRegistry(io.papermc.paper.registry.RegistryKey.TRIM_PATTERN)
                .get(org.bukkit.NamespacedKey.fromString(patStr));

        if (material == null) throw new DeserializationException("unknown TrimMaterial: " + matStr);
        if (pattern == null) throw new DeserializationException("unknown TrimPattern: " + patStr);

        return new ArmorTrim(material, pattern);
    }
}
