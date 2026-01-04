package me.tr.tritems.metas;

import me.tr.tritems.formatter.TrItemFormatter;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrPotionItem;
import me.tr.tritems.properties.TrPotionEffect;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Color;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import java.util.List;

public class TrPotionMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrPotionMeta.class.getSimpleName());
        }

        @Override
        public TrPotionMeta newInstance(TrItem item) {
            return new TrPotionMeta((TrPotionItem) item);
        }
    };

    public TrPotionMeta(TrPotionItem item) {
        super(item);
    }

    @Override
    public TrPotionItem getItem() {
        return (TrPotionItem) super.getItem();
    }


    public TrPotionMeta setEffects(List<TrPotionEffect> effects) {
        getItem().setEffects(effects);
        return this;
    }

    public TrPotionMeta addEffects(List<TrPotionEffect> effects) {
        getItem().addEffects(effects);
        return this;
    }

    public TrPotionMeta addEffects(TrPotionEffect... effects) {
        getItem().addEffects(effects);
        return this;
    }

    public TrPotionMeta setColor(TrColor color) {
        getItem().setColor(color);
        return this;
    }

    public TrPotionMeta setCustomName(String customName) {
        getItem().setCustomName(customName);
        return this;
    }

    public TrPotionMeta setBasePotionType(PotionType basePotionType) {
        getItem().setBasePotionType(basePotionType);
        return this;
    }

    @Override
    public TrPotionItem apply() {
        PotionMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setEffects(meta);
            setColor(meta);
            setCustomPotionName(meta);
            setBasePotionType(meta);

        }


        super.apply(meta);
        return getItem();
    }

    private void setEffects(PotionMeta meta) {
        meta.clearCustomEffects();
        List<TrPotionEffect> newEffects = getItem().getEffects();

        if (newEffects == null)
            return;

        newEffects.forEach(effect -> meta.addCustomEffect(effect.toBukkit(), effect.isOverwrite()));
    }

    private void setColor(PotionMeta meta) {
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

    private void setCustomPotionName(PotionMeta meta) {
        String customName = meta.getCustomPotionName();
        String newCustomName = getItem().getCustomName();

        if (newCustomName == null) {
            meta.setCustomPotionName(null);
            return;
        }

        if (newCustomName.equals(customName))
            return;

        meta.setCustomPotionName(TrItemFormatter.formatAsString(newCustomName));
    }

    private void setBasePotionType(PotionMeta meta) {
        PotionType type = meta.getBasePotionType();
        PotionType newType = getItem().getBasePotionType();

        if (newType == null) {
            meta.setBasePotionType(null);
            return;
        }

        if (newType.equals(type))
            return;

        meta.setBasePotionType(newType);
    }


}
