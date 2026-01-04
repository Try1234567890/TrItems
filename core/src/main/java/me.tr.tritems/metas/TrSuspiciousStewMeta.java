package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrSuspiciousStewItem;
import me.tr.tritems.properties.TrSuspiciousEffectEntry;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.meta.SuspiciousStewMeta;

import java.util.List;

public class TrSuspiciousStewMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrSuspiciousStewMeta.class.getSimpleName());
        }

        @Override
        public TrSuspiciousStewMeta newInstance(TrItem item) {
            return new TrSuspiciousStewMeta((TrSuspiciousStewItem) item);
        }
    };

    public TrSuspiciousStewMeta(TrSuspiciousStewItem item) {
        super(item);
    }

    @Override
    public TrSuspiciousStewItem getItem() {
        return (TrSuspiciousStewItem) super.getItem();
    }


    public TrSuspiciousStewMeta setEffects(List<TrSuspiciousEffectEntry> effects) {
        getItem().setEffects(effects);
        return this;
    }

    public TrSuspiciousStewMeta addEffects(List<TrSuspiciousEffectEntry> effects) {
        getItem().addEffects(effects);
        return this;
    }

    public TrSuspiciousStewMeta addEffects(TrSuspiciousEffectEntry... effects) {
        getItem().addEffects(effects);
        return this;
    }

    @Override
    public TrSuspiciousStewItem apply() {
        SuspiciousStewMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setEffects(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setEffects(SuspiciousStewMeta meta) {
        meta.clearCustomEffects();
        List<TrSuspiciousEffectEntry> newEffects = getItem().getEffects();

        if (newEffects == null || newEffects.isEmpty())
            return;

        for (TrSuspiciousEffectEntry effect : newEffects) {

            if (effect == null)
                continue;

            meta.addCustomEffect(effect.toBukkit(), effect.isOverwrite());
        }
    }

}
