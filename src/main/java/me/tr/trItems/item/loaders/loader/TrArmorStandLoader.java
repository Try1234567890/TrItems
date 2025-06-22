package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrArmorStandItem;
import me.tr.trItems.item.items.TrBaseItem;
import org.bukkit.plugin.Plugin;

public class TrArmorStandLoader extends TrBaseLoader {

    public TrArmorStandItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        boolean invisible = getInvisible(itemSection);
        boolean noBasePlate = getNoBasePlate(itemSection);
        boolean small = getSmall(itemSection);
        boolean marker = getMarker(itemSection);
        return new TrArmorStandItem(baseItem, invisible, noBasePlate, small, marker);
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
