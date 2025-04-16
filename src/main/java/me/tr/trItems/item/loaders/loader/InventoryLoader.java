package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.InventoryItem;
import org.bukkit.plugin.Plugin;

public class InventoryLoader extends BaseLoader {

    public InventoryItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        int slot = getSlot(itemSection);
        return new InventoryItem(baseItem, slot);
    }

    public int getSlot(Section itemSection) {
        return itemSection.getInt("Slot", -1);
    }

}
