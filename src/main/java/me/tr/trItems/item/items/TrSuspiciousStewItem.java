package me.tr.trItems.item.items;

import io.papermc.paper.potion.SuspiciousEffectEntry;
import me.tr.trItems.item.metas.TrSuspiciousStewMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SuspiciousStewMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TrSuspiciousStewItem extends TrBaseItem {
    private List<SuspiciousEffectEntry> suspiciousEffects = new ArrayList<>();

    /**
     * Constructs a new SuspiciousStewItem with the specified properties.
     *
     * @param item              The base item to inherit properties from
     * @param suspiciousEffects The list of suspicious effects associated with this stew
     */
    public TrSuspiciousStewItem(TrBaseItem item, List<SuspiciousEffectEntry> suspiciousEffects) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.suspiciousEffects = suspiciousEffects;
    }

    /**
     * Constructs a new SuspiciousStewItem with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrSuspiciousStewItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the list of suspicious effects associated with this stew.
     *
     * @return A List of SuspiciousEffectEntry objects representing the effects
     */
    public List<SuspiciousEffectEntry> getSuspiciousEffects() {
        return suspiciousEffects;
    }


    /**
     * Sets the list of suspicious effects associated with this stew.
     *
     * @param suspiciousEffects A List of SuspiciousEffectEntry objects to be associated with the stew
     */
    public void setSuspiciousEffects(List<SuspiciousEffectEntry> suspiciousEffects) {
        this.suspiciousEffects = suspiciousEffects;
    }

    /**
     * Gets the SuspiciousStewMeta instance from the item stack.
     *
     * @return The SuspiciousStewMeta instance
     */
    public SuspiciousStewMeta getItemMeta() {
        return (SuspiciousStewMeta) super.getItemMeta();
    }

    /**
     * Sets the SuspiciousStewMeta instance to the item stack.
     *
     * @param player The player who is setting the meta
     */
    public void setMeta(Player player) {
        TrSuspiciousStewMeta meta = new TrSuspiciousStewMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private List<SuspiciousEffectEntry> suspiciousEffects;


        /**
         * Constructs a new Builder instance for creating a SuspiciousStewItem.
         *
         * @param id     The id of the item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the list of suspicious effects for this item.
         *
         * @param suspiciousEffects The list of suspicious effects to be set
         * @return The Builder instance for method chaining
         */
        public Builder suspiciousEffects(List<SuspiciousEffectEntry> suspiciousEffects) {
            this.suspiciousEffects = suspiciousEffects;
            return this;
        }

        /**
         * Builds and returns a new SuspiciousStewItem instance.
         *
         * @return A new SuspiciousStewItem instance
         */
        public TrSuspiciousStewItem build() {
            return new TrSuspiciousStewItem(super.build(), suspiciousEffects);
        }
    }
}
