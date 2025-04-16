package me.tr.trItems.item.items;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

import java.util.List;

/**
 * Represents a custom Potion item, extending the functionality of BaseItem.
 * This class encapsulates properties specific to a potion, including its base type,
 * custom effects, main effect type, color, and custom name.
 */
public class PotionItem extends BaseItem {
    private PotionType basePotionType;
    private List<PotionEffect> customEffects;
    private Color color;
    private String customName;

    /**
     * Constructs a new PotionItem with specified properties.
     *
     * @param item           The base item to inherit properties from.
     * @param basePotionType The base potion type.
     * @param customEffects  The custom potion effect.
     * @param color          The color of the potion.
     * @param customName     The custom name of the potion.
     */
    public PotionItem(BaseItem item, PotionType basePotionType, List<PotionEffect> customEffects, Color color, String customName) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.basePotionType = basePotionType;
        this.customEffects = customEffects;
        this.color = color;
        this.customName = customName;
    }

    /**
     * Gets the base potion type.
     *
     * @return The base potion type.
     */
    public PotionType getBasePotionType() {
        return basePotionType;
    }

    /**
     * Sets the base potion type.
     *
     * @param basePotionType The new base potion type to set.
     */
    public void setBasePotionType(PotionType basePotionType) {
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
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the potion.
     *
     * @param color The new color to set.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the custom name of the potion.
     *
     * @return The custom name.
     */
    public String getCustomName() {
        return customName;
    }

    /**
     * Sets the custom name of the potion.
     *
     * @param customName The new custom name to set.
     */
    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public PotionMeta getItemMeta() {
        return (PotionMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.PotionMeta meta = new me.tr.trItems.item.metas.PotionMeta();
        meta.setMeta(this, player);
    }

    @Override
    public String toString() {
        return "PotionItem{" +
                ", basePotionType=" + basePotionType +
                ", customEffects=" + customEffects +
                ", color=" + color +
                ", customName='" + customName + '\'' +
                '}';
    }

    /**
     * Builder class for creating PotionItem instances.
     * Allows for a more flexible and readable way of creating complex PotionItem objects.
     */
    public static class Builder {
        private final BaseItem baseItem;
        private PotionType basePotionType;
        private List<PotionEffect> customEffects;
        private Color color;
        private String customName;

        /**
         * Constructs a new Builder with a base item.
         *
         * @param baseItem The base item to use for the PotionItem.
         */
        public Builder(BaseItem baseItem) {
            this.baseItem = baseItem;
        }

        /**
         * Sets the base potion type.
         *
         * @param basePotionType The base potion type to set.
         * @return The Builder instance for method chaining.
         */
        public Builder setBasePotionType(PotionType basePotionType) {
            this.basePotionType = basePotionType;
            return this;
        }

        /**
         * Sets the custom effect.
         *
         * @param customEffects The custom effect to set.
         * @return The Builder instance for method chaining.
         */
        public Builder setCustomEffect(List<PotionEffect> customEffects) {
            this.customEffects = customEffects;
            return this;
        }

        /**
         * Sets the color.
         *
         * @param color The color to set.
         * @return The Builder instance for method chaining.
         */
        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

        /**
         * Sets the custom name.
         *
         * @param customName The custom name to set.
         * @return The Builder instance for method chaining.
         */
        public Builder setCustomName(String customName) {
            this.customName = customName;
            return this;
        }

        /**
         * Builds and returns a new PotionItem instance with the configured properties.
         *
         * @return A new PotionItem instance.
         */
        public PotionItem build() {
            return new PotionItem(baseItem, basePotionType, customEffects, color, customName);
        }
    }
}
