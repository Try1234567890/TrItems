package me.tr.trItems.item.items;

import com.destroystokyo.paper.inventory.meta.ArmorStandMeta;
import me.tr.trItems.item.metas.TrArmorStandMeta;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * The ArmorStandItem class represents an armor stand item with additional properties.
 * It extends the BaseItem class and includes properties for invisibility, no base plate, small size, and marker.
 */
public class TrArmorStandItem extends TrBaseItem {
    private boolean invisible = false;
    private boolean noBasePlate = false;
    private boolean small = false;
    private boolean marker = false;

    /**
     * Constructs a new ArmorStandItem instance with the specified base item and additional properties.
     *
     * @param item        The base item to be used for the armor stand item
     * @param invisible   Whether the armor stand should be invisible
     * @param noBasePlate Whether the armor stand should not have a base plate
     * @param small       Whether the armor stand should be small
     * @param marker      Whether the armor stand should be a marker
     */
    public TrArmorStandItem(TrBaseItem item, boolean invisible, boolean noBasePlate, boolean small, boolean marker) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.invisible = invisible;
        this.noBasePlate = noBasePlate;
        this.small = small;
        this.marker = marker;
    }

    /**
     * Constructs a new AxolotlBucketItem instance with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrArmorStandItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
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

    /**
     * Gets the ArmorStandMeta instance from the item stack.
     *
     * @return The ArmorStandMeta instance from the item stack, or null if the stack does not have an ArmorStandMeta
     */
    @Override
    public @Nullable ArmorStandMeta getItemMeta() {
        return (ArmorStandMeta) super.getItemMeta();
    }

    /**
     * Sets the ArmorStandMeta for this item.
     *
     * @param player The player to set the meta for
     */
    @Override
    public void setMeta(Player player) {
        TrArmorStandMeta meta = new TrArmorStandMeta(this);
        meta.setMeta(player);
    }

    /**
     * Builder class for creating ArmorStandItem instances using the builder pattern.
     * Provides a fluent interface for constructing ArmorStandItem objects with all available properties.
     */
    public static class Builder extends TrBaseItem.Builder {
        private boolean invisible = false;
        private boolean noBasePlate = false;
        private boolean small = false;
        private boolean marker = false;

        /**
         * Constructs a new Builder instance.
         *
         * @param id     The id of this item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets whether the armor stand should be invisible.
         *
         * @param invisible True if the armor stand should be invisible, false otherwise
         * @return This Builder instance for method chaining
         */
        public Builder invisible(boolean invisible) {
            this.invisible = invisible;
            return this;
        }

        /**
         * Sets whether the armor stand should not have a base plate.
         *
         * @param noBasePlate True if the armor stand should not have a base plate, false otherwise
         * @return This Builder instance for method chaining
         */
        public Builder noBasePlate(boolean noBasePlate) {
            this.noBasePlate = noBasePlate;
            return this;
        }

        /**
         * Sets whether the armor stand should be small.
         *
         * @param small True if the armor stand should be small, false otherwise
         * @return This Builder instance for method chaining
         */
        public Builder small(boolean small) {
            this.small = small;
            return this;
        }

        /**
         * Sets whether the armor stand should be a marker.
         *
         * @param marker True if the armor stand should be a marker, false otherwise
         * @return This Builder instance for method chaining
         */
        public Builder marker(boolean marker) {
            this.marker = marker;
            return this;
        }

        /**
         * Builds and returns a new ArmorStandItem instance with the configured properties.
         *
         * @return A new ArmorStandItem instance
         * @throws NullPointerException if the base item is null
         */
        public TrArmorStandItem build() {
            return new TrArmorStandItem(super.build(), invisible, noBasePlate, small, marker);
        }
    }
}