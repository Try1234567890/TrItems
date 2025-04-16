package me.tr.trItems.item.items;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.KnowledgeBookMeta;

import java.util.List;

/**
 * Represents a custom knowledge book item that extends the functionality of a base item.
 * This class allows setting and retrieving a list of recipes associated with the knowledge book.
 */
public class KnowledgeBookItem extends BaseItem {
    private List<NamespacedKey> recipes;

    /**
     * Constructs a new KnowledgeBookItem with the specified base item properties and list of recipes.
     *
     * @param item    The base item to extend.
     * @param recipes The list of recipes associated with the knowledge book.
     */
    public KnowledgeBookItem(BaseItem item, List<NamespacedKey> recipes) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.recipes = recipes;
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


    public KnowledgeBookMeta getItemMeta() {
        return (KnowledgeBookMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.KnowledgeBookMeta meta = new me.tr.trItems.item.metas.KnowledgeBookMeta();
        meta.setMeta(this, player);
    }
}
