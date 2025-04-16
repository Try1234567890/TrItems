package me.tr.trItems.item.metas;

import io.papermc.paper.potion.SuspiciousEffectEntry;
import me.tr.trItems.item.items.SuspiciousStewItem;
import org.bukkit.entity.Player;

public class SuspiciousStewMeta extends BaseMeta {


    public void setMeta(SuspiciousStewItem item, Player player) {
        super.setMeta(item, player);
        setSuspiciousEffects(item);
    }

    public void setSuspiciousEffects(SuspiciousStewItem item) {
        org.bukkit.inventory.meta.SuspiciousStewMeta suspiciousStewMeta = item.getItemMeta();
        if (suspiciousStewMeta == null) return;
        for (SuspiciousEffectEntry potionEffect : item.getSuspiciousEffects())
            suspiciousStewMeta.addCustomEffect(potionEffect, true);
        item.getStack().setItemMeta(suspiciousStewMeta);
    }

}
