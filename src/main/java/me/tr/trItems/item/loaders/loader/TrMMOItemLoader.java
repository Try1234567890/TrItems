package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.TrItems;
import me.tr.trItems.hooks.MMOItemsHook;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrMMOItemItem;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.Type;
import net.Indyuce.mmoitems.api.item.mmoitem.MMOItem;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class TrMMOItemLoader extends TrBaseLoader {
    private final TrItems main = TrItems.getInstance();

    public @Nullable TrMMOItemItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        MMOItem mmoItem = getMMOItem(itemSection);
        if (mmoItem == null)
            return new TrMMOItemItem(baseItem.getId(), baseItem.getFile(), baseItem.getPlugin());
        return new TrMMOItemItem(baseItem, mmoItem);
    }

    public @Nullable MMOItem getMMOItem(Section itemSection) {
        if (!MMOItemsHook.isEnabled()) {
            main.getLogger().error("Cannot load item: \"" + itemSection.getName() + "\", MMOItems is not enabled. Please put MMOItems jar in the plugins folder and restart the server.");
            return null;
        }
        Section mmoSection = itemSection.getSection("MMOItem");
        String typeStr = mmoSection.getString("Type");
        Type type = Type.get(typeStr);
        if (type == null) {
            main.getLogger().error("MMOItem type " + typeStr + " not found.");
            return null;
        }
        return MMOItems.plugin.getMMOItem(type, mmoSection.getString("ID"));
    }
}
