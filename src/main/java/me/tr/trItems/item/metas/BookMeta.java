package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.BookItem;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class BookMeta extends BaseMeta {

    public void setMeta(BookItem item, Player player) {
        super.setMeta(item, player);
        setTitle(item, player);
        setAuthor(item, player);
        setPages(item, player);
        setGeneration(item);
    }

    public void setTitle(BookItem item, Player player) {
        org.bukkit.inventory.meta.BookMeta bookMeta = item.getItemMeta();
        if (bookMeta == null) return;
        bookMeta.title(main.getFormatter().format(item.getTitle(), player));
        item.getStack().setItemMeta(bookMeta);
    }

    public void setAuthor(BookItem item, Player player) {
        org.bukkit.inventory.meta.BookMeta bookMeta = item.getItemMeta();
        if (bookMeta == null) return;
        bookMeta.author(main.getFormatter().format(item.getAuthor(), player));
        item.getStack().setItemMeta(bookMeta);
    }

    public void setPages(BookItem item, Player player) {
        org.bukkit.inventory.meta.BookMeta bookMeta = item.getItemMeta();
        if (bookMeta == null) return;
        bookMeta.pages(Arrays.stream(item.getPages()).map(line -> main.getFormatter().format(line, player)).toList());
        item.getStack().setItemMeta(bookMeta);
    }

    public void setGeneration(BookItem item) {
        org.bukkit.inventory.meta.BookMeta bookMeta = item.getItemMeta();
        if (bookMeta == null) return;
        bookMeta.setGeneration(item.getGeneration());
        item.getStack().setItemMeta(bookMeta);
    }


}
