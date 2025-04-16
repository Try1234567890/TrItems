package me.tr.trItems.item.items;

import io.lumine.mythic.core.items.MythicItem;

/**
 * Represents a MythicMobs item, extending the functionality of BaseItem.
 * This class encapsulates a MythicItem and provides methods to interact with it.
 */
public class MythicMobsItem extends BaseItem {
    /**
     * The MythicItem associated with this MythicMobsItem.
     */
    private MythicItem mythicItem;

    /**
     * Constructs a new MythicMobsItem.
     *
     * @param item       The base item to inherit properties from.
     * @param mythicItem The MythicItem to associate with this MythicMobsItem.
     */
    public MythicMobsItem(BaseItem item, MythicItem mythicItem) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.mythicItem = mythicItem;
    }

    /**
     * Retrieves the MythicItem associated with this MythicMobsItem.
     *
     * @return The associated MythicItem.
     */
    public MythicItem getMythicItem() {
        return mythicItem;
    }

    /**
     * Sets the MythicItem for this MythicMobsItem.
     *
     * @param mythicItem The MythicItem to set.
     */
    public void setMythicItem(MythicItem mythicItem) {
        this.mythicItem = mythicItem;
    }
}
