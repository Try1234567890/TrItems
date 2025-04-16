package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.ShieldItem;
import org.bukkit.entity.Player;

public class ShieldMeta extends BaseMeta {

    public void setMeta(ShieldItem item, Player player) {
        super.setMeta(item, player);
        setColor(item);
    }

    public void setColor(ShieldItem item) {
        org.bukkit.inventory.meta.ShieldMeta shieldMeta = item.getItemMeta();
        if (shieldMeta == null) return;
        shieldMeta.setBaseColor(item.getColor());
        item.getStack().setItemMeta(shieldMeta);
    }


}
