package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.SkullItem;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

public class SkullLoader extends BaseLoader {

    public SkullItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        OfflinePlayer offlinePlayer = getOfflinePlayer(itemSection);
        NamespacedKey skullNoteBlockSound = getSkullNoteBlockSound(itemSection);
        return new SkullItem(baseItem, offlinePlayer, skullNoteBlockSound);
    }


    public OfflinePlayer getOfflinePlayer(Section itemSection) {
        String playerName = itemSection.getString("Owner");
        return Bukkit.getOfflinePlayer(playerName);
    }

    public NamespacedKey getSkullNoteBlockSound(Section itemSection) {
        String soundKeyStr = itemSection.getString("NoteBlockSound");
        return main.getItemManager().getNamespacedKey(soundKeyStr);
    }

}
