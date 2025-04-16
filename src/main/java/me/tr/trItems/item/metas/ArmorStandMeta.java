package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.ArmorStandItem;
import org.bukkit.entity.Player;

public class ArmorStandMeta extends BaseMeta {

    public void setMeta(ArmorStandItem item, Player player) {
        super.setMeta(item, player);
        setInvisible(item);
        setNoBasePlate(item);
        setSmall(item);
        setMarker(item);
    }

    public void setInvisible(ArmorStandItem item) {
        com.destroystokyo.paper.inventory.meta.ArmorStandMeta armorStandMeta = item.getItemMeta();
        if (armorStandMeta == null) return;
        armorStandMeta.setInvisible(item.isInvisible());
        item.getStack().setItemMeta(armorStandMeta);
    }

    public void setNoBasePlate(ArmorStandItem item) {
        com.destroystokyo.paper.inventory.meta.ArmorStandMeta armorStandMeta = item.getItemMeta();
        if (armorStandMeta == null) return;
        armorStandMeta.setNoBasePlate(item.isNoBasePlate());
        item.getStack().setItemMeta(armorStandMeta);
    }

    public void setSmall(ArmorStandItem item) {
        com.destroystokyo.paper.inventory.meta.ArmorStandMeta armorStandMeta = item.getItemMeta();
        if (armorStandMeta == null) return;
        armorStandMeta.setSmall(item.isSmall());
        item.getStack().setItemMeta(armorStandMeta);
    }

    public void setMarker(ArmorStandItem item) {
        com.destroystokyo.paper.inventory.meta.ArmorStandMeta armorStandMeta = item.getItemMeta();
        if (armorStandMeta == null) return;
        armorStandMeta.setMarker(item.hasMarker());
        item.getStack().setItemMeta(armorStandMeta);
    }
}
