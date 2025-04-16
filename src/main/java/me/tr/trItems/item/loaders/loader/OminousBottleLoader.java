package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.OminousBottleItem;
import org.bukkit.plugin.Plugin;

public class OminousBottleLoader extends BaseLoader {


    public OminousBottleItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        int amplifier = getAmplifier(itemSection);
        return new OminousBottleItem(baseItem, amplifier);
    }

    public int getAmplifier(Section itemSection) {
        return itemSection.getInt("Amplifier");
    }
}
