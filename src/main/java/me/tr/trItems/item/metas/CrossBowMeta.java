package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.CrossBowItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

import java.util.ArrayList;
import java.util.List;

public class CrossBowMeta extends BaseMeta {

    public void setMeta(CrossBowItem item, Player player) {
        super.setMeta(item, player);
        setProjectiles(item, player);
    }

    public void setProjectiles(CrossBowItem item, Player player) {
        CrossbowMeta crossbowMeta = item.getItemMeta();
        if (crossbowMeta == null) return;
        final List<ItemStack> projectiles = new ArrayList<>();
        for (BaseItem baseItem : item.getItems()) {
            baseItem.setMeta(player);
            projectiles.add(baseItem.getStack());
        }
        crossbowMeta.setChargedProjectiles(projectiles);
        item.getStack().setItemMeta(crossbowMeta);
    }
}
