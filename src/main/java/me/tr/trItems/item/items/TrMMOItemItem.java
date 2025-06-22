package me.tr.trItems.item.items;

import net.Indyuce.mmoitems.api.item.mmoitem.MMOItem;
import org.bukkit.plugin.Plugin;

import java.io.File;

/**
 * Represents an MMO item in the game.
 * This class extends BaseItem and adds functionality specific to MMO items.
 */
public class TrMMOItemItem extends TrBaseItem {
    private MMOItem mmoItem;

    /**
     * Constructs a new MMOItemItem with the specified properties.
     *
     * @param item    The base item to inherit properties from
     * @param mmoItem The MMOItem providing specific MMO-related properties and behaviors
     */
    public TrMMOItemItem(TrBaseItem item, MMOItem mmoItem) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.mmoItem = mmoItem;
    }

    /**
     * Constructs a new MMOItemItem with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrMMOItemItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
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

    public static class Builder extends TrBaseItem.Builder {
        private MMOItem mmoItem;

        /**
         * Constructs a new Builder for creating MMOItemItem instances.
         *
         * @param id     The id of this item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        public Builder mmoItem(MMOItem mmoItem) {
            this.mmoItem = mmoItem;
            return this;
        }

        @Override
        public TrMMOItemItem build() {
            return new TrMMOItemItem(super.build(), mmoItem);
        }
    }
}
