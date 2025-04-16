package me.tr.trItems.item.items;

import com.ssomar.score.api.executableitems.config.ExecutableItemInterface;

/**
 * Represents an item that can execute specific actions or behaviors in the game.
 * This class extends BaseItem and adds functionality for executable items.
 */
public class ExecutableItemsItem extends BaseItem {
    private ExecutableItemInterface executableItem;

    /**
     * Constructs a new ExecutableItemsItem with the specified properties.
     *
     * @param item           The base item to inherit properties from
     * @param executableItem The executable item interface providing specific actions or behaviors
     */
    public ExecutableItemsItem(BaseItem item, ExecutableItemInterface executableItem) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.executableItem = executableItem;
    }

    /**
     * Gets the executable item interface associated with this item.
     *
     * @return The executable item interface
     */
    public ExecutableItemInterface getExecutableItem() {
        return executableItem;
    }

    /**
     * Sets the executable item interface for this item.
     *
     * @param executableItem The new executable item interface
     */
    public void setExecutableItem(ExecutableItemInterface executableItem) {
        this.executableItem = executableItem;
    }
}
