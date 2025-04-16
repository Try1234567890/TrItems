package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.OminousBottleItem;
import org.bukkit.entity.Player;

public class OminousBottleMeta extends BaseMeta {

    public void setMeta(OminousBottleItem item, Player player) {
        super.setMeta(item, player);
        setAmplifier(item);
    }

    public void setAmplifier(OminousBottleItem item) {
        org.bukkit.inventory.meta.OminousBottleMeta ominousBottleMeta = item.getItemMeta();
        if (ominousBottleMeta == null) return;
        ominousBottleMeta.setAmplifier(item.getAmplifier());
        item.getStack().setItemMeta(ominousBottleMeta);
    }


}
