package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrTropicalFishBucketItem;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.meta.TropicalFishBucketMeta;

public class TrTropicalFishBucketMeta extends TrBaseMeta {


    private TrTropicalFishBucketMeta() {
    }


    public TrTropicalFishBucketMeta(TrTropicalFishBucketItem item) {
        super(item);
    }

    @Override
    public TrTropicalFishBucketItem getItem() {
        return (TrTropicalFishBucketItem) super.getItem();
    }


    public void setMeta(Player player) {
        super.setMeta(player);
        setPatternColor();
        setBodyColor();
        setTropicalFishPattern();
    }

    public void setPatternColor() {
        TropicalFishBucketMeta tropicalFishBucketMeta = getItem().getItemMeta();
        if (tropicalFishBucketMeta == null) return;
        DyeColor patternColor = getItem().getPatternColor();
        if (patternColor != null) {
            tropicalFishBucketMeta.setPatternColor(patternColor);
            getItem().getStack().setItemMeta(tropicalFishBucketMeta);
        }
    }

    public void editPatternColor(DyeColor color) {
        getItem().setPatternColor(color);
        setPatternColor();
    }

    public void setBodyColor() {
        TropicalFishBucketMeta tropicalFishBucketMeta = getItem().getItemMeta();
        if (tropicalFishBucketMeta == null) return;
        DyeColor bodyColor = getItem().getBodyColor();
        if (bodyColor != null) {
            tropicalFishBucketMeta.setBodyColor(bodyColor);
            getItem().getStack().setItemMeta(tropicalFishBucketMeta);
        }
    }

    public void editBodyColor(DyeColor color) {
        getItem().setBodyColor(color);
        setBodyColor();
    }

    public void setTropicalFishPattern() {
        TropicalFishBucketMeta tropicalFishBucketMeta = getItem().getItemMeta();
        if (tropicalFishBucketMeta == null) return;
        TropicalFish.Pattern pattern = getItem().getPattern();
        if (pattern != null) {
            tropicalFishBucketMeta.setPattern(pattern);
            getItem().getStack().setItemMeta(tropicalFishBucketMeta);
        }
    }

    public void editTropicalFishPattern(TropicalFish.Pattern pattern) {
        getItem().setPattern(pattern);
        setTropicalFishPattern();
    }


}
