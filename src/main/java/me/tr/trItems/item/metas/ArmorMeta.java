package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.ArmorItem;
import org.bukkit.entity.Player;

public class ArmorMeta extends BaseMeta {

    public void setMeta(ArmorItem item, Player player) {
        super.setMeta(item, player);
        setTrim(item);
    }

    public void setTrim(ArmorItem item) {
        org.bukkit.inventory.meta.ArmorMeta armorMeta = item.getItemMeta();
        if (armorMeta == null) return;
        armorMeta.setTrim(item.getArmorTrim());
        item.getStack().setItemMeta(armorMeta);
    }
}
