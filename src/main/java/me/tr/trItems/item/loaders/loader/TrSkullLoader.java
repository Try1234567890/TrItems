package me.tr.trItems.item.loaders.loader;

import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.ItemManager;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrSkullItem;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

public class TrSkullLoader extends TrBaseLoader {

    public TrSkullItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        OfflinePlayer offlinePlayer = getOfflinePlayer(itemSection);
        NamespacedKey skullNoteBlockSound = getSkullNoteBlockSound(itemSection);
        return new TrSkullItem(baseItem, offlinePlayer, skullNoteBlockSound);
    }


    public OfflinePlayer getOfflinePlayer(Section itemSection) {
        String playerName = itemSection.getString("Owner");
        return Bukkit.getOfflinePlayer(playerName);
    }

    public NamespacedKey getSkullNoteBlockSound(Section itemSection) {
        String soundKeyStr = itemSection.getString("NoteBlockSound");
        return ItemManager.getInstance().parseNamespacedKey(soundKeyStr);
    }

}
