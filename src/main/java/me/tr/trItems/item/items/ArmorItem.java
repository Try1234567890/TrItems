package me.tr.trItems.item.items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.jetbrains.annotations.Nullable;

/**
 * The ArmorItem class extends BaseItem to represent armor items with trim functionality.
 * This class adds armor trim capabilities to the base item functionality.
 */
public class ArmorItem extends BaseItem {
    private ArmorTrim armorTrim;

    /**
     * Constructs an ArmorItem with all properties from a base item plus armor trim.
     *
     * @param item      The base item to inherit properties from
     * @param armorTrim The armor trim to apply to this armor item
     */
    public ArmorItem(BaseItem item, ArmorTrim armorTrim) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.armorTrim = armorTrim;
    }

    /**
     * Gets the armor trim applied to this armor item.
     *
     * @return The ArmorTrim instance applied to this armor item
     */
    public ArmorTrim getArmorTrim() {
        return armorTrim;
    }

    /**
     * Sets the armor trim for this armor item.
     *
     * @param armorTrim The ArmorTrim to apply to this armor item
     */
    public void setArmorTrim(ArmorTrim armorTrim) {
        this.armorTrim = armorTrim;
    }

    /**
     * Gets the ArmorMeta instance from the item stack.
     *
     * @return The ArmorMeta instance from the item stack, or null if the stack does not have an ArmorMeta
     **/
    public @Nullable ArmorMeta getItemMeta() {
        return (ArmorMeta) super.getItemMeta();
    }


    public void setMeta(Player player) {
        me.tr.trItems.item.metas.ArmorMeta meta = new me.tr.trItems.item.metas.ArmorMeta();
        meta.setMeta(this, player);
    }


    /**
     * Builder class for creating ArmorItem instances using the builder pattern.
     * Provides a fluent interface for constructing ArmorItem objects.
     */
    public static class Builder {
        private BaseItem baseItem;
        private ArmorTrim armorTrim;

        /**
         * Constructs a Builder with a specified base item.
         *
         * @param baseItem The base item to use for the ArmorItem
         */
        public Builder(BaseItem baseItem) {
            this.baseItem = baseItem;
        }

        /**
         * Sets the base item for this builder.
         *
         * @param baseItem The base item to use for the ArmorItem
         * @return This builder instance for method chaining
         */
        public Builder setBaseItem(BaseItem baseItem) {
            this.baseItem = baseItem;
            return this;
        }

        /**
         * Sets the armor trim for this builder.
         *
         * @param armorTrim The armor trim to apply to the ArmorItem
         * @return This builder instance for method chaining
         */
        public Builder setArmorTrim(ArmorTrim armorTrim) {
            this.armorTrim = armorTrim;
            return this;
        }

        /**
         * Builds and returns a new ArmorItem instance with the configured properties.
         *
         * @return A new ArmorItem instance
         * @throws NullPointerException if the base item is null
         */
        public ArmorItem build() {
            return new ArmorItem(baseItem, armorTrim);
        }
    }

}
