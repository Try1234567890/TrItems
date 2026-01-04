package me.tr.tritems.metas;

import me.tr.tritems.items.TrItem;
import me.tr.tritems.items.TrSpawnEggItem;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class TrSpawnEggMeta extends TrItemMeta {
    public static final TrItemMetaEntry ENTRY = new TrItemMetaEntry() {
        @Override
        public TrIdentifier identifier() {
            return new TrIdentifier(TrSpawnEggMeta.class.getSimpleName());
        }

        @Override
        public TrSpawnEggMeta newInstance(TrItem item) {
            return new TrSpawnEggMeta((TrSpawnEggItem) item);
        }
    };


    public TrSpawnEggMeta(TrSpawnEggItem item) {
        super(item);
    }

    @Override
    public TrSpawnEggItem getItem() {
        return (TrSpawnEggItem) super.getItem();
    }

    public TrSpawnEggMeta setEntityType(EntityType entityType) {
        getItem().setEntityType(entityType);
        return this;
    }

    @Override
    public TrSpawnEggItem apply() {
        SpawnEggMeta meta = getItem().getItemMeta();

        if (meta != null) {

            setCustomSpawnedType(meta);

        }

        super.apply(meta);
        return getItem();
    }


    private void setCustomSpawnedType(SpawnEggMeta meta) {
        EntityType type = meta.getCustomSpawnedType();
        EntityType newType = getItem().getEntityType();

        if (newType == null) {
            meta.setCustomSpawnedType(null);
            return;
        }

        if (newType.equals(type))
            return;

        meta.setCustomSpawnedType(newType);
    }
}
