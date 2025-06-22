package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrBookItem;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.Plugin;

public class TrBookLoader extends TrBaseLoader {

    public TrBookItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        String title = getTitle(itemSection);
        String author = getAuthor(itemSection);
        String[] pages = getPages(itemSection);
        BookMeta.Generation generation = getGeneration(itemSection);
        return new TrBookItem(baseItem, title, author, pages, generation);
    }

    public String getTitle(Section itemSection) {
        return itemSection.getString("Title");
    }

    public String getAuthor(Section itemSection) {
        return itemSection.getString("Author");
    }

    public String[] getPages(Section itemSection) {
        return itemSection.getStringList("Pages").toArray(new String[0]);
    }

    public BookMeta.Generation getGeneration(Section itemSection) {
        String generation = itemSection.getString("Generation");
        try {
            return BookMeta.Generation.valueOf(generation);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid book generation: " + generation);
        }
    }

}
