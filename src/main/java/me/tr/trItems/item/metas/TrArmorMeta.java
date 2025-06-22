package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrArmorItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;

public class TrArmorMeta extends TrBaseMeta {

    protected TrArmorMeta() {
    }

    public TrArmorMeta(TrArmorItem item) {
        super(item);
    }

    @Override
    public TrArmorItem getItem() {
        return (TrArmorItem) super.getItem();
    }


    public void setMeta(Player player) {
        super.setMeta(player);
        setTrim();
    }

    public void setTrim() {
        ArmorMeta armorMeta = getItem().getItemMeta();
        if (armorMeta == null) return;
        armorMeta.setTrim(getItem().getArmorTrim());
        getItem().getStack().setItemMeta(armorMeta);
    }

    public void editTrim(ArmorTrim trim) {
        getItem().setArmorTrim(trim);
        setTrim();
    }
}
