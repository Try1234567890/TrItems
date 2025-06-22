package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrBundleMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BundleMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bundle item in the game.
 * This class extends BaseItem and adds functionality to store multiple items within it.
 */
public class TrBundleItem extends TrBaseItem {
    private List<TrBaseItem> items = new ArrayList<>();

    /**
     * Constructs a new BundleItem with the specified properties.
     *
     * @param item  The base item to inherit properties from
     * @param items The list of items contained within this bundle
     */
    public TrBundleItem(TrBaseItem item, List<TrBaseItem> items) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.items = items;
    }

    /**
     * Constructs a new BundleItem with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrBundleItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the list of items contained within this bundle.
     *
     * @return A List of BaseItem objects representing the items in the bundle
     */
    public List<TrBaseItem> getItems() {
        return items;
    }

    /**
     * Sets the list of items contained within this bundle.
     *
     * @param items A List of BaseItem objects to be stored in the bundle
     */
    public void setItems(List<TrBaseItem> items) {
        this.items = items;
    }

    /**
     * Gets the BundleMeta instance from the item stack.
     *
     * @return The BundleMeta instance from the item stack, or null if the stack does not have a BundleMeta
     */
    @Override
    public BundleMeta getItemMeta() {
        return (BundleMeta) super.getItemMeta();
    }

    /**
     * Sets the BundleMeta for this item.
     *
     * @param player The player to set the meta for
     */
    public void setMeta(Player player) {
        TrBundleMeta meta = new TrBundleMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private List<TrBaseItem> items;

        /**
         * Constructs a new BundleItem with the specified id.
         *
         * @param id     The id of this item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        public Builder items(List<TrBaseItem> items) {
            this.items = items;
            return this;
        }

        @Override
        public TrBundleItem build() {
            return new TrBundleItem(super.build(), items);
        }
    }
}
