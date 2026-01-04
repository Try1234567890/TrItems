package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrSuspiciousStewMeta;
import me.tr.tritems.properties.TrSuspiciousEffectEntry;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.inventory.meta.SuspiciousStewMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrSuspiciousStewItem extends TrItem {
    private List<TrSuspiciousEffectEntry> effects = new ArrayList<>();


    @Initialize
    protected TrSuspiciousStewItem() {
        super(TrItemType.SUSPICIOUS_STEW);
    }

    public TrSuspiciousStewItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrSuspiciousStewMeta getMeta() {
        return (TrSuspiciousStewMeta) super.getMeta();
    }

    @Override
    public @Nullable SuspiciousStewMeta getItemMeta() {
        return (SuspiciousStewMeta) super.getItemMeta();
    }

    public List<TrSuspiciousEffectEntry> getEffects() {
        return effects;
    }

    public void setEffects(List<TrSuspiciousEffectEntry> effects) {
        this.effects = effects;
    }

    public void addEffects(List<TrSuspiciousEffectEntry> effects) {
        this.effects.addAll(effects);
    }

    public void addEffects(TrSuspiciousEffectEntry... effects) {
        this.effects.addAll(List.of(effects));
    }
}
