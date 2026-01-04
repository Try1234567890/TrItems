package me.tr.tritems.metas;

import me.tr.tritems.formatter.TrItemFormatter;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrWritableBookItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.meta.WritableBookMeta;

import java.util.ArrayList;
import java.util.List;

public class TrWritableBookMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrWritableBookMeta.class.getSimpleName());
        }

        @Override
        public TrWritableBookMeta newInstance(TrItem item) {
            return new TrWritableBookMeta((TrWritableBookItem) item);
        }
    };

    public TrWritableBookMeta(TrWritableBookItem item) {
        super(item);
    }

    @Override
    public TrWritableBookItem getItem() {
        return (TrWritableBookItem) super.getItem();
    }


    public TrWritableBookMeta setPages(List<String> page) {
        getItem().setPages(page);
        return this;
    }

    public TrWritableBookMeta addPages(List<String> page) {
        getItem().addPages(page);
        return this;
    }

    public TrWritableBookMeta addPages(String... page) {
        getItem().addPages(page);
        return this;
    }

    public TrWritableBookMeta addPage(int i, String page) {
        getItem().addPage(i, page);
        return this;
    }

    @Override
    public TrWritableBookItem apply() {
        WritableBookMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setPages(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setPages(WritableBookMeta meta) {
        List<String> pages = meta.getPages();
        List<String> newPages = getItem().getPages();

        if (newPages == null || newPages.isEmpty()) {
            meta.setPages(new ArrayList<>());
            return;
        }

        if (newPages.equals(pages))
            return;

        meta.setPages(newPages.stream().map(TrItemFormatter::formatAsString).toList());
    }
}
