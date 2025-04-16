package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.CrossBowMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.CrossbowMeta;

import java.util.List;

/**
 * Represents a crossbow item in the game.
 * This class extends BaseItem and adds functionality to store multiple items (presumably arrows or projectiles).
 */
public class CrossBowItem extends BaseItem {
    private List<BaseItem> items;

    /**
     * Constructs a new CrossBowItem with the specified properties.
     *
     * @param item  The base item to inherit properties from
     * @param items The list of items (presumably arrows or projectiles) associated with this crossbow
     */
    public CrossBowItem(BaseItem item, List<BaseItem> items) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.items = items;
    }

    /**
     * Gets the list of items associated with this crossbow.
     *
     * @return A List of BaseItem objects representing the items (presumably arrows or projectiles) associated with the crossbow
     */
    public List<BaseItem> getItems() {
        return items;
    }

    /**
     * Sets the list of items associated with this crossbow.
     *
     * @param items A List of BaseItem objects to be associated with the crossbow
     */
    public void setItems(List<BaseItem> items) {
        this.items = items;
    }

    public CrossbowMeta getItemMeta() {
        return (CrossbowMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        CrossBowMeta meta = new CrossBowMeta();
        meta.setMeta(this, player);
    }
}
