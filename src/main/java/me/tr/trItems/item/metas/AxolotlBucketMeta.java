package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.AxolotlBucketItem;
import org.bukkit.entity.Player;

public class AxolotlBucketMeta extends BaseMeta {

    public void setMeta(AxolotlBucketItem item, Player player) {
        super.setMeta(item, player);
        setAxolotlVariant(item);
    }

    public void setAxolotlVariant(AxolotlBucketItem item) {
        org.bukkit.inventory.meta.AxolotlBucketMeta axolotlBucketMeta = item.getItemMeta();
        if (axolotlBucketMeta == null) return;
        axolotlBucketMeta.setVariant(item.getVariant());
        item.getStack().setItemMeta(axolotlBucketMeta);
    }

}
