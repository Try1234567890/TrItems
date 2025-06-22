package me.tr.trItems.item.items;

import io.lumine.mythic.core.items.MythicItem;
import org.bukkit.plugin.Plugin;

import java.io.File;

/**
 * Represents a MythicMobs item, extending the functionality of BaseItem.
 * This class encapsulates a MythicItem and provides methods to interact with it.
 */
public class TrMythicMobsItem extends TrBaseItem {
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
    public TrMythicMobsItem(TrBaseItem item, MythicItem mythicItem) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.mythicItem = mythicItem;
    }

    /**
     * Constructs a new MythicMobsItem with the specified id.
     *
     * @param id     The id of this item.
     * @param file   The file where this item is stored.
     * @param plugin The plugin that this item belongs to.
     */
    public TrMythicMobsItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
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

    public static class Builder extends TrBaseItem.Builder {
        private MythicItem mythicItem;

        /**
         * Constructs a new Builder for creating MythicMobsItem instances.
         *
         * @param id     The id of the item.
         * @param file   The file where this item is stored.
         * @param plugin The plugin that this item belongs to.
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the MythicItem for this builder.
         *
         * @param mythicItem The MythicItem to set.
         * @return The current Builder instance.
         */
        public Builder mythicItem(MythicItem mythicItem) {
            this.mythicItem = mythicItem;
            return this;
        }

        /**
         * Builds and returns a new TrMythicMobsItem instance.
         *
         * @return A new TrMythicMobsItem instance.
         */
        public TrMythicMobsItem build() {
            return new TrMythicMobsItem(super.build(), mythicItem);
        }
    }
}
