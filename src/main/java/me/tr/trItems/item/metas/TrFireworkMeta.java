package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrFireworkItem;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.List;

public class TrFireworkMeta extends TrBaseMeta {

    private TrFireworkMeta() {
    }

    public TrFireworkMeta(TrFireworkItem item) {
        super(item);
    }

    @Override
    public TrFireworkItem getItem() {
        return (TrFireworkItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setPower();
        setFireworkEffects();
    }

    public void setPower() {
        FireworkMeta fireworkMeta = getItem().getItemMeta();
        if (fireworkMeta == null) return;
        fireworkMeta.setPower(getItem().getPower());
        getItem().getStack().setItemMeta(fireworkMeta);
    }

    public void editPower(int power) {
        getItem().setPower(power);
        setPower();
    }

    public void setFireworkEffects() {
        FireworkMeta fireworkMeta = getItem().getItemMeta();
        if (fireworkMeta == null) return;
        fireworkMeta.addEffects(getItem().getEffects());
        getItem().getStack().setItemMeta(fireworkMeta);
    }

    public void editFireworkEffects(List<FireworkEffect> effect) {
        getItem().setEffects(effect);
        setFireworkEffects();
    }

}
