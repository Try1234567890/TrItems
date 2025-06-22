package me.tr.trItems.item.loaders.loader;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.trFiles.configuration.Section;
import me.tr.trItems.item.ItemManager;
import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrMusicInstrumentItem;
import org.bukkit.MusicInstrument;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

public class TrMusicInstrumentLoader extends TrBaseLoader {

    public TrMusicInstrumentItem load(Plugin plugin, Section itemSection) {
        TrBaseItem baseItem = super.load(plugin, itemSection);
        MusicInstrument musicInstrument = getMusicInstrument(itemSection);
        return new TrMusicInstrumentItem(baseItem, musicInstrument);
    }

    public MusicInstrument getMusicInstrument(Section itemSection) {
        String musicInstrumentName = itemSection.getString("MusicInstrument");
        NamespacedKey key = ItemManager.getInstance().parseNamespacedKey(musicInstrumentName);
        MusicInstrument musicInstrument = RegistryAccess.registryAccess().getRegistry(RegistryKey.INSTRUMENT).get(key);
        if (musicInstrument == null)
            throw new NullPointerException("Could not find music instrument " + musicInstrumentName);
        return musicInstrument;
    }


}
