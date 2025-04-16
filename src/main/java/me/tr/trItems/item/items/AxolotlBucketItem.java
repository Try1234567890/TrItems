package me.tr.trItems.item.items;

import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.AxolotlBucketMeta;

/**
 * The AxolotlBucketItem class represents an axolotl bucket item with additional properties.
 * It extends the BaseItem class and includes a property for the axolotl variant.
 */
public class AxolotlBucketItem extends BaseItem {
    private Axolotl.Variant variant;

    /**
     * Constructs a new AxolotlBucketItem instance with the specified base item and axolotl variant.
     *
     * @param item    The base item to be used for the axolotl bucket item
     * @param variant The axolotl variant to be used for the axolotl bucket item
     */
    public AxolotlBucketItem(BaseItem item, Axolotl.Variant variant) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.variant = variant;
    }

    /**
     * Gets the axolotl variant associated with this instance.
     *
     * @return The axolotl variant associated with this instance
     */
    public Axolotl.Variant getVariant() {
        return variant;
    }

    /**
     * Sets the axolotl variant for this instance.
     *
     * @param variant The axolotl variant to be used for this instance
     */
    public void setVariant(Axolotl.Variant variant) {
        this.variant = variant;
    }

    public AxolotlBucketMeta getItemMeta() {
        return (AxolotlBucketMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.AxolotlBucketMeta meta = new me.tr.trItems.item.metas.AxolotlBucketMeta();
        meta.setMeta(this, player);
    }
}