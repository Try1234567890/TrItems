package me.tr.trItems.item.items;

import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.meta.TropicalFishBucketMeta;

/**
 * Represents a Tropical Fish Bucket item, extending the functionality of BaseItem.
 * This class encapsulates the properties specific to a tropical fish, including its pattern color,
 * body color, and pattern type.
 */
public class TropicalFishBucketItem extends BaseItem {
    private DyeColor patternColor;
    private DyeColor bodyColor;
    private TropicalFish.Pattern pattern;

    /**
     * Constructs a new TropicalFishBucketItem.
     *
     * @param item         The base item to inherit properties from.
     * @param patternColor The color of the fish's pattern.
     * @param bodyColor    The color of the fish's body.
     * @param pattern      The pattern type of the fish.
     */
    public TropicalFishBucketItem(BaseItem item, DyeColor patternColor, DyeColor bodyColor, TropicalFish.Pattern pattern) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.patternColor = patternColor;
        this.bodyColor = bodyColor;
        this.pattern = pattern;
    }

    /**
     * Gets the color of the tropical fish's pattern.
     *
     * @return The pattern color.
     */
    public DyeColor getPatternColor() {
        return patternColor;
    }

    /**
     * Sets the color of the tropical fish's pattern.
     *
     * @param patternColor The new pattern color to set.
     */
    public void setPatternColor(DyeColor patternColor) {
        this.patternColor = patternColor;
    }

    /**
     * Gets the color of the tropical fish's body.
     *
     * @return The body color.
     */
    public DyeColor getBodyColor() {
        return bodyColor;
    }

    /**
     * Sets the color of the tropical fish's body.
     *
     * @param bodyColor The new body color to set.
     */
    public void setBodyColor(DyeColor bodyColor) {
        this.bodyColor = bodyColor;
    }

    /**
     * Gets the pattern type of the tropical fish.
     *
     * @return The pattern type.
     */
    public TropicalFish.Pattern getPattern() {
        return pattern;
    }

    /**
     * Sets the pattern type of the tropical fish.
     *
     * @param pattern The new pattern type to set.
     */
    public void setPattern(TropicalFish.Pattern pattern) {
        this.pattern = pattern;
    }


    public TropicalFishBucketMeta getItemMeta() {
        return (TropicalFishBucketMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.TropicalFishBucketMeta meta = new me.tr.trItems.item.metas.TropicalFishBucketMeta();
        meta.setMeta(this, player);
    }
}