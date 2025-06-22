package me.tr.trItems.item.metas;

import io.papermc.paper.potion.SuspiciousEffectEntry;
import me.tr.trItems.item.items.TrSuspiciousStewItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SuspiciousStewMeta;

import java.util.List;

public class TrSuspiciousStewMeta extends TrBaseMeta {


    private TrSuspiciousStewMeta() {
    }


    public TrSuspiciousStewMeta(TrSuspiciousStewItem item) {
        super(item);
    }

    @Override
    public TrSuspiciousStewItem getItem() {
        return (TrSuspiciousStewItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setSuspiciousEffects();
    }

    public void setSuspiciousEffects() {
        SuspiciousStewMeta suspiciousStewMeta = getItem().getItemMeta();
        if (suspiciousStewMeta == null) return;
        for (SuspiciousEffectEntry potionEffect : getItem().getSuspiciousEffects())
            suspiciousStewMeta.addCustomEffect(potionEffect, true);
        getItem().getStack().setItemMeta(suspiciousStewMeta);
    }

    public void editSuspiciousEffects(List<SuspiciousEffectEntry> effects) {
        getItem().setSuspiciousEffects(effects);
        setSuspiciousEffects();
    }

}
