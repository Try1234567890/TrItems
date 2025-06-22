package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.items.TrArmorItem;
import me.tr.trItems.item.items.TrLeatherArmorItem;
import me.tr.trItems.utilities.ColorUtil;
import org.bukkit.Color;
import org.bukkit.plugin.Plugin;


public class TrLeatherArmorLoader extends TrArmorLoader {

    public TrLeatherArmorItem load(Plugin plugin, Section itemSection) {
        TrArmorItem armorItem = super.load(plugin, itemSection);
        Color color = getColor(itemSection);
        return new TrLeatherArmorItem(armorItem, color);
    }

    public Color getColor(Section itemSection) {
        return ColorUtil.parseColor(itemSection.getString("Color"));
    }

}
