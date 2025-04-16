package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.ShieldItem;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.plugin.Plugin;

public class ShieldLoader extends BaseLoader {

    public ShieldItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        DyeColor color = getColor(itemSection);
        return new ShieldItem(baseItem, color);
    }

    public DyeColor getColor(Section itemSection) {
        String colorStr = itemSection.getString("Color");
        Color color = main.getItemLoaderManager().convertColor(colorStr);
        if (color != null)
            return DyeColor.getByColor(color);
        return null;
    }

}
