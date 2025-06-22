package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrCrossBowItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

import java.util.ArrayList;
import java.util.List;

public class TrCrossBowMeta extends TrBaseMeta {

    private TrCrossBowMeta() {
    }

    public TrCrossBowMeta(TrCrossBowItem item) {
        super(item);
    }

    @Override
    public TrCrossBowItem getItem() {
        return (TrCrossBowItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setProjectiles(player);
    }

    public void setProjectiles(Player player) {
        CrossbowMeta crossbowMeta = getItem().getItemMeta();
        if (crossbowMeta == null) return;
        final List<ItemStack> projectiles = new ArrayList<>();
        for (TrBaseItem projectile : getItem().getProjectiles()) {
            projectile.setMeta(player);
            projectiles.add(projectile.getStack());
        }
        crossbowMeta.setChargedProjectiles(projectiles);
        getItem().getStack().setItemMeta(crossbowMeta);
    }

    public void editProjectiles(List<TrBaseItem> items, Player player) {
        getItem().setProjectiles(items);
        setProjectiles(player);
    }

}
