package me.tr.trItems.item.items;

import me.tr.trItems.item.helper.TrMapView;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.MapMeta;

/**
 * Represents a map item in the game.
 * This class extends BaseItem and adds map-specific properties.
 */
public class MapItem extends BaseItem {
    private TrMapView mapView;
    private boolean scaling;
    private Color color;

    /**
     * Constructs a new MapItem with the specified properties.
     *
     * @param item    The base item to inherit properties from
     * @param mapView The MapView associated with this map item
     * @param scaling Whether the map is scalable
     * @param color   The color associated with the map
     */
    public MapItem(BaseItem item, TrMapView mapView, boolean scaling, Color color) {
        super(item.getId(), item.getName(), item.getLore(), item.getNbts(), item.getEnchants(), item.getAttributes(), item.getStack(), item.getMaxAmount(), item.getDurability(), item.getCustomModelData(), item.isGlint(), item.isFireResistance(), item.isUnbreakable(), item.isHideTooltip(), item.getItemRarity(), item.getVersion(), item.isInteractable(), item.getFile(), item.getPlugin());
        this.mapView = mapView;
        this.scaling = scaling;
        this.color = color;
    }

    /**
     * Gets the MapView associated with this map item.
     *
     * @return The MapView
     */
    public TrMapView getMapView() {
        return mapView;
    }

    /**
     * Sets the MapView associated with this map item.
     *
     * @param mapView The new MapView
     */
    public void setMapView(TrMapView mapView) {
        this.mapView = mapView;
    }

    /**
     * Checks if the map is scalable.
     *
     * @return True if the map is scalable, false otherwise
     */
    public boolean isScaling() {
        return scaling;
    }

    /**
     * Sets whether the map is scalable.
     *
     * @param scaling True if the map should be scalable, false otherwise
     */
    public void setScaling(boolean scaling) {
        this.scaling = scaling;
    }

    /**
     * Gets the color associated with the map.
     *
     * @return The color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color associated with the map.
     *
     * @param color The new color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public MapMeta getItemMeta() {
        return (MapMeta) super.getItemMeta();
    }

    public void setMeta(Player player) {
        me.tr.trItems.item.metas.MapMeta meta = new me.tr.trItems.item.metas.MapMeta();
        meta.setMeta(this, player);
    }

    /**
     * Builder class for constructing MapItem instances.
     */
    public static class Builder {
        private final BaseItem baseItem;
        private TrMapView mapView;
        private boolean scaling;
        private Color color;

        /**
         * Constructs a new Builder for creating MapItem instances.
         *
         * @param baseItem The base item to inherit properties from
         */
        private Builder(BaseItem baseItem) {
            this.baseItem = baseItem;
        }

        /**
         * Sets the MapView for the MapItem being built.
         *
         * @param mapView The MapView
         * @return The current Builder instance
         */
        public Builder setMapView(TrMapView mapView) {
            this.mapView = mapView;
            return this;
        }

        /**
         * Sets whether the map is scalable for the MapItem being built.
         *
         * @param scaling True if the map should be scalable, false otherwise
         * @return The current Builder instance
         */
        public Builder setScaling(boolean scaling) {
            this.scaling = scaling;
            return this;
        }


        /**
         * Sets the color for the MapItem being built.
         *
         * @param color The color
         * @return The current Builder instance
         */
        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

        /**
         * Builds and returns a new MapItem instance with the specified properties.
         *
         * @return A new MapItem instance
         */
        public MapItem build() {
            return new MapItem(baseItem, mapView, scaling, color);
        }
    }
}
