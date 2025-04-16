package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.SkullItem;
import org.bukkit.entity.Player;

public class SkullMeta extends BaseMeta {

    public void setMeta(SkullItem item, Player player) {
        super.setMeta(item, player);
        setOwner(item);
        setNoteBlockSound(item);
    }


    public void setOwner(SkullItem item) {
        org.bukkit.inventory.meta.SkullMeta skullMeta = item.getItemMeta();
        if (skullMeta == null) return;
        skullMeta.setOwningPlayer(item.getPlayer());
        item.getStack().setItemMeta(skullMeta);
    }

    public void setNoteBlockSound(SkullItem item) {
        org.bukkit.inventory.meta.SkullMeta skullMeta = item.getItemMeta();
        if (skullMeta == null) return;
        skullMeta.setNoteBlockSound(item.getNoteBlockSound());
        item.getStack().setItemMeta(skullMeta);
    }
}
