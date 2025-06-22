package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrAxolotlBucketItem;
import me.tr.trItems.item.items.TrBaseItem;
import org.bukkit.entity.Axolotl;
import org.bukkit.plugin.Plugin;

public class TrAxolotlBucketLoader extends TrBaseLoader {

    public TrAxolotlBucketItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        Axolotl.Variant variant = getAxolotlVariant(itemSection);
        return new TrAxolotlBucketItem(baseItem, variant);
    }


    public Axolotl.Variant getAxolotlVariant(Section item) {
        String variant = item.getString("Variant");
        try {
            return Axolotl.Variant.valueOf(variant);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Invalid axolotl variant " + variant);
        }

    }

}
