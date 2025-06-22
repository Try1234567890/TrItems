package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrBundleItem;
import me.tr.trItems.item.loaders.ItemLoader;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class TrBundleLoader extends TrBaseLoader {

    public TrBundleItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        List<TrBaseItem> items = getNestedItems(plugin, itemSection);
        return new TrBundleItem(baseItem, items);
    }


    public List<TrBaseItem> getNestedItems(Plugin plugin, Section item) {
        Section nestedItemsSection = item.getSection("Items");
        return ItemLoader.getInstance().loadItems(plugin, nestedItemsSection);
    }

}
