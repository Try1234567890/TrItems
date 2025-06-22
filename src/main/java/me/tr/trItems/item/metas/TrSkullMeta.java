package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrSkullItem;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SkullMeta;

public class TrSkullMeta extends TrBaseMeta {


    private TrSkullMeta() {
    }


    public TrSkullMeta(TrSkullItem item) {
        super(item);
    }

    @Override
    public TrSkullItem getItem() {
        return (TrSkullItem) super.getItem();
    }


    public void setMeta(Player player) {
        super.setMeta(player);
        setOwner();
        setNoteBlockSound();
    }


    public void setOwner() {
        SkullMeta skullMeta = getItem().getItemMeta();
        if (skullMeta == null) return;
        skullMeta.setOwningPlayer(getItem().getOwner());
        getItem().getStack().setItemMeta(skullMeta);
    }

    public void editOwner(OfflinePlayer player) {
        getItem().setOwner(player);
        setOwner();
    }

    public void setNoteBlockSound() {
        SkullMeta skullMeta = getItem().getItemMeta();
        if (skullMeta == null) return;
        skullMeta.setNoteBlockSound(getItem().getNoteBlockSound());
        getItem().getStack().setItemMeta(skullMeta);
    }

    public void editNoteBlockSound(NamespacedKey sound) {
        getItem().setNoteBlockSound(sound);
        setNoteBlockSound();
    }
}
