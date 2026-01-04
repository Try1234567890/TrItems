package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrCompassMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.meta.CompassMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrCompassItem extends TrItem {
    private Location lodestone;
    private boolean lodestoneTracked;

    @Initialize
    protected TrCompassItem() {
        super(TrItemType.COMPASS);
    }

    public TrCompassItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    public Location getLodestone() {
        return lodestone;
    }

    public void setLodestone(Location lodestone) {
        this.lodestone = lodestone;
    }

    public boolean isLodestoneTracked() {
        return lodestoneTracked;
    }

    public void setLodestoneTracked(boolean lodestoneTracked) {
        this.lodestoneTracked = lodestoneTracked;
    }

    @Override
    public @Nullable CompassMeta getItemMeta() {
        return (CompassMeta) super.getItemMeta();
    }

    @Override
    public TrCompassMeta getMeta() {
        return (TrCompassMeta) super.getMeta();
    }

    @Override
    public String toString() {
        return super.toString() + " extends TrCompassTrim{" +
                (!TrValidator.isNull(getLodestone()) ? "Lodestone=" + getLodestone().toString() : "")
                + ", LodestoneTracked=" + isLodestoneTracked()
                + '}';
    }
}
