package me.tr.trItems.item.metas;


import me.tr.trItems.item.items.MusicInstrumentItem;
import org.bukkit.entity.Player;

public class MusicInstrumentMeta extends BaseMeta {

    public void setMeta(MusicInstrumentItem item, Player player) {
        super.setMeta(item, player);
        setMusicInstrument(item);
    }

    public void setMusicInstrument(MusicInstrumentItem item) {
        org.bukkit.inventory.meta.MusicInstrumentMeta musicMeta = item.getItemMeta();
        if (musicMeta == null) return;
        musicMeta.setInstrument(item.getMusicInstrument());
        item.getStack().setItemMeta(musicMeta);
    }

}
