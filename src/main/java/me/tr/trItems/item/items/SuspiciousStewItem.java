package me.tr.trItems.item.items;

import io.papermc.paper.potion.SuspiciousEffectEntry;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.SuspiciousStewMeta;

import java.util.List;

public class SuspiciousStewItem extends BaseItem {
    private List<SuspiciousEffectEntry> suspiciousEffects;
    // todo comments


    public SuspiciousStewItem(BaseItem item, List<SuspiciousEffectEntry> suspiciousEffects) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.suspiciousEffects = suspiciousEffects;
    }

    public List<SuspiciousEffectEntry> getSuspiciousEffects() {
        return suspiciousEffects;
    }

    public void setSuspiciousType(List<SuspiciousEffectEntry> suspiciousEffects) {
        this.suspiciousEffects = suspiciousEffects;
    }

    public SuspiciousStewMeta getItemMeta() {
        return (SuspiciousStewMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.SuspiciousStewMeta meta = new me.tr.trItems.item.metas.SuspiciousStewMeta();
        meta.setMeta(this, player);
    }

}
