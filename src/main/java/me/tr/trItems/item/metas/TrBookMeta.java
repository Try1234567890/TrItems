package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrBookItem;
import me.tr.trItems.message.MessageFormatter;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Arrays;

public class TrBookMeta extends TrBaseMeta {

    private TrBookMeta() {
    }

    public TrBookMeta(TrBookItem item) {
        super(item);
    }

    @Override
    public TrBookItem getItem() {
        return (TrBookItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setTitle(player);
        setAuthor(player);
        setPages(player);
        setGeneration();
    }

    public void setTitle(Player player) {
        BookMeta bookMeta = getItem().getItemMeta();
        if (bookMeta == null) return;
        Component title = MessageFormatter.getInstance().format(getItem().getTitle(), player);
        if (title != null) {
            bookMeta.title(title);
            getItem().getStack().setItemMeta(bookMeta);
        }
    }

    public void editTitle(String title, Player player) {
        getItem().setTitle(title);
        setTitle(player);
    }

    public void setAuthor(Player player) {
        BookMeta bookMeta = getItem().getItemMeta();
        if (bookMeta == null) return;
        Component author = MessageFormatter.getInstance().format(getItem().getAuthor(), player);
        if (author != null) {
            bookMeta.author(author);
            getItem().getStack().setItemMeta(bookMeta);
        }
    }

    public void editAuthor(String author, Player player) {
        getItem().setAuthor(author);
        setAuthor(player);
    }

    public void setPages(Player player) {
        BookMeta bookMeta = getItem().getItemMeta();
        if (bookMeta == null) return;
        bookMeta.pages(Arrays.stream(getItem().getPages()).map(line -> MessageFormatter.getInstance().format(line, player)).toList());
        getItem().getStack().setItemMeta(bookMeta);
    }

    public void editPages(Player player, String... pages) {
        getItem().setPages(pages);
        setPages(player);
    }

    public void setGeneration() {
        BookMeta bookMeta = getItem().getItemMeta();
        if (bookMeta == null) return;
        BookMeta.Generation generation = getItem().getGeneration();
        if (generation != null) {
            bookMeta.setGeneration(generation);
            getItem().getStack().setItemMeta(bookMeta);
        }
    }

    public void editGeneration(BookMeta.Generation generation) {
        getItem().setGeneration(generation);
        setGeneration();
    }


}
