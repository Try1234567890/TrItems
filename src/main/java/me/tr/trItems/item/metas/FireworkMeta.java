package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.FireworkItem;
import org.bukkit.entity.Player;

public class FireworkMeta extends BaseMeta {


    public void setMeta(FireworkItem item, Player player) {
        super.setMeta(item, player);
        setPower(item);
        setFireworkEffect(item);
    }

    public void setPower(FireworkItem item) {
        org.bukkit.inventory.meta.FireworkMeta fireworkMeta = item.getItemMeta();
        if (fireworkMeta == null) return;
        fireworkMeta.setPower(item.getPower());
        item.getStack().setItemMeta(fireworkMeta);
    }

    public void setFireworkEffect(FireworkItem item) {
        org.bukkit.inventory.meta.FireworkMeta fireworkMeta = item.getItemMeta();
        if (fireworkMeta == null) return;
        fireworkMeta.addEffects(item.getEffect());
        item.getStack().setItemMeta(fireworkMeta);
    }

}
