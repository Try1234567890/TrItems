package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.TropicalFishBucketItem;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.entity.TropicalFish;
import org.bukkit.plugin.Plugin;

public class TropicalFishBucketLoader extends BaseLoader {


    public TropicalFishBucketItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        DyeColor patternColor = getPatternColor(itemSection);
        DyeColor bodyColor = getBodyColor(itemSection);
        TropicalFish.Pattern pattern = getPattern(itemSection);
        return new TropicalFishBucketItem(baseItem, patternColor, bodyColor, pattern);
    }

    public TropicalFish.Pattern getPattern(Section itemSection) {
        String patternStr = itemSection.getString("Pattern");
        try {
            return TropicalFish.Pattern.valueOf(patternStr);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid pattern: " + patternStr);
        }

    }

    public DyeColor getPatternColor(Section itemSection) {
        String colorStr = itemSection.getString("PatternColor");
        Color color = main.getItemLoaderManager().convertColor(colorStr);
        if (color != null)
            return DyeColor.getByColor(color);
        return null;
    }

    public DyeColor getBodyColor(Section itemSection) {
        String colorStr = itemSection.getString("BodyColor");
        Color color = main.getItemLoaderManager().convertColor(colorStr);
        if (color != null)
            return DyeColor.getByColor(color);
        return null;
    }
}
