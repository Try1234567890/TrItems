package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrMusicInstrumentMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.MusicInstrument;
import org.bukkit.inventory.meta.MusicInstrumentMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrMusicInstrumentItem extends TrItem {
    private MusicInstrument instrument;

    @Initialize
    protected TrMusicInstrumentItem() {
        super(TrItemType.MUSIC_INSTRUMENT);
    }

    public TrMusicInstrumentItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrMusicInstrumentMeta getMeta() {
        return (TrMusicInstrumentMeta) super.getMeta();
    }

    @Override
    public @Nullable MusicInstrumentMeta getItemMeta() {
        return (MusicInstrumentMeta) super.getItemMeta();
    }


    public MusicInstrument getInstrument() {
        return instrument;
    }

    public void setInstrument(MusicInstrument instrument) {
        this.instrument = instrument;
    }
}
