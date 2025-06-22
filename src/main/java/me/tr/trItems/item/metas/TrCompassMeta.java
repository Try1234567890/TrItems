package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.TrCompassItem;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.CompassMeta;

public class TrCompassMeta extends TrBaseMeta {

    private TrCompassMeta() {
    }

    public TrCompassMeta(TrCompassItem item) {
        super(item);
    }

    @Override
    public TrCompassItem getItem() {
        return (TrCompassItem) super.getItem();
    }

    public void setMeta(Player player) {
        super.setMeta(player);
        setLodestone();
        setTrackingLodestone();
    }

    public void setLodestone() {
        CompassMeta compassMeta = getItem().getItemMeta();
        if (compassMeta == null) return;
        compassMeta.setLodestone(getItem().getLodestone());
        getItem().getStack().setItemMeta(compassMeta);
    }

    public void editLodestone(Location location) {
        getItem().setLodestone(location);
        setLodestone();
    }

    public void setTrackingLodestone() {
        CompassMeta compassMeta = getItem().getItemMeta();
        if (compassMeta == null) return;
        compassMeta.setLodestoneTracked(getItem().isTrackLodestone());
        getItem().getStack().setItemMeta(compassMeta);
    }

    public void editTrackingLodestone(Location location) {
        getItem().setLodestone(location);
        setTrackingLodestone();
    }
}
