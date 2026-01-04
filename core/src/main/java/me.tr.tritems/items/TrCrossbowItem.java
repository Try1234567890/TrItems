package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrCrossbowMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.Material;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrCrossbowItem extends TrItem {
    private List<TrItem> chargedProjectiles = new ArrayList<>();

    @Initialize
    protected TrCrossbowItem() {
        super(TrItemType.CROSSBOW);
    }

    public TrCrossbowItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    public List<TrItem> getChargedProjectiles() {
        return chargedProjectiles;
    }

    public void setChargedProjectiles(List<TrItem> chargedProjectiles) {
        this.chargedProjectiles = chargedProjectiles;
    }

    @Override
    public @Nullable CrossbowMeta getItemMeta() {
        return (CrossbowMeta) super.getItemMeta();
    }

    @Override
    public TrCrossbowMeta getMeta() {
        return (TrCrossbowMeta) super.getMeta();
    }

    @Override
    public String toString() {
        return super.toString() + " extends TrCrossbowItem{" +
                (!TrValidator.isNull(getChargedProjectiles()) ? "Projectiles=" + getChargedProjectiles() : "")
                + '}';
    }
}
