package me.tr.trItems.item.items;

import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ShieldMeta;

public class ShieldItem extends BaseItem {
    private DyeColor color;
    // todo comments

    public ShieldItem(BaseItem item, DyeColor color) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }

    public void setColor(DyeColor color) {
        this.color = color;
    }

    public ShieldMeta getItemMeta() {
        return (ShieldMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.ShieldMeta meta = new me.tr.trItems.item.metas.ShieldMeta();
        meta.setMeta(this, player);
    }
}
