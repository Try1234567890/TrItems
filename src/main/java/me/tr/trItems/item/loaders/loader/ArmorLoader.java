package me.tr.trItems.item.loaders.loader;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.configuration.Section;
import me.tr.trItems.item.items.ArmorItem;
import me.tr.trItems.item.items.BaseItem;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.bukkit.plugin.Plugin;

public class ArmorLoader extends BaseLoader {

    public ArmorItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        ArmorTrim armorTrim = getArmorTrim(itemSection);
        return new ArmorItem(baseItem, armorTrim);
    }

    public ArmorTrim getArmorTrim(Section item) {
        String armorTrimStr = item.getString("ArmorTrim");
        String[] armorTrimSplit = armorTrimStr.split(" ");
        if (armorTrimSplit.length < 2)
            throw new ArrayIndexOutOfBoundsException("ArmorTrim " + armorTrimStr + " not contains enough information.");
        NamespacedKey trimMaterialKey = main.getItemManager().getNamespacedKey(armorTrimSplit[0]);
        TrimMaterial trimMaterial = RegistryAccess.registryAccess().getRegistry(RegistryKey.TRIM_MATERIAL).get(trimMaterialKey);
        if (trimMaterial == null)
            throw new IllegalArgumentException("TrimMaterial " + trimMaterialKey + " not found.");
        NamespacedKey trimPatternKey = main.getItemManager().getNamespacedKey(armorTrimSplit[1]);
        TrimPattern trimPattern = RegistryAccess.registryAccess().getRegistry(RegistryKey.TRIM_PATTERN).get(trimPatternKey);
        if (trimPattern == null)
            throw new IllegalArgumentException("TrimPattern " + trimMaterialKey + " not found.");
        return new ArmorTrim(trimMaterial, trimPattern);
    }

}
