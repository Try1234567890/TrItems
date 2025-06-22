package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrCrossBowItem;
import me.tr.trItems.item.loaders.ItemLoader;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class TrCrossBowLoader extends TrBaseLoader {

    public TrCrossBowItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        List<TrBaseItem> items = getNestedItems(plugin, itemSection);
        return new TrCrossBowItem(baseItem, items);
    }


    public List<TrBaseItem> getNestedItems(Plugin plugin, Section item) {
        Section nestedItemsSection = item.getSection("Projectiles");
        return ItemLoader.getInstance().loadItems(plugin, nestedItemsSection);
    }
}
