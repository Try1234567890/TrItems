package me.tr.tritems.metas;

import me.tr.tritems.items.TrCompassItem;
import me.tr.tritems.items.TrItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Location;
import org.bukkit.inventory.meta.CompassMeta;

public class TrCompassMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrCompassMeta.class.getSimpleName());
        }

        @Override
        public TrCompassMeta newInstance(TrItem item) {
            return new TrCompassMeta((TrCompassItem) item);
        }
    };

    public TrCompassMeta(TrCompassItem item) {
        super(item);
    }

    @Override
    public TrCompassItem getItem() {
        return (TrCompassItem) super.getItem();
    }

    public TrCompassMeta setLodestone(Location lodestone) {
        getItem().setLodestone(lodestone);
        return this;
    }

    public TrCompassMeta setLodestoneTracked(boolean lodestoneTracked) {
        getItem().setLodestoneTracked(lodestoneTracked);
        return this;
    }

    @Override
    public TrCompassItem apply() {

        CompassMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setLodestone(meta);
            setTracked(meta);

        }

        super.apply(meta);
        return getItem();
    }

    private void setLodestone(CompassMeta meta) {
        Location lodestone = meta.getLodestone();
        Location newLodestone = getItem().getLodestone();

        if (newLodestone == null) {
            meta.setLodestone(null);
            return;
        }

        if (newLodestone.equals(lodestone)) {
            return;
        }

        meta.setLodestone(newLodestone);
    }

    private void setTracked(CompassMeta meta) {
        boolean tracked = meta.isLodestoneTracked();
        boolean newTracked = getItem().isLodestoneTracked();

        if (newTracked == tracked)
            return;

        meta.setLodestoneTracked(newTracked);
    }

}
