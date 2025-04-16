package me.tr.trItems.item.loaders.loader;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import me.tr.configuration.Section;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.MusicInstrumentItem;
import org.bukkit.MusicInstrument;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

public class MusicInstrumentLoader extends BaseLoader {

    public MusicInstrumentItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        MusicInstrument musicInstrument = getMusicInstrument(itemSection);
        return new MusicInstrumentItem(baseItem, musicInstrument);
    }

    public MusicInstrument getMusicInstrument(Section itemSection) {
        String musicInstrumentName = itemSection.getString("MusicInstrument");
        NamespacedKey key = main.getItemManager().getNamespacedKey(musicInstrumentName);
        MusicInstrument musicInstrument = RegistryAccess.registryAccess().getRegistry(RegistryKey.INSTRUMENT).get(key);
        if (musicInstrument == null)
            throw new NullPointerException("Could not find music instrument " + musicInstrumentName);
        return musicInstrument;
    }


}
