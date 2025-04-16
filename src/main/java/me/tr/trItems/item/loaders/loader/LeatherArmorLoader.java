package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.ArmorItem;
import me.tr.trItems.item.items.LeatherArmorItem;
import org.bukkit.Color;
import org.bukkit.plugin.Plugin;


public class LeatherArmorLoader extends ArmorLoader {

    public LeatherArmorItem load(Plugin plugin, Section itemSection) {
        ArmorItem armorItem = super.load(plugin, itemSection);
        Color color = getColor(itemSection);
        return new LeatherArmorItem(armorItem, color);
    }

    public Color getColor(Section itemSection) {
        return main.getItemLoaderManager().convertColor(itemSection.getString("Color"));
    }

}
