package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrFireworkStarMeta;
import me.tr.tritems.properties.TrFireworkEffect;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrFireworkStarItem extends TrItem {
    private TrFireworkEffect effect;

    @Initialize
    protected TrFireworkStarItem() {
        super(TrItemType.FIREWORK_STAR);
    }

    public TrFireworkStarItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }


    @Override
    public TrFireworkStarMeta getMeta() {
        return (TrFireworkStarMeta) super.getMeta();
    }

    @Override
    public @Nullable FireworkEffectMeta getItemMeta() {
        return (FireworkEffectMeta) super.getItemMeta();
    }

    public TrFireworkEffect getEffect() {
        return effect;
    }

    public void setEffect(TrFireworkEffect effect) {
        this.effect = effect;
    }
}
