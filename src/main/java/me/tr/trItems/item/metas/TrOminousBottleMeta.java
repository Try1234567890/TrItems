package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrOminousBottleItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.OminousBottleMeta;

public class TrOminousBottleMeta extends TrBaseMeta {


    private TrOminousBottleMeta() {
    }


    public TrOminousBottleMeta(TrOminousBottleItem item) {
        super(item);
    }

    @Override
    public TrOminousBottleItem getItem() {
        return (TrOminousBottleItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setAmplifier();
    }

    public void setAmplifier() {
        OminousBottleMeta ominousBottleMeta = getItem().getItemMeta();
        if (ominousBottleMeta == null) return;
        ominousBottleMeta.setAmplifier(getItem().getAmplifier());
        getItem().getStack().setItemMeta(ominousBottleMeta);
    }

    public void editAmplifier(int amplifier) {
        getItem().setAmplifier(amplifier);
        setAmplifier();
    }


}
