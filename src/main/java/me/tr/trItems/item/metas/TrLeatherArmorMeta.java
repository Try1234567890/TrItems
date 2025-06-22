package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrLeatherArmorItem;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class TrLeatherArmorMeta extends TrArmorMeta {

    private TrLeatherArmorMeta() {
    }

    public TrLeatherArmorMeta(TrLeatherArmorItem item) {
        super(item);
    }

    @Override
    public TrLeatherArmorItem getItem() {
        return (TrLeatherArmorItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setColor();
    }

    public void setColor() {
        LeatherArmorMeta leatherArmorMeta = getItem().getArmorMeta();
        if (leatherArmorMeta == null) return;
        leatherArmorMeta.setColor(getItem().getColor());
        getItem().getStack().setItemMeta(leatherArmorMeta);
    }

    public void editColor(Color color) {
        getItem().setColor(color);
        setColor();
    }


}
