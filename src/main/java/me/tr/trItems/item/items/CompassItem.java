package me.tr.trItems.item.items;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.CompassMeta;

/**
 * Represents a custom compass item that extends the functionality of a base item.
 * This class allows setting and retrieving the lodestone location and tracking options.
 */
public class CompassItem extends BaseItem {
    private Location lodestone;
    private boolean trackLodestone;

    /**
     * Constructs a new CompassItem with the specified base item properties, lodestone location, and tracking options.
     *
     * @param item           The base item to extend.
     * @param lodestone      The lodestone location the compass points to.
     * @param trackLodestone Whether the compass should track the lodestone.
     */
    public CompassItem(BaseItem item, Location lodestone, boolean trackLodestone) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.lodestone = lodestone;
        this.trackLodestone = trackLodestone;
    }

    /**
     * Gets the lodestone location the compass points to.
     *
     * @return The lodestone location.
     */
    public Location getLodestone() {
        return lodestone;
    }

    /**
     * Sets the lodestone location the compass points to.
     *
     * @param lodestone The new lodestone location.
     */
    public void setLodestone(Location lodestone) {
        this.lodestone = lodestone;
    }

    /**
     * Checks if the compass is set to track the lodestone.
     *
     * @return True if the compass tracks the lodestone, false otherwise.
     */
    public boolean isTrackLodestone() {
        return trackLodestone;
    }

    /**
     * Sets whether the compass should track the lodestone.
     *
     * @param trackLodestone True to enable tracking, false to disable.
     */
    public void setTrackLodestone(boolean trackLodestone) {
        this.trackLodestone = trackLodestone;
    }

    public CompassMeta getItemMeta() {
        return (CompassMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.CompassMeta meta = new me.tr.trItems.item.metas.CompassMeta();
        meta.setMeta(this, player);
    }

    public static class Builder {
        private BaseItem baseItem;
        private Location lodestone;
        private boolean trackLodestone;

        public Builder(BaseItem baseItem) {
            this.baseItem = baseItem;
        }

        public Builder setBaseItem(BaseItem baseItem) {
            this.baseItem = baseItem;
            return this;
        }

        public Builder setLodestone(Location lodestone) {
            this.lodestone = lodestone;
            return this;
        }

        public Builder setTrackLodestone(boolean trackLodestone) {
            this.trackLodestone = trackLodestone;
            return this;
        }

        public CompassItem build() {
            return new CompassItem(baseItem, lodestone, trackLodestone);
        }
    }
}
