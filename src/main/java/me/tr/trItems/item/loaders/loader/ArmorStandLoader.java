package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.ArmorStandItem;
import me.tr.trItems.item.items.BaseItem;
import org.bukkit.plugin.Plugin;

public class ArmorStandLoader extends BaseLoader {

    public ArmorStandItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        boolean invisible = getInvisible(itemSection);
        boolean noBasePlate = getNoBasePlate(itemSection);
        boolean small = getSmall(itemSection);
        boolean marker = getMarker(itemSection);
        return new ArmorStandItem(baseItem, invisible, noBasePlate, small, marker);
    }

    public boolean getInvisible(Section item) {
        return item.getBoolean("Invisible");
    }

    public boolean getNoBasePlate(Section item) {
        return item.getBoolean("NoBasePlate");
    }

    public boolean getSmall(Section item) {
        return item.getBoolean("Small");
    }

    public boolean getMarker(Section item) {
        return item.getBoolean("Marker");
    }

}
