package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrOminousBottleItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.meta.OminousBottleMeta;

public class TrOminousBottleMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrOminousBottleMeta.class.getSimpleName());
        }

        @Override
        public TrOminousBottleMeta newInstance(TrItem item) {
            return new TrOminousBottleMeta((TrOminousBottleItem) item);
        }
    };

    public TrOminousBottleMeta(TrOminousBottleItem item) {
        super(item);
    }

    @Override
    public TrOminousBottleItem getItem() {
        return (TrOminousBottleItem) super.getItem();
    }

    public TrOminousBottleMeta setAmplifier(int amplifier) {
        getItem().setAmplifier(amplifier);
        return this;
    }

    @Override
    public TrOminousBottleItem apply() {
        OminousBottleMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setAmplifier(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setAmplifier(OminousBottleMeta meta) {
        int amplifier = meta.hasAmplifier() ? meta.getAmplifier() : 1;
        int newAmplifier = getItem().getAmplifier();

        if (newAmplifier == amplifier)
            return;

        meta.setAmplifier((newAmplifier < 0 || newAmplifier > 4) ? 1 : newAmplifier);
    }

}
