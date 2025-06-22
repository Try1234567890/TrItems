package me.tr.trItems.item.metas;

import me.tr.trItems.item.helper.TrMapView;
import me.tr.trItems.item.items.TrMapItem;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.MapMeta;

public class TrMapMeta extends TrBaseMeta {


    private TrMapMeta() {
    }

    public TrMapMeta(TrMapItem item) {
        super(item);
    }

    @Override
    public TrMapItem getItem() {
        return (TrMapItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setMapView();
        setScaling();
        setColor();
    }

    public void setMapView() {
        MapMeta mapMeta = getItem().getItemMeta();
        if (mapMeta == null) return;
        TrMapView trMapView = getItem().getMapView();
        if (trMapView != null) {
            mapMeta.setMapView(trMapView.getMapView());
            getItem().getStack().setItemMeta(mapMeta);
        }
    }

    public void editMapView(TrMapView trMapView) {
        getItem().setMapView(trMapView);
        setMapView();
    }

    public void setScaling() {
        MapMeta mapMeta = getItem().getItemMeta();
        if (mapMeta == null) return;
        mapMeta.setScaling(getItem().isScaling());
        getItem().getStack().setItemMeta(mapMeta);
    }

    public void editScaling(boolean scaling) {
        getItem().setScaling(scaling);
        setScaling();
    }

    public void setColor() {
        MapMeta mapMeta = getItem().getItemMeta();
        if (mapMeta == null) return;
        mapMeta.setColor(getItem().getColor());
        getItem().getStack().setItemMeta(mapMeta);
    }

    public void editColor(Color color) {
        getItem().setColor(color);
        setColor();
    }
}
