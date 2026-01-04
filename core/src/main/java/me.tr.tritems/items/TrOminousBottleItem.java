package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrOminousBottleMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.inventory.meta.OminousBottleMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrOminousBottleItem extends TrItem {
    private int amplifier;

    @Initialize
    protected TrOminousBottleItem() {
        super(TrItemType.OMINOUS_BOTTLE);
    }

    public TrOminousBottleItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }


    @Override
    public TrOminousBottleMeta getMeta() {
        return (TrOminousBottleMeta) super.getMeta();
    }

    @Override
    public @Nullable OminousBottleMeta getItemMeta() {
        return (OminousBottleMeta) super.getItemMeta();
    }

    public int getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(int amplifier) {
        this.amplifier = amplifier;
    }
}
