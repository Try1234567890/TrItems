package me.tr.trItems.item.items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BookMeta;

/**
 * Represents a book item in the game.
 * This class extends BaseItem and adds book-specific properties.
 */
public class BookItem extends BaseItem {
    private String title;
    private String author;
    private String[] pages;
    private BookMeta.Generation generation;

    /**
     * Constructs a new BookItem with the specified properties.
     *
     * @param item       The base item to inherit properties from
     * @param title      The title of the book
     * @param author     The author of the book
     * @param pages      The pages of the book
     * @param generation The generation of the book
     */
    public BookItem(BaseItem item, String title, String author, String[] pages, BookMeta.Generation generation) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.generation = generation;
    }

    /**
     * Gets the title of the book.
     *
     * @return The title as a Component
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The new title as a Component
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The author as a Component
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The new author as a Component
     */
    public void setAuthor(String author) {
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
    public BookMeta.Generation getGeneration() {
        return generation;
    }

    /**
     * Sets the generation of the book.
     *
     * @param generation The new BookMeta.Generation for the book
     */
    public void setGeneration(BookMeta.Generation generation) {
        this.generation = generation;
    }

    public BookMeta getItemMeta() {
        return (BookMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.BookMeta meta = new me.tr.trItems.item.metas.BookMeta();
        meta.setMeta(this, player);
    }

    public static class Builder {
        private final BaseItem baseItem;
        private String title;
        private String author;
        private String[] pages;
        private BookMeta.Generation generation;

        /**
         * Constructs a new Builder for creating BookItem instances.
         *
         * @param baseItem The base item to inherit properties from
         */
        public Builder(BaseItem baseItem) {
            this.baseItem = baseItem;
        }

        /**
         * Sets the title for the BookItem being built.
         *
         * @param title The title as a String
         * @return The current Builder instance
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Sets the author for the BookItem being built.
         *
         * @param author The author as a String
         * @return The current Builder instance
         */
        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        /**
         * Sets the pages for the BookItem being built.
         *
         * @param pages An array of Strings representing the pages
         * @return The current Builder instance
         */
        public Builder setPages(String[] pages) {
            this.pages = pages;
            return this;
        }

        /**
         * Sets the generation for the BookItem being built.
         *
         * @param generation The BookMeta.Generation for the book
         * @return The current Builder instance
         */
        public Builder setGeneration(BookMeta.Generation generation) {
            this.generation = generation;
            return this;
        }

        /**
         * Builds and returns a new BookItem instance with the specified properties.
         *
         * @return A new BookItem instance
         */
        public BookItem build() {
            return new BookItem(baseItem, title, author, pages, generation);
        }
    }

}
