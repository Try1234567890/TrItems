package me.tr.trItems.item.loaders.loader;

import me.tr.configuration.Section;
import me.tr.trItems.item.helper.TrMapView;
import me.tr.trItems.item.items.BaseItem;
import me.tr.trItems.item.items.MapItem;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.World;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;

public class MapLoader extends BaseLoader {


    public MapItem load(Plugin plugin, Section itemSection) {
        BaseItem baseItem = super.load(plugin, itemSection);
        TrMapView mapView = getMapView(itemSection);
        boolean scaling = getScaling(itemSection);
        Color color = getColor(itemSection);
        return new MapItem(baseItem, mapView, scaling, color);
    }

    public Color getColor(Section itemSection) {
        String colorStr = itemSection.getString("Color");
        return main.getItemLoaderManager().convertColor(colorStr);
    }

    public boolean getScaling(Section itemSection) {
        return itemSection.getBoolean("Scaling");
    }

    public TrMapView getMapView(Section itemSection) {
        int centerX = getCenterX(itemSection);
        int centerZ = getCenterZ(itemSection);
        boolean locked = getLocked(itemSection);
        MapView.Scale scale = getScale(itemSection);
        World world = getWorld(itemSection);
        boolean trackingPos = getTrackingPos(itemSection);
        boolean unlimitedTracking = getUnlimitedTracking(itemSection);
        return new TrMapView(centerX, centerZ, locked, scale, world, trackingPos, unlimitedTracking);
    }

    public MapView.Scale getScale(Section itemSection) {
        String scalingStr = itemSection.getString("Scale");
        if (scalingStr == null) return null;
        try {
            return MapView.Scale.valueOf(scalingStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Scaling " + scalingStr + " is not a valid.");
        }
    }

    public World getWorld(Section itemSection) {
        String worldName = itemSection.getString("World");
        World world = Bukkit.getWorld(worldName);
        return world != null ? world : Bukkit.getWorlds().getFirst();
    }

    public int getCenterX(Section itemSection) {
        return itemSection.getInt("CenterX");
    }

    public int getCenterZ(Section itemSection) {
        return itemSection.getInt("CenterZ");
    }

    public boolean getLocked(Section itemSection) {
        return itemSection.getBoolean("Locked");
    }

    public boolean getUnlimitedTracking(Section itemSection) {
        return itemSection.getBoolean("UnlimitedTracking");
    }

    public boolean getTrackingPos(Section itemSection) {
        return itemSection.getBoolean("TrackingPos");
    }
}
