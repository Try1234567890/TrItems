package me.tr.trItems.item.loaders.loader;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.ItemManager;
import me.tr.trItems.item.items.TrBannerItem;
import me.tr.trItems.item.items.TrBaseItem;
import org.bukkit.DyeColor;
import org.bukkit.NamespacedKey;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class TrBannerLoader extends TrBaseLoader {


    public TrBannerItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        List<Pattern> patterns = getPatterns(itemSection);
        return new TrBannerItem(baseItem, patterns);
    }

    public List<Pattern> getPatterns(Section item) {
        final List<Pattern> patterns = new ArrayList<>();
        List<String> patternsStr = item.getStringList("Patterns");
        for (String patternStr : patternsStr) {
            String[] patternSplit = patternStr.split(" ");
            if (patternSplit.length < 2) {
                main.getLogger().error("Pattern " + patternStr + " not contains enough information.");
                continue;
            }
            NamespacedKey key = ItemManager.getInstance().parseNamespacedKey(patternSplit[0]);
            PatternType patternType = RegistryAccess.registryAccess().getRegistry(RegistryKey.BANNER_PATTERN).get(key);
            if (patternType == null)
                throw new NullPointerException("Could not find pattern " + patternStr);
            try {
                DyeColor color = DyeColor.valueOf(patternSplit[1]);
                patterns.add(new Pattern(color, patternType));
            } catch (IllegalArgumentException | NullPointerException e) {
                throw new IllegalArgumentException("Invalid DyeColor " + patternSplit[1]);
            }
        }
        return patterns;
    }

}
