package me.tr.trItems.item.items;

import me.tr.trItems.TrItems;
import me.tr.trItems.item.metas.TrTropicalFishBucketMeta;
import me.tr.trItems.utilities.EnumUtil;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.meta.TropicalFishBucketMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * Represents a Tropical Fish Bucket item, extending the functionality of BaseItem.
 * This class encapsulates the properties specific to a tropical fish, including its pattern color,
 * body color, and pattern type.
 */
public class TrTropicalFishBucketItem extends TrBaseItem {
    private @Nullable DyeColor patternColor;
    private @Nullable DyeColor bodyColor;
    private @Nullable TropicalFish.Pattern pattern;

    /**
     * Constructs a new TropicalFishBucketItem.
     *
     * @param item         The base item to inherit properties from.
     * @param patternColor The color of the fish's pattern.
     * @param bodyColor    The color of the fish's body.
     * @param pattern      The pattern type of the fish.
     */
    public TrTropicalFishBucketItem(TrBaseItem item, @Nullable DyeColor patternColor, @Nullable DyeColor bodyColor, TropicalFish.@Nullable Pattern pattern) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.patternColor = patternColor;
        this.bodyColor = bodyColor;
        this.pattern = pattern;
    }

    /**
     * Constructs a new TropicalFishBucketItem with the specified id.
     *
     * @param id     The id of this item.
     * @param file   The file where this item is stored.
     * @param plugin The plugin that this item belongs to.
     */
    public TrTropicalFishBucketItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the color of the tropical fish's pattern.
     *
     * @return The pattern color.
     */
    public @Nullable DyeColor getPatternColor() {
        return patternColor;
    }

    /**
     * Sets the color of the tropical fish's pattern.
     *
     * @param patternColor The new pattern color to set.
     */
    public void setPatternColor(@Nullable DyeColor patternColor) {
        this.patternColor = patternColor;
    }

    /**
     * Gets the color of the tropical fish's body.
     *
     * @return The body color.
     */
    public @Nullable DyeColor getBodyColor() {
        return bodyColor;
    }

    /**
     * Sets the color of the tropical fish's body.
     *
     * @param bodyColor The new body color to set.
     */
    public void setBodyColor(@Nullable DyeColor bodyColor) {
        this.bodyColor = bodyColor;
    }

    /**
     * Gets the pattern type of the tropical fish.
     *
     * @return The pattern type.
     */
    public TropicalFish.@Nullable Pattern getPattern() {
        return pattern;
    }

    /**
     * Sets the pattern type of the tropical fish.
     *
     * @param pattern The new pattern type to set.
     */
    public void setPattern(TropicalFish.@Nullable Pattern pattern) {
        this.pattern = pattern;
    }

    /**
     * Gets the TropicalFishBucketMeta instance from the item stack.
     *
     * @return The TropicalFishBucketMeta instance from the item stack, or null if the stack does not have a TropicalFishBucketMeta.
     */
    @Override
    public TropicalFishBucketMeta getItemMeta() {
        return (TropicalFishBucketMeta) super.getItemMeta();
    }

    /**
     * Sets the TropicalFishBucketMeta for this item.
     *
     * @param player The player to set the meta for.
     */
    @Override
    public void setMeta(Player player) {
        TrTropicalFishBucketMeta meta = new TrTropicalFishBucketMeta(this);
        meta.setMeta(player);
    }

    public enum Pattern {
        KOB(TropicalFish.Pattern.KOB, "KOB", "ORANGE_WHITE", "ORANGE-WHITE", "ORANGEWHITE", "WHITE_ORANGE", "WHITE-ORANGE", "WHITEORANGE"),
        SUNSTREAK(TropicalFish.Pattern.SUNSTREAK, "SUN_STREAK", "LIGHTBLUE_GRAY", "LIGHT_BLUE_GRAY", "LIGHT-BLUE_GRAY", "LIGHTBLUE-GRAY", "LIGHT_BLUE-GRAY", "LIGHT-BLUE-GRAY", "LIGHTBLUEGRAY", "LIGHT_BLUEGRAY", "LIGHT-BLUEGRAY", "GRAY_LIGHTBLUE", "GRAY_LIGHT_BLUE", "GRAY_LIGHT-BLUE", "GRAY-LIGHTBLUE", "GRAY-LIGHT_BLUE", "GRAY-LIGHT-BLUE", "GRAYLIGHTBLUE", "GRAYLIGHT_BLUE", "GRAYLIGHT-BLUE"),
        SNOOPER(TropicalFish.Pattern.SNOOPER, "SNOOPER", "GRAY_RED", "GRAY-RED", "GRAYRED", "RED_GRAY", "RED-GRAY", "REDGRAY"),
        DASHER(TropicalFish.Pattern.DASHER, "DASHER", "CYAN_PINK", "CYAN-PINK", "CYANPINK", "PINK_CYAN", "PINK-CYAN", "PINKCYAN"),
        BRINELY(TropicalFish.Pattern.BRINELY, "BRINELY", "LIGHTBLUE_LIME", "LIGHT_BLUE_LIME", "LIGHT-BLUE_LIME", "LIGHTBLUE-LIME", "LIGHT_BLUE-LIME", "LIGHT-BLUE-LIME", "LIGHTBLUELIME", "LIGHT_BLUELIME", "LIGHT-BLUELIME", "LIME_LIGHTBLUE", "LIME_LIGHT_BLUE", "LIME_LIGHT-BLUE", "LIME-LIGHTBLUE", "LIME-LIGHT_BLUE", "LIME-LIGHT-BLUE", "LIMELIGHTBLUE", "LIMELIGHT_BLUE", "LIMELIGHT-BLUE"),
        SPOTTY(TropicalFish.Pattern.SPOTTY, "SPOTTY", "S_WHITE_YELLOW", "S-WHITE-YELLOW", "SWHITEYELLOW", "YELLOW_WHITE_S", "YELLOW-WHITE-S", "YELLOWWHITES"),
        FLOPPER(TropicalFish.Pattern.FLOPPER, "FLOPPER", "F_WHITE_YELLOW", "F-WHITE-YELLOW", "FWHITEYELLOW", "YELLOW_WHITE_F", "YELLOW-WHITE-F", "YELLOWWHITEF"),
        STRIPEY(TropicalFish.Pattern.STRIPEY, "STRIPEY", "GRAY_ORANGE", "GRAY-ORANGE", "GRAYORANGE", "ORANGE_GRAY", "ORANGE-GRAY", "ORANGEGRAY"),
        GLITTER(TropicalFish.Pattern.GLITTER, "GLITTER", "G_GRAY_WHITE", "G-GRAY-WHITE", "GGRAYWHITE", "WHITE_GRAY_G", "WHITE-GRAY-G", "WHITEGRAYG"),
        BLOCKFISH(TropicalFish.Pattern.BLOCKFISH, "BLOCK_FISH", "PURPLE_YELLOW", "PURPLE-YELLOW", "PURPLEYELLOW", "YELLOW_PURPLE", "YELLOW-PURPLE", "YELLOWPURPLE"),
        BETTY(TropicalFish.Pattern.BETTY, "BETTY", "RED_WHITE", "RED-WHITE", "REDWHITE", "WHITE_RED", "WHITE-RED", "WHITERED"),
        CLAYFISH(TropicalFish.Pattern.CLAYFISH, "CLAY_FISH", "C_GRAY_WHITE", "C-GRAY-WHITE", "CGRAYWHITE", "WHITE_GRAY_C", "WHITE-GRAY-C", "WHITEGRAYC");

        private final String[] ids;
        private final TropicalFish.Pattern vanilla;


        Pattern(TropicalFish.Pattern vanilla, String... ids) {
            this.vanilla = vanilla;
            this.ids = EnumUtil.expandIDs(ids);
        }

        public static Pattern parse(String str) {
            for (Pattern pattern : Pattern.values()) {
                for (String id : pattern.ids) {
                    if (EnumUtil.equalsAtPercentage(id, str, 75)) {
                        return pattern;
                    }
                }
            }
            TrItems.getInstance().getLogger().warn("Tropical fish pattern %s not found.".formatted(str));
            return null;
        }

        public String[] getIds() {
            return ids;
        }

        public TropicalFish.Pattern getVanilla() {
            return vanilla;
        }
    }

    public static class Builder extends TrBaseItem.Builder {
        private DyeColor patternColor;
        private DyeColor bodyColor;
        private TropicalFish.Pattern pattern;

        /**
         * Constructs a new Builder instance with the specified id, file, and plugin.
         *
         * @param id     The id of this item.
         * @param file   The file where this item is stored.
         * @param plugin The plugin that this item belongs to.
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the pattern color of the tropical fish.
         *
         * @param patternColor The new pattern color to set.
         * @return The builder instance for method chaining.
         */
        public Builder patternColor(DyeColor patternColor) {
            this.patternColor = patternColor;
            return this;
        }

        /**
         * Sets the body color of the tropical fish.
         *
         * @param bodyColor The new body color to set.
         * @return The builder instance for method chaining.
         */
        public Builder bodyColor(DyeColor bodyColor) {
            this.bodyColor = bodyColor;
            return this;
        }

        /**
         * Sets the pattern type of the tropical fish.
         *
         * @param pattern The new pattern type to set.
         * @return The builder instance for method chaining.
         */
        public Builder pattern(TropicalFish.Pattern pattern) {
            this.pattern = pattern;
            return this;
        }

        /**
         * Builds the TropicalFishBucketItem with the specified properties.
         *
         * @return The constructed TropicalFishBucketItem.
         */
        public TrTropicalFishBucketItem build() {
            return new TrTropicalFishBucketItem(super.build(), patternColor, bodyColor, pattern);
        }
    }
}