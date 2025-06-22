package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrInventoryItem;
import org.bukkit.plugin.Plugin;

public class TrInventoryItemLoader extends TrBaseLoader {

    public TrInventoryItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        int slot = getSlot(itemSection);
        return new TrInventoryItem(baseItem, slot);
    }

    public int getSlot(Section itemSection) {
        return itemSection.getInt("Slot", -1);
    }

}
