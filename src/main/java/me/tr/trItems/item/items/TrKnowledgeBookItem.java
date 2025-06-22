package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrKnowledgeBookMeta;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.KnowledgeBookMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a custom knowledge book item that extends the functionality of a base item.
 * This class allows setting and retrieving a list of recipes associated with the knowledge book.
 */
public class TrKnowledgeBookItem extends TrBaseItem {
    private List<NamespacedKey> recipes = new ArrayList<>();

    /**
     * Constructs a new KnowledgeBookItem with the specified base item properties and list of recipes.
     *
     * @param item    The base item to extend.
     * @param recipes The list of recipes associated with the knowledge book.
     */
    public TrKnowledgeBookItem(TrBaseItem item, List<NamespacedKey> recipes) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.recipes = recipes;
    }

    /**
     * Constructs a new KnowledgeBookItem with the specified id.
     *
     * @param id     The id of this item.
     * @param file   The file where this item is stored.
     * @param plugin The plugin that this item belongs to.
     */
    public TrKnowledgeBookItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the list of recipes associated with the knowledge book.
     *
     * @return The list of recipes.
     */
    public List<NamespacedKey> getRecipes() {
        return recipes;
    }

    /**
     * Sets the list of recipes associated with the knowledge book.
     *
     * @param recipes The new list of recipes.
     */
    public void setRecipes(List<NamespacedKey> recipes) {
        this.recipes = recipes;
    }

    /**
     * Gets the KnowledgeBookMeta instance from the item stack.
     *
     * @return The KnowledgeBookMeta instance.
     */
    @Override
    public KnowledgeBookMeta getItemMeta() {
        return (KnowledgeBookMeta) super.getItemMeta();
    }

    /**
     * Sets the KnowledgeBookMeta for the item stack.
     *
     * @param player The player to set the meta for.
     */
    @Override
    public void setMeta(Player player) {
        TrKnowledgeBookMeta meta = new TrKnowledgeBookMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private List<NamespacedKey> recipes;

        /**
         * Constructs a new Builder for creating a KnowledgeBookItem.
         *
         * @param id     The id of the item.
         * @param file   The file where this item is stored.
         * @param plugin The plugin that this item belongs to.
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the list of recipes for the knowledge book item.
         *
         * @param recipes The list of recipes to set.
         * @return The builder instance.
         */
        public Builder recipes(List<NamespacedKey> recipes) {
            this.recipes = recipes;
            return this;
        }

        /**
         * Builds the KnowledgeBookItem with the specified properties.
         *
         * @return The constructed KnowledgeBookItem.
         */
        public TrKnowledgeBookItem build() {
            return new TrKnowledgeBookItem(super.build(), recipes);
        }
    }
}
