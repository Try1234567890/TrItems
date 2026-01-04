package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrMusicInstrumentItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.MusicInstrument;
import org.bukkit.inventory.meta.MusicInstrumentMeta;

public class TrMusicInstrumentMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrMusicInstrumentMeta.class.getSimpleName());
        }

        @Override
        public TrMusicInstrumentMeta newInstance(TrItem item) {
            return new TrMusicInstrumentMeta((TrMusicInstrumentItem) item);
        }
    };

    public TrMusicInstrumentMeta(TrMusicInstrumentItem item) {
        super(item);
    }

    @Override
    public TrMusicInstrumentItem getItem() {
        return (TrMusicInstrumentItem) super.getItem();
    }


    public TrMusicInstrumentMeta setInstrument(MusicInstrument instrument) {
        getItem().setInstrument(instrument);
        return this;
    }


    @Override
    public TrMusicInstrumentItem apply() {
        MusicInstrumentMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setInstrument(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setInstrument(MusicInstrumentMeta meta) {
        MusicInstrument instrument = meta.getInstrument();
        MusicInstrument newInstrument = getItem().getInstrument();

        if (newInstrument == null) {
            meta.setInstrument(null);
            return;
        }

        if (newInstrument.equals(instrument))
            return;

        meta.setInstrument(newInstrument);
    }

}
