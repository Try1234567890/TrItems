package me.tr.trItems.item.items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.OminousBottleMeta;

public class OminousBottleItem extends BaseItem {
    private int amplifier;
    // todo comments

    public OminousBottleItem(BaseItem item, int amplifier) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.amplifier = amplifier;
    }

    public int getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(int amplifier) {
        this.amplifier = amplifier;
    }

    public OminousBottleMeta getItemMeta() {
        return (OminousBottleMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.OminousBottleMeta meta = new me.tr.trItems.item.metas.OminousBottleMeta();
        meta.setMeta(this, player);
    }


}
