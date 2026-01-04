package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrShieldItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.DyeColor;
import org.bukkit.inventory.meta.ShieldMeta;

public class TrShieldMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrShieldMeta.class.getSimpleName());
        }

        @Override
        public TrShieldMeta newInstance(TrItem item) {
            return new TrShieldMeta((TrShieldItem) item);
        }
    };

    public TrShieldMeta(TrShieldItem item) {
        super(item);
    }

    @Override
    public TrShieldItem getItem() {
        return (TrShieldItem) super.getItem();
    }

    public TrShieldMeta setColor(DyeColor color) {
        getItem().setColor(color);
        return this;
    }

    @Override
    public TrShieldItem apply() {
        ShieldMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setColor(meta);

        }

        super.apply(meta);
        return getItem();
    }


    private void setColor(ShieldMeta meta) {
        DyeColor color = meta.getBaseColor();
        DyeColor newColor = getItem().getColor();

        if (newColor == null) {
            meta.setBaseColor(null);
            return;
        }

        if (newColor.equals(color))
            return;

        meta.setBaseColor(newColor);
    }
}
