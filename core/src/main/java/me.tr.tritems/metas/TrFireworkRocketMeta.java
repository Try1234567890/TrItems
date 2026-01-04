package me.tr.tritems.metas;

import me.tr.tritems.items.TrFireworkRocketItem;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.TrFireworkEffect;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.List;

public class TrFireworkRocketMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrFireworkRocketMeta.class.getSimpleName());
        }

        @Override
        public TrFireworkRocketMeta newInstance(TrItem item) {
            return new TrFireworkRocketMeta((TrFireworkRocketItem) item);
        }
    };

    public TrFireworkRocketMeta(TrFireworkRocketItem item) {
        super(item);
    }

    @Override
    public TrFireworkRocketItem getItem() {
        return (TrFireworkRocketItem) super.getItem();
    }


    public TrFireworkRocketMeta setEffects(List<TrFireworkEffect> effects) {
        getItem().setEffects(effects);
        return this;
    }

    public TrFireworkRocketMeta addEffects(List<TrFireworkEffect> effects) {
        getItem().addEffects(effects);
        return this;
    }

    public TrFireworkRocketMeta addEffects(TrFireworkEffect... effects) {
        getItem().addEffects(List.of(effects));
        return this;
    }

    public TrFireworkRocketMeta setPower(int power) {
        getItem().setPower(power);
        return this;
    }

    @Override
    public TrFireworkRocketItem apply() {
        FireworkMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setPower(meta);
            setEffects(meta);

        }

        super.apply(meta);
        return getItem();
    }


    private void setPower(FireworkMeta meta) {
        int power = meta.getPower();
        int newPower = Math.min(255, Math.max(1, getItem().getPower()));

        if (newPower == power)
            return;


        meta.setPower(newPower);
    }

    private void setEffects(FireworkMeta meta) {
        for (int i = 0; i < meta.getEffects().size(); i++)
            meta.removeEffect(i);

        List<TrFireworkEffect> newEffects = getItem().getEffects();

        if (newEffects == null || newEffects.isEmpty()) {
            // Effects already removed
            return;
        }

        for (TrFireworkEffect effect : newEffects) {
            if (effect == null)
                continue;
            meta.addEffect(effect.toBukkit());
        }

    }

}
