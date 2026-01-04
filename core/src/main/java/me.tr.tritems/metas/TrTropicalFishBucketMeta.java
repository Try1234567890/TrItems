package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrTropicalFishBucketItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.DyeColor;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.meta.TropicalFishBucketMeta;

public class TrTropicalFishBucketMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrTropicalFishBucketMeta.class.getSimpleName());
        }

        @Override
        public TrTropicalFishBucketMeta newInstance(TrItem item) {
            return new TrTropicalFishBucketMeta((TrTropicalFishBucketItem) item);
        }
    };

    public TrTropicalFishBucketMeta(TrTropicalFishBucketItem item) {
        super(item);
    }

    @Override
    public TrTropicalFishBucketItem getItem() {
        return (TrTropicalFishBucketItem) super.getItem();
    }


    public TrTropicalFishBucketMeta setBodyColor(DyeColor bodyColor) {
        getItem().setBodyColor(bodyColor);
        return this;
    }

    public TrTropicalFishBucketMeta setPatternColor(DyeColor patternColor) {
        getItem().setPatternColor(patternColor);
        return this;
    }

    public TrTropicalFishBucketMeta setPattern(TropicalFish.Pattern pattern) {
        getItem().setPattern(pattern);
        return this;
    }


    @Override
    public TrTropicalFishBucketItem apply() {
        TropicalFishBucketMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setBodyColor(meta);
            setPatternColor(meta);
            setPattern(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setBodyColor(TropicalFishBucketMeta meta) {
        DyeColor color = meta.hasVariant() ? meta.getBodyColor() : null;
        DyeColor newColor = getItem().getBodyColor();

        if (newColor == null)
            return;

        if (newColor.equals(color))
            return;

        meta.setBodyColor(newColor);
    }

    private void setPatternColor(TropicalFishBucketMeta meta) {
        DyeColor color = meta.hasVariant() ? meta.getPatternColor() : null;
        DyeColor newColor = getItem().getPatternColor();

        if (newColor == null)
            return;

        if (newColor.equals(color))
            return;

        meta.setPatternColor(newColor);
    }

    private void setPattern(TropicalFishBucketMeta meta) {
        TropicalFish.Pattern pattern = meta.hasVariant() ? meta.getPattern() : null;
        TropicalFish.Pattern newPattern = getItem().getPattern();

        if (newPattern == null)
            return;

        if (newPattern.equals(pattern))
            return;

        meta.setPattern(newPattern);
    }

}
