package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrLeatherArmorMeta;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ColorableArmorMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.jetbrains.annotations.NotNull;

public class TrLeatherArmorItem extends TrItem {
    private ArmorTrim trim;
    private TrColor color;

    @Initialize
    protected TrLeatherArmorItem() {
        super(TrItemType.LEATHER_ARMOR);
    }

    public TrLeatherArmorItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrLeatherArmorMeta getMeta() {
        return (TrLeatherArmorMeta) super.getMeta();
    }

    @Override
    public ColorableArmorMeta getItemMeta() {
        return (ColorableArmorMeta) super.getItemMeta();
    }

    public TrColor getColor() {
        return color;
    }

    public void setColor(TrColor color) {
        this.color = color;
    }

    public ArmorTrim getTrim() {
        return trim;
    }

    public void setTrim(ArmorTrim trim) {
        this.trim = trim;
    }
}
