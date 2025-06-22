package me.tr.trItems.item.metas;

import com.destroystokyo.paper.inventory.meta.ArmorStandMeta;
import me.tr.trItems.item.items.TrArmorStandItem;
import org.bukkit.entity.Player;

public class TrArmorStandMeta extends TrBaseMeta {

    private TrArmorStandMeta() {
    }

    public TrArmorStandMeta(TrArmorStandItem item) {
        super(item);
    }

    @Override
    public TrArmorStandItem getItem() {
        return (TrArmorStandItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setInvisible();
        setNoBasePlate();
        setSmall();
        setMarker();
    }

    public void setInvisible() {
        ArmorStandMeta armorStandMeta = getItem().getItemMeta();
        if (armorStandMeta == null) return;
        armorStandMeta.setInvisible(getItem().isInvisible());
        getItem().getStack().setItemMeta(armorStandMeta);
    }

    public void editInvisible(boolean invisible) {
        getItem().setInvisible(invisible);
        setInvisible();
    }

    public void setNoBasePlate() {
        ArmorStandMeta armorStandMeta = getItem().getItemMeta();
        if (armorStandMeta == null) return;
        armorStandMeta.setNoBasePlate(getItem().isNoBasePlate());
        getItem().getStack().setItemMeta(armorStandMeta);
    }

    public void editNoBasePlate(boolean noBasePlate) {
        getItem().setNoBasePlate(noBasePlate);
        setNoBasePlate();
    }

    public void setSmall() {
        ArmorStandMeta armorStandMeta = getItem().getItemMeta();
        if (armorStandMeta == null) return;
        armorStandMeta.setSmall(getItem().isSmall());
        getItem().getStack().setItemMeta(armorStandMeta);
    }

    public void editSmall(boolean small) {
        getItem().setSmall(small);
        setSmall();
    }

    public void setMarker() {
        ArmorStandMeta armorStandMeta = getItem().getItemMeta();
        if (armorStandMeta == null) return;
        armorStandMeta.setMarker(getItem().hasMarker());
        getItem().getStack().setItemMeta(armorStandMeta);
    }

    public void editMarker(boolean marker) {
        getItem().setMarker(marker);
        setMarker();
    }
}
