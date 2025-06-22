package me.tr.trItems.item.metas;


import me.tr.trItems.item.items.TrMusicInstrumentItem;
import org.bukkit.MusicInstrument;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.MusicInstrumentMeta;

public class TrMusicInstrumentMeta extends TrBaseMeta {


    private TrMusicInstrumentMeta() {
    }

    public TrMusicInstrumentMeta(TrMusicInstrumentItem item) {
        super(item);
    }


    @Override
    public TrMusicInstrumentItem getItem() {
        return (TrMusicInstrumentItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setMusicInstrument();
    }

    public void setMusicInstrument() {
        MusicInstrumentMeta musicMeta = getItem().getItemMeta();
        if (musicMeta == null) return;
        musicMeta.setInstrument(getItem().getMusicInstrument());
        getItem().getStack().setItemMeta(musicMeta);
    }

    public void editMusicInstrument(MusicInstrument musicInstrument) {
        getItem().setMusicInstrument(musicInstrument);
        setMusicInstrument();
    }

}
