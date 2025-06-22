package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrBookMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * Represents a book item in the game.
 * This class extends BaseItem and adds book-specific properties.
 */
public class TrBookItem extends TrBaseItem {
    private @Nullable String title;
    private @Nullable String author;
    private String[] pages;
    private @Nullable BookMeta.Generation generation;

    /**
     * Constructs a new BookItem with the specified properties.
     *
     * @param item       The base item to inherit properties from
     * @param title      The title of the book
     * @param author     The author of the book
     * @param pages      The pages of the book
     * @param generation The generation of the book
     */
    public TrBookItem(TrBaseItem item, @Nullable String title, @Nullable String author, String[] pages, BookMeta.@Nullable Generation generation) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.generation = generation;
    }

    /**
     * Constructs a new BookItem instance with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrBookItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }


    /**
     * Gets the title of the book.
     *
     * @return The title as a Component
     */
    public @Nullable String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The new title as a Component
     */
    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The author as a Component
     */
    public @Nullable String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The new author as a Component
     */
    public void setAuthor(@Nullable String author) {
        this.author = author;
    }

    /**
     * Gets the pages of the book.
     *
     * @return An array of Components representing the pages
     */
    public String[] getPages() {
        return pages;
    }

    /**
     * Sets the pages of the book.
     *
     * @param pages An array of Components representing the new pages
     */
    public void setPages(String[] pages) {
        this.pages = pages;
    }

    /**
     * Gets the generation of the book.
     *
     * @return The BookMeta.Generation of the book
     */
    public BookMeta.@Nullable Generation getGeneration() {
        return generation;
    }

    /**
     * Sets the generation of the book.
     *
     * @param generation The new BookMeta.Generation for the book
     */
    public void setGeneration(BookMeta.@Nullable Generation generation) {
        this.generation = generation;
    }


    /**
     * Gets the BookMeta associated with this item.
     *
     * @return The BookMeta instance
     */
    @Override
    public BookMeta getItemMeta() {
        return (BookMeta) super.getItemMeta();
    }

    /**
     * Sets the BookMeta for this item.
     *
     * @param player The player to set the meta for
     */
    @Override
    public void setMeta(Player player) {
        TrBookMeta meta = new TrBookMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private String title;
        private String author;
        private String[] pages;
        private BookMeta.Generation generation;

        /**
         * Constructs a new Builder instance with the specified id, file, and plugin.
         *
         * @param id     The id of this item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }


        /**
         * Sets the title for the BookItem being built.
         *
         * @param title The title as a String
         * @return The current Builder instance
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Sets the author for the BookItem being built.
         *
         * @param author The author as a String
         * @return The current Builder instance
         */
        public Builder author(String author) {
            this.author = author;
            return this;
        }

        /**
         * Sets the pages for the BookItem being built.
         *
         * @param pages An array of Strings representing the pages
         * @return The current Builder instance
         */
        public Builder pages(String[] pages) {
            this.pages = pages;
            return this;
        }

        /**
         * Sets the generation for the BookItem being built.
         *
         * @param generation The BookMeta.Generation for the book
         * @return The current Builder instance
         */
        public Builder generation(BookMeta.Generation generation) {
            this.generation = generation;
            return this;
        }

        /**
         * Builds and returns a new BookItem instance with the specified properties.
         *
         * @return A new BookItem instance
         */
        public TrBookItem build() {
            return new TrBookItem(super.build(), title, author, pages, generation);
        }
    }

}
