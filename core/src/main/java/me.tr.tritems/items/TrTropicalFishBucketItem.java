package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrTropicalFishBucketMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.meta.TropicalFishBucketMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrTropicalFishBucketItem extends TrItem {
    private DyeColor bodyColor;
    private DyeColor patternColor;
    private TropicalFish.Pattern pattern;

    @Initialize
    protected TrTropicalFishBucketItem() {
        super(TrItemType.TROPICAL_FISH_BUCKET);
    }

    public TrTropicalFishBucketItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrTropicalFishBucketMeta getMeta() {
        return (TrTropicalFishBucketMeta) super.getMeta();
    }

    @Override
    public @Nullable TropicalFishBucketMeta getItemMeta() {
        return (TropicalFishBucketMeta) super.getItemMeta();
    }

    public DyeColor getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(DyeColor bodyColor) {
        this.bodyColor = bodyColor;
    }

    public DyeColor getPatternColor() {
        return patternColor;
    }

    public void setPatternColor(DyeColor patternColor) {
        this.patternColor = patternColor;
    }

    public TropicalFish.Pattern getPattern() {
        return pattern;
    }

    public void setPattern(TropicalFish.Pattern pattern) {
        this.pattern = pattern;
    }
}
