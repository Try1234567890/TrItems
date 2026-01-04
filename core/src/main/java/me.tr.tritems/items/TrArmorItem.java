package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrArmorMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.jetbrains.annotations.NotNull;

public class TrArmorItem extends TrItem {
    private ArmorTrim trim;

    @Initialize
    protected TrArmorItem() {
        super(TrItemType.ARMOR);
    }

    protected TrArmorItem(TrItemType type) {
        super(type);
    }

    public TrArmorItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    public ArmorTrim getTrim() {
        return trim;
    }

    public void setTrim(ArmorTrim trim) {
        this.trim = trim;
    }

    @Override
    public ArmorMeta getItemMeta() {
        return (ArmorMeta) super.getItemMeta();
    }

    @Override
    public TrArmorMeta getMeta() {
        return (TrArmorMeta) super.getMeta();
    }

    @Override
    public String toString() {
        return super.toString() + " extends TrArmorItem{" +
                (!TrValidator.isNull(getTrim()) ? "Trim=" + getTrim() : "") +
                '}';
    }
}













