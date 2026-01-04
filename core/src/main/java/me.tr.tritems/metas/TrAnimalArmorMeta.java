package me.tr.tritems.metas;

import me.tr.tritems.items.TrAnimalArmorItem;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class TrAnimalArmorMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrAnimalArmorMeta.class.getSimpleName());
        }

        @Override
        public TrAnimalArmorMeta newInstance(TrItem item) {
            return new TrAnimalArmorMeta((TrAnimalArmorItem) item);
        }
    };

    public TrAnimalArmorMeta(TrAnimalArmorItem item) {
        super(item);
    }

    @Override
    public TrAnimalArmorItem getItem() {
        return (TrAnimalArmorItem) super.getItem();
    }

    public TrAnimalArmorMeta setColor(TrColor color) {
        getItem().setColor(color);
        return this;
    }

    @Override
    public TrAnimalArmorItem apply() {
        LeatherArmorMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setColor(meta);

        }

        super.apply(meta);
        return getItem();
    }


    private void setColor(LeatherArmorMeta meta) {
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

}
