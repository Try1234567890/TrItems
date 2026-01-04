package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrWrittenBookMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.inventory.meta.BookMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrWrittenBookItem extends TrItem {
    private List<String> pages = new ArrayList<>();
    private String author;
    private String title;
    private BookMeta.Generation generation;

    @Initialize
    protected TrWrittenBookItem() {
        super(TrItemType.WRITTEN_BOOK);
    }

    public TrWrittenBookItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrWrittenBookMeta getMeta() {
        return (TrWrittenBookMeta) super.getMeta();
    }

    @Override
    public BookMeta getItemMeta() {
        return (BookMeta) super.getItemMeta();
    }

    public List<String> getPages() {
        return pages;
    }

    public void setPages(List<String> pages) {
        this.pages = pages;
    }

    public void addPages(List<String> pages) {
        this.pages.addAll(pages);
    }

    public void addPages(String... pages) {
        this.pages.addAll(Arrays.asList(pages));
    }

    public void addPage(int i, String page) {
        this.pages.add(i, page);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookMeta.Generation getGeneration() {
        return generation;
    }

    public void setGeneration(BookMeta.Generation generation) {
        this.generation = generation;
    }
}
