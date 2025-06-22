package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrAxolotlBucketMeta;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.AxolotlBucketMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * The AxolotlBucketItem class represents an axolotl bucket item with additional properties.
 * It extends the BaseItem class and includes a property for the axolotl variant.
 */
public class TrAxolotlBucketItem extends TrBaseItem {
    private @Nullable Axolotl.Variant variant;

    /**
     * Constructs a new AxolotlBucketItem instance with the specified base item and axolotl variant.
     *
     * @param item    The base item to be used for the axolotl bucket item
     * @param variant The axolotl variant to be used for the axolotl bucket item
     */
    public TrAxolotlBucketItem(TrBaseItem item, Axolotl.@Nullable Variant variant) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.variant = variant;
    }

    /**
     * Constructs a new AxolotlBucketItem instance with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrAxolotlBucketItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the axolotl variant associated with this instance.
     *
     * @return The axolotl variant associated with this instance
     */
    public Axolotl.@Nullable Variant getVariant() {
        return variant;
    }

    /**
     * Sets the axolotl variant for this instance.
     *
     * @param variant The axolotl variant to be used for this instance
     */
    public void setVariant(Axolotl.@Nullable Variant variant) {
        this.variant = variant;
    }

    /**
     * Gets the AxolotlBucketMeta instance from the item stack.
     *
     * @return The AxolotlBucketMeta instance from the item stack, or null if the stack does not have an AxolotlBucketMeta
     */
    @Override
    public AxolotlBucketMeta getItemMeta() {
        return (AxolotlBucketMeta) super.getItemMeta();
    }

    /**
     * Sets the AxolotlBucketMeta for this item.
     *
     * @param player The player to set the meta for
     */
    @Override
    public void setMeta(Player player) {
        TrAxolotlBucketMeta meta = new TrAxolotlBucketMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private Axolotl.Variant variant;

        /**
         * Constructs a new Builder instance for creating an AxolotlBucketItem.
         *
         * @param id     The id of the item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        public Builder variant(Axolotl.Variant variant) {
            this.variant = variant;
            return this;
        }

        public TrAxolotlBucketItem build() {
            return new TrAxolotlBucketItem(super.build(), variant);
        }
    }
}