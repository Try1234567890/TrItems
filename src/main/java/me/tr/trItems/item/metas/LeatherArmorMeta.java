package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.LeatherArmorItem;
import org.bukkit.entity.Player;

public class LeatherArmorMeta extends ArmorMeta {

    public void setMeta(LeatherArmorItem item, Player player) {
        super.setMeta(item, player);
        setColor(item);
    }

    public void setColor(LeatherArmorItem item) {
        org.bukkit.inventory.meta.LeatherArmorMeta leatherArmorMeta = item.getArmorMeta();
        if (leatherArmorMeta == null) return;
        leatherArmorMeta.setColor(item.getColor());
        item.getStack().setItemMeta(leatherArmorMeta);
    }


}
