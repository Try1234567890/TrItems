package me.tr.trItems.item.loaders;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.helper.TrItemType;
import me.tr.trItems.item.items.TrBaseItem;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class ItemLoader {
    private static ItemLoader instance;

    private ItemLoader() {
    }

    public static ItemLoader getInstance() {
        if (instance == null) {
            instance = new ItemLoader();
        }
        return instance;
    }


    public List<TrBaseItem> loadItems(Plugin plugin, Section itemsSection) {
        final List<TrBaseItem> items = new ArrayList<>();
        for (Section itemSection : itemsSection.getSectionList()) {
            items.add(loadItem(plugin, itemSection));
        }
        return items;
    }

    public TrBaseItem loadItem(Plugin plugin, Section itemSection) {
        return TrItemType.parse(itemSection).getLoader().load(plugin, itemSection);
    }
}
