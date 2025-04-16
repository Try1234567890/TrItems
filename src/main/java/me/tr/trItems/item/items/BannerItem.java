package me.tr.trItems.item.items;

import org.bukkit.block.banner.Pattern;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BannerMeta;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * The BannerItem class represents a banner item with additional properties.
 * It extends the BaseItem class and includes a property for the banner patterns.
 */
public class BannerItem extends BaseItem {
    private List<Pattern> patterns;

    /**
     * Constructs a new BannerItem instance with the specified base item and banner patterns.
     *
     * @param item     The base item to be used for the banner item
     * @param patterns The banner patterns to be used for the banner item
     */
    public BannerItem(BaseItem item, List<Pattern> patterns) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.patterns = patterns;
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


    public @Nullable BannerMeta getItemMeta() {
        return (BannerMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.BannerMeta meta = new me.tr.trItems.item.metas.BannerMeta();
        meta.setMeta(this, player);
    }
}