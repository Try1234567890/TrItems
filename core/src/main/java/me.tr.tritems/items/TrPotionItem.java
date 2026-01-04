package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrPotionMeta;
import me.tr.tritems.properties.TrPotionEffect;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrPotionItem extends TrItem {
    private List<TrPotionEffect> effects = new ArrayList<>();
    private PotionType basePotionType;
    private TrColor color;
    private String customName;

    @Initialize
    protected TrPotionItem() {
        super(TrItemType.POTION);
    }

    public TrPotionItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrPotionMeta getMeta() {
        return (TrPotionMeta) super.getMeta();
    }

    @Override
    public @Nullable PotionMeta getItemMeta() {
        return (PotionMeta) super.getItemMeta();
    }

    public List<TrPotionEffect> getEffects() {
        return effects;
    }

    public void setEffects(List<TrPotionEffect> effects) {
        this.effects = effects;
    }

    public void addEffects(List<TrPotionEffect> effects) {
        this.effects.addAll(effects);
    }

    public void addEffects(TrPotionEffect... effects) {
        this.effects.addAll(List.of(effects));
    }

    public TrColor getColor() {
        return color;
    }

    public void setColor(TrColor color) {
        this.color = color;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public PotionType getBasePotionType() {
        return basePotionType;
    }

    public void setBasePotionType(PotionType basePotionType) {
        this.basePotionType = basePotionType;
    }
}
