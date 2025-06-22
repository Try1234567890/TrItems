package me.tr.trItems.item.items;

import org.bukkit.plugin.Plugin;

import java.io.File;

public class TrInventoryItem extends TrBaseItem {
    private int slot = 0;

    public TrInventoryItem(TrBaseItem item, int slot) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.slot = slot;
    }

    public TrInventoryItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public static class Builder extends TrBaseItem.Builder {
        private int slot;

        /**
         * Constructs a new Builder for creating TrInventoryItem instances.
         *
         * @param id     The id of this item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        public Builder slot(int slot) {
            this.slot = slot;
            return this;
        }

        public TrInventoryItem build() {
            return new TrInventoryItem(super.build(), slot);
        }
    }
}
