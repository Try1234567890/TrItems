package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrShieldMeta;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ShieldMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class TrShieldItem extends TrBaseItem {
    private @Nullable DyeColor color;

    /**
     * Constructs a new ShieldItem with the specified base item properties and color.
     *
     * @param item  The base item to extend.
     * @param color The color of the shield.
     */
    public TrShieldItem(TrBaseItem item, @Nullable DyeColor color) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.color = color;
    }

    /**
     * Constructs a new ShieldItem with the specified id.
     *
     * @param id     The id of this item.
     * @param file   The file where this item is stored.
     * @param plugin The plugin that this item belongs to.
     */
    public TrShieldItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the color of the shield.
     *
     * @return The color of the shield.
     */
    public @Nullable DyeColor getColor() {
        return color;
    }

    /**
     * Sets the color of the shield.
     *
     * @param color The new color of the shield.
     */
    public void setColor(@Nullable DyeColor color) {
        this.color = color;
    }

    /**
     * Gets the ShieldMeta instance from the item stack.
     *
     * @return The ShieldMeta instance.
     */
    @Override
    public ShieldMeta getItemMeta() {
        return (ShieldMeta) super.getItemMeta();
    }

    /**
     * Sets the ShieldMeta instance to the item stack.
     *
     * @param player The player to set the meta for.
     */
    @Override
    public void setMeta(Player player) {
        TrShieldMeta meta = new TrShieldMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private DyeColor color;

        /**
         * Constructs a new Builder for creating ShieldItem instances.
         *
         * @param id     The id of this item.
         * @param file   The file where this item is stored.
         * @param plugin The plugin that this item belongs to.
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the color of the shield.
         *
         * @param color The color to set.
         * @return The builder instance for method chaining.
         */
        public Builder color(DyeColor color) {
            this.color = color;
            return this;
        }

        public TrShieldItem build() {
            return new TrShieldItem(super.build(), color);
        }
    }
}
