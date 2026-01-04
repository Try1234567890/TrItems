package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrMapItem;
import me.tr.tritems.properties.color.TrColor;
import me.tr.tritems.properties.identification.TrIdentifier;
import me.tr.tritems.utility.TrValidator;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.World;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

public class TrMapMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrMapMeta.class.getSimpleName());
        }

        @Override
        public TrMapMeta newInstance(TrItem item) {
            return new TrMapMeta((TrMapItem) item);
        }
    };

    public TrMapMeta(TrMapItem item) {
        super(item);
    }

    @Override
    public TrMapItem getItem() {
        return (TrMapItem) super.getItem();
    }


    public TrMapMeta setColor(TrColor color) {
        getItem().setColor(color);
        return this;
    }

    public TrMapMeta setScaling(boolean scaling) {
        getItem().setScaling(scaling);
        return this;
    }

    public TrMapMeta setCenterX(int centerX) {
        getItem().setCenterX(centerX);
        return this;
    }

    public TrMapMeta setCenterZ(int centerZ) {
        getItem().setCenterZ(centerZ);
        return this;
    }

    public TrMapMeta setLocked(boolean locked) {
        getItem().setLocked(locked);
        return this;
    }

    public TrMapMeta setScale(MapView.Scale scale) {
        getItem().setScale(scale);
        return this;
    }

    public TrMapMeta setTrackingPosition(boolean tackingPosition) {
        getItem().setTrackingPosition(tackingPosition);
        return this;
    }


    public TrMapMeta setUnlimitedTracking(boolean unlimitedTracking) {
        getItem().setUnlimitedTracking(unlimitedTracking);
        return this;
    }


    public TrMapMeta setWorld(World world) {
        getItem().setWorld(world);
        return this;
    }

    @Override
    public TrMapItem apply() {
        MapMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setColor(meta);
            setScaling(meta);
            setMapView(meta);

        }

        super.apply(meta);
        return getItem();
    }


    private void setColor(MapMeta meta) {
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

    private void setScaling(MapMeta meta) {
        boolean scaling = meta.isScaling();
        boolean newScaling = getItem().isScaling();

        if (newScaling == scaling)
            return;

        meta.setScaling(newScaling);
    }

    private void setMapView(MapMeta meta) {
        World world = getItem().getWorld();

        if (TrValidator.isNull(world, "The provided world for map: " + getItem().getIdentifier() + " is null."))
            return;

        MapView view = Bukkit.createMap(world);

        setCenterX(view);
        setCenterZ(view);
        setLocked(view);
        setScale(view);
        setTrackingPosition(view);
        setUnlimitedTracking(view);

        meta.setMapView(view);
    }

    private void setCenterX(MapView view) {
        int centerX = view.getCenterX();
        int newCenterX = getItem().getCenterX();

        if (newCenterX == centerX)
            return;

        view.setCenterX(centerX);
    }


    private void setCenterZ(MapView view) {
        int centerZ = view.getCenterZ();
        int newCenterZ = getItem().getCenterZ();

        if (newCenterZ == centerZ)
            return;

        view.setCenterZ(centerZ);
    }

    private void setLocked(MapView view) {
        boolean locked = view.isLocked();
        boolean newLocked = getItem().isLocked();

        if (newLocked == locked)
            return;

        view.setLocked(newLocked);
    }

    private void setScale(MapView view) {
        MapView.Scale scale = view.getScale();
        MapView.Scale newScale = getItem().getScale();

        if (newScale == null) {
            view.setScale(MapView.Scale.NORMAL);
            return;
        }

        if (newScale.equals(scale))
            return;

        view.setScale(newScale);
    }

    private void setTrackingPosition(MapView view) {
        boolean trackingPosition = view.isTrackingPosition();
        boolean newTrackingPosition = getItem().isTrackingPosition();

        if (newTrackingPosition == trackingPosition)
            return;

        view.setTrackingPosition(newTrackingPosition);
    }

    private void setUnlimitedTracking(MapView view) {
        boolean trackingPosition = view.isUnlimitedTracking();
        boolean newUnlimitedTracking = getItem().isUnlimitedTracking();

        if (newUnlimitedTracking == trackingPosition)
            return;

        view.setUnlimitedTracking(newUnlimitedTracking);
    }

}
