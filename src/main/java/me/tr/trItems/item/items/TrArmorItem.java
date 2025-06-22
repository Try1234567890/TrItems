package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrArmorMeta;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * The ArmorItem class extends BaseItem to represent armor items with trim functionality.
 * This class adds armor trim capabilities to the base item functionality.
 */
public class TrArmorItem extends TrBaseItem {
    private @Nullable ArmorTrim armorTrim;

    /**
     * Constructs an ArmorItem with all properties from a base item plus armor trim.
     *
     * @param item      The base item to inherit properties from
     * @param armorTrim The armor trim to apply to this armor item
     */
    public TrArmorItem(TrBaseItem item, @Nullable ArmorTrim armorTrim) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.armorTrim = armorTrim;
    }

    /**
     * Constructs an ArmorItem with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrArmorItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the armor trim applied to this armor item.
     *
     * @return The ArmorTrim instance applied to this armor item
     */
    public @Nullable ArmorTrim getArmorTrim() {
        return armorTrim;
    }

    /**
     * Sets the armor trim for this armor item.
     *
     * @param armorTrim The ArmorTrim to apply to this armor item
     */
    public void setArmorTrim(@Nullable ArmorTrim armorTrim) {
        this.armorTrim = armorTrim;
    }

    /**
     * Gets the ArmorMeta instance from the item stack.
     *
     * @return The ArmorMeta instance from the item stack, or null if the stack does not have an ArmorMeta
     **/
    @Override
    public @Nullable ArmorMeta getItemMeta() {
        return (ArmorMeta) super.getItemMeta();
    }

    /**
     * Sets the ArmorMeta for this item.
     *
     * @param player The player to set the meta for
     */
    @Override
    public void setMeta(Player player) {
        TrArmorMeta meta = new TrArmorMeta(this);
        meta.setMeta(player);
    }


    /**
     * Builder class for creating ArmorItem instances using the builder pattern.
     * Provides a fluent interface for constructing ArmorItem objects.
     */
    public static class Builder extends TrBaseItem.Builder {
        private ArmorTrim armorTrim;

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
         * Sets the armor trim for this builder.
         *
         * @param armorTrim The armor trim to apply to the ArmorItem
         * @return This builder instance for method chaining
         */
        public Builder armorTrim(ArmorTrim armorTrim) {
            this.armorTrim = armorTrim;
            return this;
        }

        /**
         * Builds and returns a new ArmorItem instance with the configured properties.
         *
         * @return A new ArmorItem instance
         */
        public TrArmorItem build() {
            return new TrArmorItem(super.build(), armorTrim);
        }
    }

}
