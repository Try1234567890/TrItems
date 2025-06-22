package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrBaseItem;
import me.tr.trItems.item.items.TrBundleItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BundleMeta;

import java.util.ArrayList;
import java.util.List;

public class TrBundleMeta extends TrBaseMeta {

    private TrBundleMeta() {
    }

    public TrBundleMeta(TrBundleItem item) {
        super(item);
    }

    @Override
    public TrBundleItem getItem() {
        return (TrBundleItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setItems(player);
    }

    public void setItems(Player player) {
        BundleMeta bundleMeta = getItem().getItemMeta();
        if (bundleMeta == null) return;
        final List<ItemStack> items = new ArrayList<>();
        for (TrBaseItem baseItem : getItem().getItems()) {
            baseItem.setMeta(player);
            items.add(baseItem.getStack());
        }
        bundleMeta.setItems(items);
        getItem().getStack().setItemMeta(bundleMeta);
    }

    public void editItems(List<TrBaseItem> items, Player player) {
        getItem().setItems(items);
        setItems(player);
    }
}
