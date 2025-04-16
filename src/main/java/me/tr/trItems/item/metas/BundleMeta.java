package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.BundleItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BundleMeta extends BaseMeta {


    public void setMeta(BundleItem item, Player player) {
        super.setMeta(item, player);
        setItems(item, player);
    }

    public void setItems(BundleItem item, Player player) {
        org.bukkit.inventory.meta.BundleMeta bundleMeta = item.getItemMeta();
        if (bundleMeta == null) return;
        final List<ItemStack> items = new ArrayList<>();
        for (BaseItem baseItem : item.getItems()) {
            baseItem.setMeta(player);
            items.add(baseItem.getStack());
        }
        bundleMeta.setItems(items);
        item.getStack().setItemMeta(bundleMeta);
    }
}
