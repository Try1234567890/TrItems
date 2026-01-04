package me.tr.tritems.metas;

import me.tr.tritems.items.TrArmorItem;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;

public class TrArmorMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrArmorMeta.class.getSimpleName());
        }

        @Override
        public TrArmorMeta newInstance(TrItem item) {
            return new TrArmorMeta((TrArmorItem) item);
        }
    };

    public TrArmorMeta(TrArmorItem item) {
        super(item);
    }

    @Override
    public TrArmorItem getItem() {
        return (TrArmorItem) super.getItem();
    }

    public TrArmorMeta setTrim(ArmorTrim trim) {
        getItem().setTrim(trim);
        return this;
    }

    @Override
    public TrArmorItem apply() {
        ArmorMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setTrim(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setTrim(ArmorMeta meta) {
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
