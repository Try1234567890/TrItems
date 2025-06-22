package me.tr.trItems.item.helper;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.map.MapView;

public class TrMapView {
    private int centerX;
    private int centerZ;
    private boolean locked;
    private MapView.Scale scale;
    private World world;
    private boolean trackingPos;
    private boolean unlimitedTracking;

    public TrMapView(int centerX, int centerZ, boolean locked, MapView.Scale scale, World world, boolean trackingPos, boolean unlimitedTracking) {
        this.centerX = centerX;
        this.centerZ = centerZ;
        this.locked = locked;
        this.scale = scale;
        this.world = world;
        this.trackingPos = trackingPos;
        this.unlimitedTracking = unlimitedTracking;
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

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public boolean isTrackingPos() {
        return trackingPos;
    }

    public void setTrackingPos(boolean trackingPos) {
        this.trackingPos = trackingPos;
    }

    public boolean isUnlimitedTracking() {
        return unlimitedTracking;
    }

    public void setUnlimitedTracking(boolean unlimitedTracking) {
        this.unlimitedTracking = unlimitedTracking;
    }

    public MapView getMapView() {
        MapView mapView = Bukkit.createMap(getWorld());
        mapView.setScale(getScale());
        mapView.setCenterX(getCenterX());
        mapView.setCenterZ(getCenterZ());
        mapView.setLocked(isLocked());
        mapView.setTrackingPosition(isTrackingPos());
        mapView.setUnlimitedTracking(isUnlimitedTracking());
        return mapView;
    }

    @Override
    public String toString() {
        return "TrMapView{" +
                "centerX=" + centerX +
                ", centerZ=" + centerZ +
                ", locked=" + locked +
                ", scale=" + scale +
                ", world=" + world +
                ", trackingPos=" + trackingPos +
                ", unlimitedTracking=" + unlimitedTracking +
                '}';
    }
}
