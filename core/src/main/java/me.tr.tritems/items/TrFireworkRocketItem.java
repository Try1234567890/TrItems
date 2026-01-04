package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrFireworkRocketMeta;
import me.tr.tritems.properties.TrFireworkEffect;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.inventory.meta.FireworkMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrFireworkRocketItem extends TrItem {
    private List<TrFireworkEffect> effects = new ArrayList<>();
    private int power;

    @Initialize
    protected TrFireworkRocketItem() {
        super(TrItemType.FIREWORK_ROCKET);
    }

    public TrFireworkRocketItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }


    @Override
    public @Nullable FireworkMeta getItemMeta() {
        return (FireworkMeta) super.getItemMeta();
    }

    @Override
    public TrFireworkRocketMeta getMeta() {
        return (TrFireworkRocketMeta) super.getMeta();
    }

    public List<TrFireworkEffect> getEffects() {
        return effects;
    }

    public void setEffects(List<TrFireworkEffect> effects) {
        this.effects = effects;
    }

    public void addEffects(List<TrFireworkEffect> effects) {
        this.effects.addAll(effects);
    }

    public void addEffects(TrFireworkEffect... effects) {
        this.effects.addAll(List.of(effects));
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
