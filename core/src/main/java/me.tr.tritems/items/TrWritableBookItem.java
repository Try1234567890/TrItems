package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrWritableBookMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.inventory.meta.WritableBookMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrWritableBookItem extends TrItem {
    private List<String> pages = new ArrayList<>();

    @Initialize
    protected TrWritableBookItem() {
        super(TrItemType.WRITABLE_BOOK);
    }

    public TrWritableBookItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrWritableBookMeta getMeta() {
        return (TrWritableBookMeta) super.getMeta();
    }

    @Override
    public WritableBookMeta getItemMeta() {
        return (WritableBookMeta) super.getItemMeta();
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
}
