package me.tr.tritems.items;

import me.tr.tritems.metas.TrAnimalArmorMeta;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrAnimalArmorItem extends TrItem {
    private TrColor color;

    protected TrAnimalArmorItem() {
        super(TrItemType.ANIMAL_ARMOR);
    }

    public TrAnimalArmorItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public @Nullable LeatherArmorMeta getItemMeta() {
        return (LeatherArmorMeta) super.getItemMeta();
    }

    @Override
    public TrAnimalArmorMeta getMeta() {
        return (TrAnimalArmorMeta) super.getMeta();
    }

    public TrColor getColor() {
        return color;
    }

    public void setColor(TrColor color) {
        this.color = color;
    }
}
