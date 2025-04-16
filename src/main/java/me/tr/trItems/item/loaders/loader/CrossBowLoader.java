package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.CrossBowItem;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class CrossBowLoader extends BaseLoader {

    public CrossBowItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        List<BaseItem> items = getNestedItems(plugin, itemSection);
        return new CrossBowItem(baseItem, items);
    }


    public List<BaseItem> getNestedItems(Plugin plugin, Section item) {
        Section nestedItemsSection = item.getSection("Projectiles");
        return main.getItemLoaderManager().getItems(plugin, nestedItemsSection);
    }
}
