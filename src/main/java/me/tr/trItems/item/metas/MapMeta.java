package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.MapItem;
import org.bukkit.entity.Player;

public class MapMeta extends BaseMeta {

    public void setMeta(MapItem item, Player player) {
        super.setMeta(item, player);
        setMapView(item);
        setScaling(item);
        setColor(item);
    }

    public void setMapView(MapItem item) {
        org.bukkit.inventory.meta.MapMeta mapMeta = item.getItemMeta();
        if (mapMeta == null) return;
        mapMeta.setMapView(item.getMapView().getMapView());
        item.getStack().setItemMeta(mapMeta);
    }

    public void setScaling(MapItem item) {
        org.bukkit.inventory.meta.MapMeta mapMeta = item.getItemMeta();
        if (mapMeta == null) return;
        mapMeta.setScaling(item.isScaling());
        item.getStack().setItemMeta(mapMeta);
    }

    public void setColor(MapItem item) {
        org.bukkit.inventory.meta.MapMeta mapMeta = item.getItemMeta();
        if (mapMeta == null) return;
        mapMeta.setColor(item.getColor());
        item.getStack().setItemMeta(mapMeta);
    }
}
