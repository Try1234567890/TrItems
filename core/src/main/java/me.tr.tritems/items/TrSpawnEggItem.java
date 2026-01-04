package me.tr.tritems.items;

import me.tr.serializer.annotations.Initialize;
import me.tr.tritems.metas.TrSpawnEggMeta;
import me.tr.tritems.properties.identification.TrIdentifier;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.meta.SpawnEggMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrSpawnEggItem extends TrItem {
    private EntityType entityType;


    @Initialize
    protected TrSpawnEggItem() {
        super(TrItemType.SPAWN_EGG);
    }

    public TrSpawnEggItem(TrIdentifier identifier, @NotNull Material material) {
        super(identifier, material);
    }

    @Override
    public TrSpawnEggMeta getMeta() {
        return (TrSpawnEggMeta) super.getMeta();
    }

    @Override
    public @Nullable SpawnEggMeta getItemMeta() {
        return (SpawnEggMeta) super.getItemMeta();
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }
}
