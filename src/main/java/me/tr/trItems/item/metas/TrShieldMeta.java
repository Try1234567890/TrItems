package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrShieldItem;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ShieldMeta;

public class TrShieldMeta extends TrBaseMeta {

    private TrShieldMeta() {
    }


    public TrShieldMeta(TrShieldItem item) {
        super(item);
    }

    @Override
    public TrShieldItem getItem() {
        return (TrShieldItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setColor();
    }

    public void setColor() {
        ShieldMeta shieldMeta = getItem().getItemMeta();
        if (shieldMeta == null) return;
        shieldMeta.setBaseColor(getItem().getColor());
        getItem().getStack().setItemMeta(shieldMeta);
    }

    public void editColor(DyeColor color) {
        getItem().setColor(color);
        setColor();
    }

}
