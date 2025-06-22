package me.tr.trItems.item.items;

import me.tr.trItems.item.metas.TrMusicInstrumentMeta;
import org.bukkit.MusicInstrument;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.MusicInstrumentMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * Represents a music instrument item in the game.
 * This class extends TrBaseItem and adds functionality specific to music instruments.
 */
public class TrMusicInstrumentItem extends TrBaseItem {

    private @Nullable MusicInstrument musicInstrument;


    /**
     * Constructs a new TrMusicInstrumentItem with the specified base item and music instrument.
     *
     * @param item            The base item to inherit properties from
     * @param musicInstrument The music instrument associated with this item
     */
    public TrMusicInstrumentItem(TrBaseItem item, @Nullable MusicInstrument musicInstrument) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.musicInstrument = musicInstrument;
    }

    /**
     * Constructs a new TrMusicInstrumentItem with the specified id.
     *
     * @param id     The id of this item
     * @param file   The file where this item is stored
     * @param plugin The plugin that this item belongs to
     */
    public TrMusicInstrumentItem(String id, File file, Plugin plugin) {
        super(id, file, plugin);
    }

    /**
     * Gets the music instrument associated with this item.
     *
     * @return The music instrument
     */
    public @Nullable MusicInstrument getMusicInstrument() {
        return musicInstrument;
    }

    /**
     * Sets the music instrument associated with this item.
     *
     * @param musicInstrument The new music instrument
     */
    public void setMusicInstrument(@Nullable MusicInstrument musicInstrument) {
        this.musicInstrument = musicInstrument;
    }

    /**
     * Gets the item meta for this music instrument item.
     *
     * @return The MusicInstrumentMeta associated with this item
     */
    @Override
    public MusicInstrumentMeta getItemMeta() {
        return (MusicInstrumentMeta) super.getItemMeta();
    }

    /**
     * Sets the meta for this music instrument item based on the specified player.
     *
     * @param player The player to set the meta for
     */
    @Override
    public void setMeta(Player player) {
        TrMusicInstrumentMeta meta = new TrMusicInstrumentMeta(this);
        meta.setMeta(player);
    }

    public static class Builder extends TrBaseItem.Builder {
        private MusicInstrument musicInstrument;

        /**
         * Constructs a new Builder for creating a TrMusicInstrumentItem.
         *
         * @param id     The id of this item
         * @param file   The file where this item is stored
         * @param plugin The plugin that this item belongs to
         */
        public Builder(String id, File file, Plugin plugin) {
            super(id, file, plugin);
        }

        /**
         * Sets the music instrument for this item.
         *
         * @param musicInstrument The music instrument to set
         * @return The builder instance
         */
        public Builder musicInstrument(MusicInstrument musicInstrument) {
            this.musicInstrument = musicInstrument;
            return this;
        }

        /**
         * Builds the TrMusicInstrumentItem with the specified properties.
         *
         * @return The constructed TrMusicInstrumentItem
         */
        public TrMusicInstrumentItem build() {
            return new TrMusicInstrumentItem(super.build(), musicInstrument);
        }
    }
}