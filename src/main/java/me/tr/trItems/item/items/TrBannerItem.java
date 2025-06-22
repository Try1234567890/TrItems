package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrBannerMeta;
import org.bukkit.block.banner.Pattern;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The BannerItem class represents a banner item with additional properties.
 * It extends the BaseItem class and includes a property for the banner patterns.
 */
public class TrBannerItem extends TrBaseItem {
    private List<Pattern> patterns = new ArrayList<>();

    /**
     * Constructs a new BannerItem instance with the specified base item and banner patterns.
     *
     * @param item     The base item to be used for the banner item
     * @param patterns The banner patterns to be used for the banner item
     */
    public TrBannerItem(TrBaseItem item, List<Pattern> patterns) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.patterns = patterns;
    }

    /**
     * Constructs a new AxolotlBucketItem instance with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrBannerItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the banner patterns associated with this instance.
     *
     * @return The banner patterns associated with this instance
     */
    public List<Pattern> getPatterns() {
        return patterns;
    }

    /**
     * Sets the banner patterns for this instance.
     *
     * @param patterns The banner patterns to be used for this instance
     */
    public void setPatterns(List<Pattern> patterns) {
        this.patterns = patterns;
    }

    /**
     * Gets the BannerMeta instance from the item stack.
     *
     * @return The BannerMeta instance from the item stack, or null if the stack does not have a BannerMeta
     */
    @Override
    public @Nullable BannerMeta getItemMeta() {
        return (BannerMeta) super.getItemMeta();
    }

    /**
     * Sets the BannerMeta for this item.
     *
     * @param player The player to set the meta for
     */
    @Override
    public void setMeta(Player player) {
        TrBannerMeta meta = new TrBannerMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private List<Pattern> patterns;

        /**
         * Constructs a new Builder instance with the specified id, file, and plugin.
         *
         * @param id     The id of this item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }


        public Builder patterns(List<Pattern> patterns) {
            this.patterns = patterns;
            return this;
        }

        @Override
        public TrBannerItem build() {
            return new TrBannerItem(super.build(), patterns);
        }
    }
}