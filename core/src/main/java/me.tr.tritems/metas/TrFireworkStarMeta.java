package me.tr.tritems.metas;

import me.tr.tritems.items.TrFireworkStarItem;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.TrFireworkEffect;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkEffectMeta;

public class TrFireworkStarMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrFireworkStarMeta.class.getSimpleName());
        }

        @Override
        public TrFireworkStarMeta newInstance(TrItem item) {
            return new TrFireworkStarMeta((TrFireworkStarItem) item);
        }
    };


    public TrFireworkStarMeta(TrFireworkStarItem item) {
        super(item);
    }

    @Override
    public TrFireworkStarItem getItem() {
        return (TrFireworkStarItem) super.getItem();
    }

    public TrFireworkStarMeta setEffect(TrFireworkEffect effect) {
        getItem().setEffect(effect);
        return this;
    }

    @Override
    public TrFireworkStarItem apply() {
        FireworkEffectMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setEffect(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setEffect(FireworkEffectMeta meta) {
        FireworkEffect effect = meta.getEffect();
        TrFireworkEffect newTrEffect = getItem().getEffect();

        if (newTrEffect == null) {
            meta.setEffect(null);
            return;
        }

        FireworkEffect newEffect = newTrEffect.toBukkit();

        if (newEffect.equals(effect))
            return;

        meta.setEffect(newEffect);
    }

}
