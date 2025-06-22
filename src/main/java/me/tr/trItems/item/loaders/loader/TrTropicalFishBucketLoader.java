package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrTropicalFishBucketItem;
import me.tr.trItems.utilities.ColorUtil;
import org.bukkit.DyeColor;
import org.bukkit.entity.TropicalFish;
import org.bukkit.plugin.Plugin;

import java.util.Optional;

public class TrTropicalFishBucketLoader extends TrBaseLoader {


    public TrTropicalFishBucketItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        DyeColor patternColor = getPatternColor(itemSection).orElse(null);
        DyeColor bodyColor = getBodyColor(itemSection).orElse(null);
        TropicalFish.Pattern pattern = getPattern(itemSection).getVanilla();
        return new TrTropicalFishBucketItem(baseItem, patternColor, bodyColor, pattern);
    }

    public TrTropicalFishBucketItem.Pattern getPattern(Section itemSection) {
        String patternStr = itemSection.getString("Pattern");
        return TrTropicalFishBucketItem.Pattern.parse(patternStr);
    }

    public Optional<DyeColor> getPatternColor(Section itemSection) {
        String colorStr = itemSection.getString("PatternColor");
        return Optional.ofNullable(DyeColor.getByColor(ColorUtil.parseColor(colorStr)));
    }

    public Optional<DyeColor> getBodyColor(Section itemSection) {
        String colorStr = itemSection.getString("BodyColor");
        return Optional.ofNullable(DyeColor.getByColor(ColorUtil.parseColor(colorStr)));
    }
}
