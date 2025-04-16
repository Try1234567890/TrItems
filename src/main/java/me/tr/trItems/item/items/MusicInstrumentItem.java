package me.tr.trItems.item.items;

import org.bukkit.MusicInstrument;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.MusicInstrumentMeta;

public class MusicInstrumentItem extends BaseItem {
    private MusicInstrument musicInstrument;
    // todo comments

    public MusicInstrumentItem(BaseItem item, MusicInstrument musicInstrument) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.musicInstrument = musicInstrument;
    }

    public MusicInstrument getMusicInstrument() {
        return musicInstrument;
    }

    public void setMusicInstrument(MusicInstrument musicInstrument) {
        this.musicInstrument = musicInstrument;
    }

    public MusicInstrumentMeta getItemMeta() {
        return (MusicInstrumentMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.MusicInstrumentMeta meta = new me.tr.trItems.item.metas.MusicInstrumentMeta();
        meta.setMeta(this, player);
    }


}
