package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrShieldItem;
import me.tr.trItems.utilities.ColorUtil;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.plugin.Plugin;

public class TrShieldLoader extends TrBaseLoader {

    public TrShieldItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        DyeColor color = getColor(itemSection);
        return new TrShieldItem(baseItem, color);
    }

    public DyeColor getColor(Section itemSection) {
        String colorStr = itemSection.getString("Color");
        Color color = ColorUtil.parseColor(colorStr);
        if (color != null)
            return DyeColor.getByColor(color);
        return null;
    }

}
