package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrMapMeta;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrMapItem extends TrItem {
    private TrColor color;
    private boolean scaling;
    private int centerX;
    private int centerZ;
    private boolean locked;
    private MapView.Scale scale;
    private boolean trackingPosition;
    private boolean unlimitedTracking;
    private World world;

    @Initialize
    protected TrMapItem() {
        super(TrItemType.MAP);
    }

    public TrMapItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrMapMeta getMeta() {
        return (TrMapMeta) super.getMeta();
    }

    @Override
    public @Nullable MapMeta getItemMeta() {
        return (MapMeta) super.getItemMeta();
    }

    public TrColor getColor() {
        return color;
    }

    public void setColor(TrColor color) {
        this.color = color;
    }

    public boolean isScaling() {
        return scaling;
    }

    public void setScaling(boolean scaling) {
        this.scaling = scaling;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterZ() {
        return centerZ;
    }

    public void setCenterZ(int centerZ) {
        this.centerZ = centerZ;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public MapView.Scale getScale() {
        return scale;
    }

    public void setScale(MapView.Scale scale) {
        this.scale = scale;
    }

    public boolean isTrackingPosition() {
        return trackingPosition;
    }

    public void setTrackingPosition(boolean trackingPosition) {
        this.trackingPosition = trackingPosition;
    }

    public boolean isUnlimitedTracking() {
        return unlimitedTracking;
    }

    public void setUnlimitedTracking(boolean unlimitedTracking) {
        this.unlimitedTracking = unlimitedTracking;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
