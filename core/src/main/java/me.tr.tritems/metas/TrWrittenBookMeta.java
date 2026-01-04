package me.tr.tritems.metas;

import me.tr.tritems.formatter.TrItemFormatter;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrWrittenBookItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class TrWrittenBookMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrWrittenBookMeta.class.getSimpleName());
        }

        @Override
        public TrWrittenBookMeta newInstance(TrItem item) {
            return new TrWrittenBookMeta((TrWrittenBookItem) item);
        }
    };

    public TrWrittenBookMeta(TrWrittenBookItem item) {
        super(item);
    }

    @Override
    public TrWrittenBookItem getItem() {
        return (TrWrittenBookItem) super.getItem();
    }


    public TrWrittenBookMeta setPages(List<String> page) {
        getItem().setPages(page);
        return this;
    }

    public TrWrittenBookMeta addPages(List<String> page) {
        getItem().addPages(page);
        return this;
    }

    public TrWrittenBookMeta addPages(String... page) {
        getItem().addPages(page);
        return this;
    }

    public TrWrittenBookMeta addPage(int i, String page) {
        getItem().addPage(i, page);
        return this;
    }

    public TrWrittenBookMeta setAuthor(String author) {
        getItem().setAuthor(author);
        return this;
    }


    public TrWrittenBookMeta setTitle(String title) {
        getItem().setTitle(title);
        return this;
    }

    public TrWrittenBookMeta setGeneration(BookMeta.Generation generation) {
        getItem().setGeneration(generation);
        return this;
    }

    @Override
    public TrWrittenBookItem apply() {
        BookMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setPages(meta);
            setAuthor(meta);
            setTitle(meta);
            setGeneration(meta);

        }

        super.apply(meta);
        return getItem();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void setPages(BookMeta meta) {
        List<Component> pages = meta.pages();
        List<String> newTrPages = getItem().getPages();

        if (newTrPages == null || newTrPages.isEmpty()) {
            meta.pages(new ArrayList<>());
            return;
        }

        List<Component> newPages = newTrPages.stream().map(TrItemFormatter::format).toList();

        if (newPages.equals(pages))
            return;

        meta.pages(newPages);
    }

    private void setAuthor(BookMeta meta) {
        String author = meta.getAuthor();
        String newTrAuthor = getItem().getAuthor();

        if (newTrAuthor == null || newTrAuthor.isEmpty()) {
            meta.setAuthor(null);
            return;
        }

        String newAuthor = TrItemFormatter.formatAsString(newTrAuthor);

        if (newAuthor.equals(author))
            return;

        meta.setAuthor(newAuthor);
    }

    private void setTitle(BookMeta meta) {
        String title = meta.getTitle();
        String newTrTitle = getItem().getTitle();

        if (newTrTitle == null || newTrTitle.isEmpty()) {
            meta.setTitle(null);
            return;
        }

        String newTitle = TrItemFormatter.formatAsString(newTrTitle);

        if (newTitle.equals(title))
            return;

        meta.setAuthor(newTitle);
    }

    private void setGeneration(BookMeta meta) {
        BookMeta.Generation generation = meta.getGeneration();
        BookMeta.Generation newGeneration = getItem().getGeneration();

        if (newGeneration == null) {
            meta.setGeneration(null);
            return;
        }

        if (newGeneration.equals(generation))
            return;

        meta.setGeneration(newGeneration);
    }

}
