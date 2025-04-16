package me.tr.trItems.item.metas;

import me.tr.trItems.item.items.CompassItem;
import org.bukkit.entity.Player;

public class CompassMeta extends BaseMeta {

    public void setMeta(CompassItem item, Player player) {
        super.setMeta(item, player);
        setLodestone(item);
        setTrackingLodestone(item);
    }

    public void setLodestone(CompassItem item) {
        org.bukkit.inventory.meta.CompassMeta compassMeta = item.getItemMeta();
        if (compassMeta == null) return;
        compassMeta.setLodestone(item.getLodestone());
        item.getStack().setItemMeta(compassMeta);
    }

    public void setTrackingLodestone(CompassItem item) {
        org.bukkit.inventory.meta.CompassMeta compassMeta = item.getItemMeta();
        if (compassMeta == null) return;
        compassMeta.setLodestoneTracked(item.isTrackLodestone());
        item.getStack().setItemMeta(compassMeta);
    }
}
