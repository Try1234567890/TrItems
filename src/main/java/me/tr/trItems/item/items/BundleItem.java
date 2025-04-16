package me.tr.trItems.item.items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BundleMeta;

import java.util.List;

/**
 * Represents a bundle item in the game.
 * This class extends BaseItem and adds functionality to store multiple items within it.
 */
public class BundleItem extends BaseItem {
    private List<BaseItem> items;

    /**
     * Constructs a new BundleItem with the specified properties.
     *
     * @param item  The base item to inherit properties from
     * @param items The list of items contained within this bundle
     */
    public BundleItem(BaseItem item, List<BaseItem> items) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.items = items;
    }

    /**
     * Gets the list of items contained within this bundle.
     *
     * @return A List of BaseItem objects representing the items in the bundle
     */
    public List<BaseItem> getItems() {
        return items;
    }

    /**
     * Sets the list of items contained within this bundle.
     *
     * @param items A List of BaseItem objects to be stored in the bundle
     */
    public void setItems(List<BaseItem> items) {
        this.items = items;
    }

    public BundleMeta getItemMeta() {
        return (BundleMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.BundleMeta meta = new me.tr.trItems.item.metas.BundleMeta();
        meta.setMeta(this, player);
    }
}
