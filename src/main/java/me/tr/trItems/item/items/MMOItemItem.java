package me.tr.trItems.item.items;

import net.Indyuce.mmoitems.api.item.mmoitem.MMOItem;

/**
 * Represents an MMO item in the game.
 * This class extends BaseItem and adds functionality specific to MMO items.
 */
public class MMOItemItem extends BaseItem {
    private MMOItem mmoItem;

    /**
     * Constructs a new MMOItemItem with the specified properties.
     *
     * @param item    The base item to inherit properties from
     * @param mmoItem The MMOItem providing specific MMO-related properties and behaviors
     */
    public MMOItemItem(BaseItem item, MMOItem mmoItem) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.mmoItem = mmoItem;
    }

    /**
     * Gets the MMOItem associated with this item.
     *
     * @return The MMOItem
     */
    public MMOItem getMmoItem() {
        return mmoItem;
    }

    /**
     * Sets the MMOItem associated with this item.
     *
     * @param mmoItem The new MMOItem
     */
    public void setMmoItem(MMOItem mmoItem) {
        this.mmoItem = mmoItem;
    }
}
