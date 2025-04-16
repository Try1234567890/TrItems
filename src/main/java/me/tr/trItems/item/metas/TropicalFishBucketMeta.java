package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TropicalFishBucketItem;
import org.bukkit.entity.Player;

public class TropicalFishBucketMeta extends BaseMeta {

    public void setMeta(TropicalFishBucketItem item, Player player) {
        super.setMeta(item, player);
        setPatternColor(item);
        setBodyColor(item);
        setTropicalFishPattern(item);
    }

    public void setPatternColor(TropicalFishBucketItem item) {
        org.bukkit.inventory.meta.TropicalFishBucketMeta tropicalFishBucketMeta = item.getItemMeta();
        if (tropicalFishBucketMeta == null) return;
        tropicalFishBucketMeta.setPatternColor(item.getPatternColor());
        item.getStack().setItemMeta(tropicalFishBucketMeta);
    }

    public void setBodyColor(TropicalFishBucketItem item) {
        org.bukkit.inventory.meta.TropicalFishBucketMeta tropicalFishBucketMeta = item.getItemMeta();
        if (tropicalFishBucketMeta == null) return;
        tropicalFishBucketMeta.setBodyColor(item.getBodyColor());
        item.getStack().setItemMeta(tropicalFishBucketMeta);
    }

    public void setTropicalFishPattern(TropicalFishBucketItem item) {
        org.bukkit.inventory.meta.TropicalFishBucketMeta tropicalFishBucketMeta = item.getItemMeta();
        if (tropicalFishBucketMeta == null) return;
        tropicalFishBucketMeta.setPattern(item.getPattern());
        item.getStack().setItemMeta(tropicalFishBucketMeta);
    }


}
