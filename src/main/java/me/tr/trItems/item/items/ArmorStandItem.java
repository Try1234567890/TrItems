package me.tr.trItems.item.items;

import com.destroystokyo.paper.inventory.meta.ArmorStandMeta;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

/**
 * The ArmorStandItem class represents an armor stand item with additional properties.
 * It extends the BaseItem class and includes properties for invisibility, no base plate, small size, and marker.
 */
public class ArmorStandItem extends BaseItem {
    private boolean invisible;
    private boolean noBasePlate;
    private boolean small;
    private boolean marker;

    /**
     * Constructs a new ArmorStandItem instance with the specified base item and additional properties.
     *
     * @param item        The base item to be used for the armor stand item
     * @param invisible   Whether the armor stand should be invisible
     * @param noBasePlate Whether the armor stand should not have a base plate
     * @param small       Whether the armor stand should be small
     * @param marker      Whether the armor stand should be a marker
     */
    public ArmorStandItem(BaseItem item, boolean invisible, boolean noBasePlate, boolean small, boolean marker) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.invisible = invisible;
        this.noBasePlate = noBasePlate;
        this.small = small;
        this.marker = marker;
    }

    /**
     * Checks if the armor stand is invisible.
     *
     * @return True if the armor stand is invisible, false otherwise
     */
    public boolean isInvisible() {
        return invisible;
    }

    /**
     * Sets the invisibility of the armor stand.
     *
     * @param invisible Whether the armor stand should be invisible
     */
    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    /**
     * Checks if the armor stand does not have a base plate.
     *
     * @return True if the armor stand does not have a base plate, false otherwise
     */
    public boolean isNoBasePlate() {
        return noBasePlate;
    }

    /**
     * Sets whether the armor stand does not have a base plate.
     *
     * @param noBasePlate Whether the armor stand should not have a base plate
     */
    public void setNoBasePlate(boolean noBasePlate) {
        this.noBasePlate = noBasePlate;
    }

    /**
     * Checks if the armor stand is small.
     *
     * @return True if the armor stand is small, false otherwise
     */
    public boolean isSmall() {
        return small;
    }

    /**
     * Sets whether the armor stand is small.
     *
     * @param small Whether the armor stand should be small
     */
    public void setSmall(boolean small) {
        this.small = small;
    }

    /**
     * Checks if the armor stand is a marker.
     *
     * @return True if the armor stand is a marker, false otherwise
     */
    public boolean hasMarker() {
        return marker;
    }

    /**
     * Sets whether the armor stand is a marker.
     *
     * @param marker Whether the armor stand should be a marker
     */
    public void setMarker(boolean marker) {
        this.marker = marker;
    }

    public @Nullable ArmorStandMeta getItemMeta() {
        return (ArmorStandMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.ArmorStandMeta meta = new me.tr.trItems.item.metas.ArmorStandMeta();
        meta.setMeta(this, player);
    }

    /**
     * Builder class for creating ArmorStandItem instances using the builder pattern.
     * Provides a fluent interface for constructing ArmorStandItem objects with all available properties.
     */
    public static class Builder {
        private BaseItem baseItem;
        private boolean invisible;
        private boolean noBasePlate;
        private boolean small;
        private boolean marker;

        /**
         * Constructs a new Builder instance with a specified base item.
         *
         * @param baseItem The base item to be used for the armor stand item
         */
        public Builder(BaseItem baseItem) {
            this.baseItem = baseItem;
        }

        /**
         * Sets the base item for the armor stand item.
         *
         * @param baseItem The base item to be used
         * @return This Builder instance for method chaining
         */
        public Builder setBaseItem(BaseItem baseItem) {
            this.baseItem = baseItem;
            return this;
        }

        /**
         * Sets whether the armor stand should be invisible.
         *
         * @param invisible True if the armor stand should be invisible, false otherwise
         * @return This Builder instance for method chaining
         */
        public Builder setInvisible(boolean invisible) {
            this.invisible = invisible;
            return this;
        }

        /**
         * Sets whether the armor stand should not have a base plate.
         *
         * @param noBasePlate True if the armor stand should not have a base plate, false otherwise
         * @return This Builder instance for method chaining
         */
        public Builder setNoBasePlate(boolean noBasePlate) {
            this.noBasePlate = noBasePlate;
            return this;
        }

        /**
         * Sets whether the armor stand should be small.
         *
         * @param small True if the armor stand should be small, false otherwise
         * @return This Builder instance for method chaining
         */
        public Builder setSmall(boolean small) {
            this.small = small;
            return this;
        }

        /**
         * Sets whether the armor stand should be a marker.
         *
         * @param marker True if the armor stand should be a marker, false otherwise
         * @return This Builder instance for method chaining
         */
        public Builder setMarker(boolean marker) {
            this.marker = marker;
            return this;
        }

        /**
         * Builds and returns a new ArmorStandItem instance with the configured properties.
         *
         * @return A new ArmorStandItem instance
         * @throws NullPointerException if the base item is null
         */
        public ArmorStandItem build() {
            return new ArmorStandItem(baseItem, invisible, noBasePlate, small, marker);
        }
    }
}