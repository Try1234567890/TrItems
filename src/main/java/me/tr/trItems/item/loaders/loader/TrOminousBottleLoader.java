package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrOminousBottleItem;
import org.bukkit.plugin.Plugin;

public class TrOminousBottleLoader extends TrBaseLoader {


    public TrOminousBottleItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        int amplifier = getAmplifier(itemSection);
        return new TrOminousBottleItem(baseItem, amplifier);
    }

    public int getAmplifier(Section itemSection) {
        return itemSection.getInt("Amplifier");
    }
}
