package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrSkullItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.meta.SkullMeta;

public class TrSkullMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrSkullMeta.class.getSimpleName());
        }

        @Override
        public TrSkullMeta newInstance(TrItem item) {
            return new TrSkullMeta((TrSkullItem) item);
        }
    };

    public TrSkullMeta(TrSkullItem item) {
        super(item);
    }

    @Override
    public TrSkullItem getItem() {
        return (TrSkullItem) super.getItem();
    }

    public TrSkullMeta setSound(NamespacedKey sound) {
        getItem().setSound(sound);
        return this;
    }

    public TrSkullMeta setSkullOwner(OfflinePlayer skullOwner) {
        getItem().setSkullOwner(skullOwner);
        return this;
    }

    @Override
    public TrSkullItem apply() {
        SkullMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setOwningPlayer(meta);
            setNoteBlockSound(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setOwningPlayer(SkullMeta meta) {
        OfflinePlayer offPlayer = meta.getOwningPlayer();
        OfflinePlayer newOffPlayer = getItem().getSkullOwner();

        if (newOffPlayer == null) {
            meta.setOwningPlayer(null);
            return;
        }

        if (newOffPlayer.equals(offPlayer))
            return;

        meta.setOwningPlayer(newOffPlayer);
    }

    private void setNoteBlockSound(SkullMeta meta) {
        NamespacedKey sound = meta.getNoteBlockSound();
        NamespacedKey newSound = getItem().getSound();

        if (newSound == null) {
            meta.setNoteBlockSound(null);
            return;
        }

        if (newSound.equals(sound))
            return;

        meta.setNoteBlockSound(newSound);
    }

}
