package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrLeatherArmorItem;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Color;
import org.bukkit.inventory.meta.ColorableArmorMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;

public class TrLeatherArmorMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrLeatherArmorMeta.class.getSimpleName());
        }

        @Override
        public TrLeatherArmorMeta newInstance(TrItem item) {
            return new TrLeatherArmorMeta((TrLeatherArmorItem) item);
        }
    };

    public TrLeatherArmorMeta(TrLeatherArmorItem item) {
        super(item);
    }

    @Override
    public TrLeatherArmorItem getItem() {
        return (TrLeatherArmorItem) super.getItem();
    }

    public TrLeatherArmorMeta setTrim(ArmorTrim trim) {
        getItem().setTrim(trim);
        return this;
    }

    public TrLeatherArmorMeta setColor(TrColor color) {
        getItem().setColor(color);
        return this;
    }

    @Override
    public TrLeatherArmorItem apply() {
        ColorableArmorMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setColor(meta);
            setTrim(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setColor(ColorableArmorMeta meta) {
        TrColor color = getItem().getColor();
        Color newColor = color == null ? null : color.toColor();

        if (newColor == null) {
            meta.setColor(null);
            return;
        }

        if (newColor.equals(meta.getColor()))
            return;

        meta.setColor(newColor);
    }

    private void setTrim(ColorableArmorMeta meta) {
        ArmorTrim trim = meta.getTrim();
        ArmorTrim newTrim = getItem().getTrim();

        if (newTrim == null) {
            meta.setTrim(null);
            return;
        }

        if (newTrim.equals(trim)) {
            return;
        }

        meta.setTrim(newTrim);
    }


}
