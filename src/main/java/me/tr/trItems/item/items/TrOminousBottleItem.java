package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrOminousBottleMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.OminousBottleMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class TrOminousBottleItem extends TrBaseItem {
    private int amplifier = 1;

    /**
     * Constructs a new OminousBottleItem with the specified base item and amplifier.
     *
     * @param item      The base item to be used for the ominous bottle item
     * @param amplifier The amplifier level for the ominous bottle item
     */
    public TrOminousBottleItem(TrBaseItem item, int amplifier) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.amplifier = amplifier;
    }

    /**
     * Constructs a new OminousBottleItem instance with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrOminousBottleItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the amplifier level of the ominous bottle item.
     *
     * @return The amplifier level
     */
    public int getAmplifier() {
        return amplifier;
    }

    /**
     * Sets the amplifier level of the ominous bottle item.
     *
     * @param amplifier The new amplifier level
     */
    public void setAmplifier(int amplifier) {
        this.amplifier = amplifier;
    }

    /**
     * Gets the OminousBottleMeta instance from the item stack.
     *
     * @return The OminousBottleMeta instance
     */
    @Override
    public OminousBottleMeta getItemMeta() {
        return (OminousBottleMeta) super.getItemMeta();
    }

    /**
     * Sets the OminousBottleMeta instance to the item stack.
     *
     * @param player The player who is setting the meta
     */
    @Override
    public void setMeta(Player player) {
        TrOminousBottleMeta meta = new TrOminousBottleMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private int amplifier;

        /**
         * Constructs a new Builder instance for OminousBottleItem.
         *
         * @param id     The id of this item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the amplifier level for the builder.
         *
         * @param amplifier The amplifier level to set
         * @return The builder instance
         */
        public Builder amplifier(int amplifier) {
            this.amplifier = amplifier;
            return this;
        }

        /**
         * Builds the OminousBottleItem with the specified properties.
         *
         * @return A new OminousBottleItem instance
         */
        public TrOminousBottleItem build() {
            return new TrOminousBottleItem(super.build(), amplifier);
        }
    }
}
