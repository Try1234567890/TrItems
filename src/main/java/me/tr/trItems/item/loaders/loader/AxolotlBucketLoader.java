package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.AxolotlBucketItem;
import me.tr.trItems.item.items.BaseItem;
import org.bukkit.entity.Axolotl;
import org.bukkit.plugin.Plugin;

public class AxolotlBucketLoader extends BaseLoader {

    public AxolotlBucketItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        Axolotl.Variant variant = getAxolotlVariant(itemSection);
        return new AxolotlBucketItem(baseItem, variant);
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
