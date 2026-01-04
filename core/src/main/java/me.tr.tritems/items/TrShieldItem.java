package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrShieldMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ShieldMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrShieldItem extends TrItem {
    private DyeColor color;

    @Initialize
    protected TrShieldItem() {
        super(TrItemType.SHIELD);
    }

    public TrShieldItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public @Nullable ShieldMeta getItemMeta() {
        return (ShieldMeta) super.getItemMeta();
    }

    @Override
    public TrShieldMeta getMeta() {
        return (TrShieldMeta) super.getMeta();
    }

    public DyeColor getColor() {
        return color;
    }

    public void setColor(DyeColor color) {
        this.color = color;
    }
}
