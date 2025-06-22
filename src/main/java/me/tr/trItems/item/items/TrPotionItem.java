package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrPotionMeta;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a custom Potion item, extending the functionality of BaseItem.
 * This class encapsulates properties specific to a potion, including its base type,
 * custom effects, main effect type, color, and custom name.
 */
public class TrPotionItem extends TrBaseItem {
    private @Nullable PotionType basePotionType;
    private List<PotionEffect> customEffects = new ArrayList<>();
    private @Nullable Color color;
    private @Nullable String customName;

    /**
     * Constructs a new PotionItem with specified properties.
     *
     * @param item           The base item to inherit properties from.
     * @param basePotionType The base potion type.
     * @param customEffects  The custom potion effect.
     * @param color          The color of the potion.
     * @param customName     The custom name of the potion.
     */
    public TrPotionItem(TrBaseItem item, @Nullable PotionType basePotionType, List<PotionEffect> customEffects, @Nullable Color color, @Nullable String customName) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.basePotionType = basePotionType;
        this.customEffects = customEffects;
        this.color = color;
        this.customName = customName;
    }

    /**
     * Constructs a new PotionItem with the specified id.
     *
     * @param id     The id of this item.
     * @param file   The file where this item is stored.
     * @param plugin The plugin that this item belongs to.
     */
    public TrPotionItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the base potion type.
     *
     * @return The base potion type.
     */
    public @Nullable PotionType getBasePotionType() {
        return basePotionType;
    }

    /**
     * Sets the base potion type.
     *
     * @param basePotionType The new base potion type to set.
     */
    public void setBasePotionType(@Nullable PotionType basePotionType) {
        this.basePotionType = basePotionType;
    }

    /**
     * Gets the custom potion effect.
     *
     * @return The custom potion effect.
     */
    public List<PotionEffect> getCustomEffects() {
        return customEffects;
    }

    /**
     * Sets the custom potion effect.
     *
     * @param customEffects The new custom potion effect to set.
     */
    public void setCustomEffect(List<PotionEffect> customEffects) {
        this.customEffects = customEffects;
    }

    /**
     * Gets the color of the potion.
     *
     * @return The color of the potion.
     */
    public @Nullable Color getColor() {
        return color;
    }

    /**
     * Sets the color of the potion.
     *
     * @param color The new color to set.
     */
    public void setColor(@Nullable Color color) {
        this.color = color;
    }

    /**
     * Gets the custom name of the potion.
     *
     * @return The custom name.
     */
    public @Nullable String getCustomName() {
        return customName;
    }

    /**
     * Sets the custom name of the potion.
     *
     * @param customName The new custom name to set.
     */
    public void setCustomName(@Nullable String customName) {
        this.customName = customName;
    }

    /**
     * Gets the PotionMeta instance from the item stack.
     *
     * @return The PotionMeta instance.
     */
    @Override
    public PotionMeta getItemMeta() {
        return (PotionMeta) super.getItemMeta();
    }

    /**
     * Sets the PotionMeta for this item.
     *
     * @param player The player to set the meta for.
     */
    @Override
    public void setMeta(Player player) {
        TrPotionMeta meta = new TrPotionMeta(this);
        meta.setMeta(player);
    }

    /**
     * Builder class for creating PotionItem instances.
     * Allows for a more flexible and readable way of creating complex PotionItem objects.
     */
    public static class Builder extends TrBaseItem.Builder {
        private PotionType basePotionType;
        private List<PotionEffect> customEffects;
        private Color color;
        private String customName;

        /**
         * Constructs a new Builder instance for creating a PotionItem.
         *
         * @param id     The id of the item.
         * @param file   The file where this item is stored.
         * @param plugin The plugin that this item belongs to.
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the base potion type.
         *
         * @param basePotionType The base potion type to set.
         * @return The Builder instance for method chaining.
         */
        public Builder basePotionType(PotionType basePotionType) {
            this.basePotionType = basePotionType;
            return this;
        }

        /**
         * Sets the custom effect.
         *
         * @param customEffects The custom effect to set.
         * @return The Builder instance for method chaining.
         */
        public Builder customEffect(List<PotionEffect> customEffects) {
            this.customEffects = customEffects;
            return this;
        }

        /**
         * Sets the color.
         *
         * @param color The color to set.
         * @return The Builder instance for method chaining.
         */
        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        /**
         * Sets the custom name.
         *
         * @param customName The custom name to set.
         * @return The Builder instance for method chaining.
         */
        public Builder customName(String customName) {
            this.customName = customName;
            return this;
        }

        /**
         * Builds and returns a new PotionItem instance with the configured properties.
         *
         * @return A new PotionItem instance.
         */
        public TrPotionItem build() {
            return new TrPotionItem(super.build(), basePotionType, customEffects, color, customName);
        }
    }
}
