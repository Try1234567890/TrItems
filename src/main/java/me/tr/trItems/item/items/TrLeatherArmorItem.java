package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrLeatherArmorMeta;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * Represents a custom leather armor item that extends the functionality of an armor item.
 * This class allows setting and retrieving the color of the leather armor.
 */
public class TrLeatherArmorItem extends TrArmorItem {
    private @Nullable Color color;

    /**
     * Constructs a new LeatherArmorItem with the specified armor item properties and color.
     *
     * @param item  The armor item to extend.
     * @param color The color of the leather armor.
     */
    public TrLeatherArmorItem(TrArmorItem item, @Nullable Color color) {
        super(item, item.getArmorTrim());
        this.color = color;
    }

    /**
     * Constructs a new KnowledgeBookItem with the specified id.
     *
     * @param id     The id of this item.
     * @param file   The file where this item is stored.
     * @param plugin The plugin that this item belongs to.
     */
    public TrLeatherArmorItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the color of the leather armor.
     *
     * @return The color of the armor.
     */
    public @Nullable Color getColor() {
        return color;
    }

    /**
     * Sets the color of the leather armor.
     *
     * @param color The new color of the armor.
     */
    public void setColor(@Nullable Color color) {
        this.color = color;
    }

    /**
     * Gets the LeatherArmorMeta instance from the item stack.
     *
     * @return The LeatherArmorMeta instance.
     */
    public LeatherArmorMeta getArmorMeta() {
        return (LeatherArmorMeta) super.getItemMeta();
    }

    /**
     * Sets the LeatherArmorMeta for this item.
     *
     * @param player The player to set the meta for.
     */
    @Override
    public void setMeta(Player player) {
        TrLeatherArmorMeta meta = new TrLeatherArmorMeta(this);
        meta.setMeta(player);
    }


    public static class Builder extends TrArmorItem.Builder {
        private Color color;

        /**
         * Constructs a new Builder instance for creating a LeatherArmorItem.
         *
         * @param id     The id of the item.
         * @param file   The file where this item is stored.
         * @param plugin The plugin that this item belongs to.
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the color of the leather armor.
         *
         * @param color The color to set.
         * @return The builder instance for method chaining.
         */
        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        /**
         * Builds and returns a new LeatherArmorItem instance with the specified properties.
         *
         * @return A new LeatherArmorItem instance.
         */
        public TrLeatherArmorItem build() {
            return new TrLeatherArmorItem(super.build(), color);
        }
    }
}
