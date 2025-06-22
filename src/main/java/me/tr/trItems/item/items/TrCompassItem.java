package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrCompassMeta;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * Represents a custom compass item that extends the functionality of a base item.
 * This class allows setting and retrieving the lodestone location and tracking options.
 */
public class TrCompassItem extends TrBaseItem {
    private @Nullable Location lodestone;
    private boolean trackLodestone = false;

    /**
     * Constructs a new CompassItem with the specified base item properties, lodestone location, and tracking options.
     *
     * @param item           The base item to extend.
     * @param lodestone      The lodestone location the compass points to.
     * @param trackLodestone Whether the compass should track the lodestone.
     */
    public TrCompassItem(TrBaseItem item, @Nullable Location lodestone, boolean trackLodestone) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.lodestone = lodestone;
        this.trackLodestone = trackLodestone;
    }


    /**
     * Constructs a new CompassItem with the specified id.
     *
     * @param id     The id of this item.
     * @param file   The file where this item is stored.
     * @param plugin The plugin that this item belongs to.
     */
    public TrCompassItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the lodestone location the compass points to.
     *
     * @return The lodestone location.
     */
    public @Nullable Location getLodestone() {
        return lodestone;
    }

    /**
     * Sets the lodestone location the compass points to.
     *
     * @param lodestone The new lodestone location.
     */
    public void setLodestone(@Nullable Location lodestone) {
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

    /**
     * Gets the CompassMeta instance from the item stack.
     *
     * @return The CompassMeta instance from the item stack, or null if the stack does not have a CompassMeta.
     */
    @Override
    public CompassMeta getItemMeta() {
        return (CompassMeta) super.getItemMeta();
    }

    /**
     * Sets the CompassMeta for this item.
     *
     * @param player The player to set the meta for.
     */
    @Override
    public void setMeta(Player player) {
        TrCompassMeta meta = new TrCompassMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private Location lodestone;
        private boolean trackLodestone;

        /**
         * Constructs a new Builder instance for creating a CompassItem.
         *
         * @param id     The id of the item.
         * @param file   The file where this item is stored.
         * @param plugin The plugin that this item belongs to.
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        public Builder lodestone(Location lodestone) {
            this.lodestone = lodestone;
            return this;
        }

        public Builder trackLodestone(boolean trackLodestone) {
            this.trackLodestone = trackLodestone;
            return this;
        }

        public TrCompassItem build() {
            return new TrCompassItem(super.build(), lodestone, trackLodestone);
        }
    }
}
